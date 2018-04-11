package your_package

import android.view.View


interface LineHeaderInterface {

	fun setHeaderText(charSequence: CharSequence)
	fun setHeaderText(resource: Int)

	fun getHeaderText(): CharSequence

	fun setInfoText(charSequence: CharSequence)
	fun setInfoText(resource: Int)

	fun getInfoText(): CharSequence

	fun setHeaderTextColor(color: Int)

	fun getHeaderTextColor(): Int

	fun setInfoTextColor(color: Int)

	fun getInfoTextColor(): Int

	fun getView(): View
}
