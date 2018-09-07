package framgia.com.gitsample.data.source

import android.content.Context
import framgia.com.gitsample.data.loader.SongLoader
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class SongsRepository(private val context: Context) : SongsDataSource {

    override fun getSongs(callback: SongsDataSource.GetSongsCallBack) {
        callback.onStart()
        doAsync {
            try {
                val songs = SongLoader.getAllSongs(context)
                uiThread { callback.onSuccess(songs) }
            } catch (e: Exception) {
                uiThread { callback.onError(e) }
            }
        }
    }
}
