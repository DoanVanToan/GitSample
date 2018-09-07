package framgia.com.gitsample.data.source

import framgia.com.gitsample.data.Song

interface SongsDataSource {

    interface GetSongsCallBack {
        fun onStart()
        fun onSuccess(songs: ArrayList<Song>)
        fun onError(e: Exception)
    }

    fun getSongs(callback: GetSongsCallBack)
}
