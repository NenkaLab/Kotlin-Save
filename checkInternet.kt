@Suppress("DEPRECATION")
fun checkInternet(): Boolean{
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
    val wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
    return try{
        mobile.isConnected or wifi.isConnected
    }catch (e: NetworkErrorException){
        try{
            wifi.isConnected
        }catch (e: NetworkErrorException){
            false
        }
    }
}
