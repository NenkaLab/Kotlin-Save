package your_package

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View


/**
 * --------RunScript--------
 * Created by nenka
 * Date : 2018-03-11 (3월 / 일요일)
 * Time : 오후 1:27
 * ---------------------------
 */
class Divider(private val context: Context?): DividerInterface {

	private var line: View? = null
	private var lineColor: Int? = null
	private var view: View? = null

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
		val v = li.inflate(R.layout.divider, null)
		line = v.findViewById(R.id.view1)
		view = v
	}

	override fun setColor(color: Int) {
		line!!.setBackgroundColor(color)
		lineColor = color
	}

	override fun getColor(): Int {
		return lineColor!!
	}

	override fun getView(): View {
		return view!!
	}
}
