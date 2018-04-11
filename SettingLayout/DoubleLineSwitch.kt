package your_package

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView



class DoubleLineSwitch(private val context: Context?): DoubleLineSwitchInterface {

	private var title: TextView? = null
	private var content: TextView? = null
	private var switch: Switch? = null
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
		val v = li.inflate(R.layout.double_line_switch, null)
		title = v.findViewById(R.id.textView)
		content = v.findViewById(R.id.textView2)
		switch = v.findViewById(R.id.switch3)
		view = v as ViewGroup
		title!!.isClickable = false
		content!!.isClickable = false
		title!!.isLongClickable = false
		content!!.isLongClickable = false
		view!!.setOnTouchListener { _, event -> switch!!.onTouchEvent(event) }
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

	override fun setChecked(boolean: Boolean) {
		switch!!.isChecked = boolean
	}

	override fun setOnCheckedChangeListener(listener: CompoundButton.OnCheckedChangeListener) {
		switch!!.setOnCheckedChangeListener(listener)
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

	override fun getChecked(): Boolean {
		return switch!!.isChecked
	}

	override fun getView(): View {
		return view!!
	}
}
