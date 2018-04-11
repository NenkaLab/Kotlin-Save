package your_package

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView



class LineHeader(private val context: Context?): LineHeaderInterface {

	private var text: TextView? = null
	private var info: TextView? = null
	private var view: View? = null

	private var textColor: Int? = null
	private var textColor2: Int? = null

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
		val v = li.inflate(R.layout.line_header, null)
		text = v.findViewById(R.id.textView3)
		info = v.findViewById(R.id.textView4)
		info!!.visibility = View.GONE
		view = v
	}

	override fun setHeaderText(charSequence: CharSequence) {
		text!!.text = charSequence
	}

	override fun setHeaderText(resource: Int) {
		text!!.setText(resource)
	}

	override fun getHeaderText(): CharSequence {
		return text!!.text
	}

	override fun setInfoText(charSequence: CharSequence) {
		info!!.text = charSequence
		if(charSequence.isNotEmpty()) info!!.visibility = View.VISIBLE
		else info!!.visibility = View.GONE
	}

	override fun setInfoText(resource: Int) {
		info!!.setText(resource)
		if(context!!.resources.getString(resource).isNotEmpty()) info!!.visibility = View.VISIBLE
		else info!!.visibility = View.GONE
	}

	override fun getInfoText(): CharSequence {
		if(info!!.visibility == View.GONE) throw Exception("Not Visible View")
		return info!!.text
	}

	override fun setHeaderTextColor(color: Int) {
		text!!.setTextColor(color)
		textColor = color
	}

	override fun getHeaderTextColor(): Int {
		return textColor!!
	}

	override fun setInfoTextColor(color: Int) {
		info!!.setTextColor(color)
		textColor2 = color
	}

	override fun getInfoTextColor(): Int {
		return textColor2!!
	}

	override fun getView(): View {
		return view!!
	}
}
