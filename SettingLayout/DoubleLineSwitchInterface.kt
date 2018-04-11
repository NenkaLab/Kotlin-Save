package your_package

import android.view.View
import android.widget.CompoundButton


interface DoubleLineSwitchInterface {

	fun setTitleText(charSequence: CharSequence)
	fun setTitleText(resource: Int)

	fun setContentText(charSequence: CharSequence)
	fun setContentText(resource: Int)

	fun setTitleTextColor(color: Int)

	fun setContentTextColor(color: Int)

	fun setChecked(boolean: Boolean)

	fun setOnCheckedChangeListener(listener: CompoundButton.OnCheckedChangeListener)

	fun getTitleText(): CharSequence

	fun getContentText(): CharSequence

	fun getTitleTextColor(): Int

	fun getContentTextColor(): Int

	fun getChecked(): Boolean

	fun getView(): View
}
