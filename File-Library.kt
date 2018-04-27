import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.nio.ByteBuffer
import java.util.zip.ZipInputStream


/**
 *  File Library (https://github.com/DarkTornado/ModPE-Library/blob/master/File%20Library.js)
 *  @version 2.1
 *  @copyright 2016-2017 Dark Tornado, All rights reserved.
 *  void File.copy(String path1, String path2, boolean useNioPackage);
 *  void File.copyFolder(String path1, String path2, boolean useNioPackage);
 *  void File.copyFromWeb(String url, String path);
 *  void File.createFile(String path);
 *  void File.createFolder(String path);
 *  void File.download(String path, String file, String url);
 *  Boolean File.exists(String path);
 *  File[] File.getList(String path);
 *  Boolean File.isFile(String path);
 *  Boolean File.isFolder(String path);
 *  void File.move(String path1, String path2);
 *  String File.read(String path);
 *  String File.readFromWeb(String url);
 *  void File.remove(String path);
 *  void File.removeFolder(String path);
 *  void File.unZip(String path1, String path2, Boolean makeFolder);
 *  void File.write(String path, String value);
 */
@Suppress("unused")
class FileUtils {
	companion object {

		/**
		 * @param path
		 */
		fun createFolder(path: String): Boolean {
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			return File(path).mkdirs()
		}

		/**
		 * @param path
		 */
		fun createFile(path: String): Boolean {
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			return File(path).createNewFile()
		}

		/**
		 * @param path
		 * @param value
		 */
		@Throws(IOException::class, IllegalArgumentException::class)
		fun write(path: String, value: String){
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			val writer = FileWriter(File(path))
			writer.write(value)
			writer.close()
		}

		/**
		 * @param path
		 */
		fun read(path: String): String {
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			val reader = FileReader(File(path))
			return reader.readLines().joinToString("\n")
		}

		/**
		 * @param path
		 */
		fun delete(path: String): Boolean {
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			return File(path).delete()
		}

		/**
		 * @param path
		 */
		fun getList(path: String): Array<String> {
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			val file = File(path)
			val dir = file.list()
			dir.sort()
			val dir2 = arrayOf<String>()
			val dir3 = arrayOf<String>()
			for(n in dir) {
				val ff = File("$path/$n")
				if(ff.isDirectory) dir2.plus(n)
				else dir3.plus(n)
			}
			for(n in dir3)
			dir2.plus(n)
			return dir2
		}


		/**
		 * @param path
		 */
		@Suppress("MemberVisibilityCanBePrivate")
		fun removeFolder(path: String): Boolean {
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			val folder = File(path)
			val list = folder.listFiles()
			for(a in list){
				if(a.isDirectory) removeFolder(a.path)
				else a.delete()
			}
			return folder.delete()
		}

		/**
		 * @param zip
		 * @param path
		 */
		fun unZip(zip: String, path: String){
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			val fis = FileInputStream(File(zip))
			val zis = ZipInputStream(fis)
			while (true){
				val entry = zis.nextEntry ?: break
				val fos = FileOutputStream(path+"/"+entry.name)
				val buf = ByteBuffer.allocate(1024).array()
				while (true){
					val len = zis.read(buf)
					if(len > 0) fos.write(buf, 0, len)
					else break
				}
				zis.closeEntry()
				fos.close()
			}
			zis.close()
		}

		/**
		 * @param context
		 * @param path
		 * @param filename
		 * @param url
		 */
		fun download(context: Context, path: String, filename: String, url: String){
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			if(filename.isEmpty()) throw IllegalArgumentException("Can't find the filename")
			if(url.isEmpty()) throw IllegalArgumentException("Can't find the url")
			Handler(Looper.getMainLooper()).post {
				try{
					val uri = Uri.parse(url)
					val dm = DownloadManager.Request(uri)
					dm.setTitle("File Download")
					dm.setDescription("Downloading...")
					dm.setDestinationInExternalPublicDir(path, filename)
					dm.setNotificationVisibility(1)
					(context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager).enqueue(dm)
				}catch (e: Exception){
					Toast.makeText(context, e.stackTrace[0].methodName + "\n" +e.message + "\n#" + e.stackTrace[0].lineNumber, Toast.LENGTH_SHORT).show()
				}
			}
		}


		/**
		 * @param from
		 * @param to
		 */
		@Suppress("MemberVisibilityCanBePrivate")
		fun copy(from: String, to: String){
			if(from.isEmpty()) throw IllegalArgumentException("Can't find the path(From)")
			if(to.isEmpty()) throw IllegalArgumentException("Can't find the path(To)")
			val file1 = File(from)
			val file2 = File(to)
			val fis = FileInputStream(file1).channel
			val fos = FileOutputStream(file2).channel
			fis.transferTo(0, fis.size(), fos)
			fis.close()
			fos.close()
		}

		/**
		 * @param path
		 */
		fun isFolder(path: String): Boolean {
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			return File(path).isDirectory
		}

		/**
		 * @param path
		 */
		fun isFile(path: String): Boolean {
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			return File(path).isFile
		}

		/**
		 * @param path
		 */
		fun exists(path: String): Boolean {
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			return File(path).exists()
		}

		/**
		 * @param from
		 * @param to
		 */
		@Suppress("MemberVisibilityCanBePrivate")
		fun copyFolder(from: String, to: String){
			if(from.isEmpty()) throw IllegalArgumentException("Can't find the path(From)")
			if(to.isEmpty()) throw IllegalArgumentException("Can't find the path(To)")
			val file1 = File(from)
			if (file1.isDirectory) {
				val file3 = File(to, file1.name)
				file3.mkdirs()
				val child = file1.list()
				for (n in 0 until child.size) {
					val file4 = java.io.File(file1, child[n])
					if (file4.isDirectory)
						copyFolder(file4.path, file3.path)
					else
						copy(file4.path, java.io.File(file3, child[n]).path)
				}
			} else {
				copy(from, to)
			}
		}

		/**
		 * @param url
		 * @param path
		 */
		fun copyFromWeb(url: String, path: String){
			if(url.isEmpty()) throw IllegalArgumentException("Can't find the url")
			if(path.isEmpty()) throw IllegalArgumentException("Can't find the path")
			val url2 = URL(url)
			val con = url2.openConnection() as HttpURLConnection
			con.connectTimeout = 5000
			con.useCaches = false
			con.doInput = true
			con.doOutput = true
			val bis = BufferedInputStream(con.inputStream)
			val fos = FileOutputStream(File(path))
			val bos = BufferedOutputStream(fos)
			while (true){
				val buf  = bis.read()
				if(buf != -1) bos.write(buf)
				else break
			}
			bis.close()
			bos.close()
			con.disconnect()
			fos.close()
		}

		/**
		 * @param url
		 */
		fun readFromWeb(url: String): String {
			val url2 = URL(url)
            val con = url2.openConnection() as HttpURLConnection
			con.connectTimeout = 5000
			con.useCaches = false
			con.doInput = true
			con.doOutput = true
			val isr = InputStreamReader(con.inputStream)
			val br = BufferedReader(isr)
			var str = br.readLine()
			while(true) {
				val line = br.readLine() ?: break
				str += "\n" + line
			}
			br.close()
			con.disconnect()
			return str.toString()
		}
	}
}
