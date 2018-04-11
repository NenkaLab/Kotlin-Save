package your_package

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



class DoubleLineText(private val context: Context?): DoubleLineTextInterface {

	private var title: TextView? = null
	private var content: TextView? = null
	private var click: View? = null
	private var view: ViewGroup? = null

	private var titlecolor: Int? = null
	private var contentcolor: Int? = null

	init {
		if(context == null) {
			throw IllegalArgumentException("context must not be null")
		}
		`init`()
	}

	@SuppressLint("InflateParams")
	private fun `init`(){
		val infService = Context.LAYOUT_INFLATER_SERVICE
		val li = context!!.getSystemService(infService) as LayoutInflater
		val v = li.inflate(R.layout.double_line_text, null)
		title = v.findViewById(R.id.textView)
		content = v.findViewById(R.id.textView2)
		click = v.findViewById(R.id.click1)
		view = v as ViewGroup
		title!!.isClickable = false
		content!!.isClickable = false
		title!!.isLongClickable = false
		content!!.isLongClickable = false
		view!!.setOnTouchListener { _, event -> click!!.onTouchEvent(event) }
	}

	override fun setTitleText(charSequence: CharSequence) {
		title!!.text = charSequence
	}

	override fun setTitleText(resource: Int) {
		title!!.setText(resource)
	}

	override fun setContentText(charSequence: CharSequence) {
		content!!.text = charSequence
	}

	override fun setContentText(resource: Int) {
		content!!.setText(resource)
	}

	override fun setTitleTextColor(color: Int) {
		title!!.setTextColor(color)
		titlecolor = color
	}

	override fun setContentTextColor(color: Int) {
		content!!.setTextColor(color)
		contentcolor = color
	}

	override fun setOnClickListener(listener: View.OnClickListener) {
		click!!.setOnClickListener(listener)
	}

	override fun setOnLongClickListener(listener: View.OnLongClickListener) {
		click!!.setOnLongClickListener(listener)
	}

	override fun getTitleText(): CharSequence {
		return title!!.text
	}

	override fun getContentText(): CharSequence {
		return content!!.text
	}

	override fun getTitleTextColor(): Int {
		return titlecolor!!
	}

	override fun getContentTextColor(): Int {
		return contentcolor!!
	}

	override fun getClickView(): View {
		return click!!
	}

	override fun getView(): View {
		return view!!
	}
}
