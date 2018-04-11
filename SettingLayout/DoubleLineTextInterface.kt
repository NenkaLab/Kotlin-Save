package your_package

import android.view.View


interface DoubleLineTextInterface {

	fun setTitleText(charSequence: CharSequence)
	fun setTitleText(resource: Int)

	fun setContentText(charSequence: CharSequence)
	fun setContentText(resource: Int)

	fun setTitleTextColor(color: Int)

	fun setContentTextColor(color: Int)

	fun setOnClickListener(listener: View.OnClickListener)

	fun setOnLongClickListener(listener: View.OnLongClickListener)

	fun getTitleText(): CharSequence

	fun getContentText(): CharSequence

	fun getTitleTextColor(): Int

	fun getContentTextColor(): Int

	fun getClickView(): View

	fun getView(): View
}
