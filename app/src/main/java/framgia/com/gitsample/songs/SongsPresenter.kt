package framgia.com.gitsample.songs

import framgia.com.gitsample.data.Song
import framgia.com.gitsample.data.SongList
import framgia.com.gitsample.data.source.SongsDataSource
import framgia.com.gitsample.data.source.SongsRepository

class SongsPresenter(val songsRepository: SongsRepository,
                     val view: SongsContract.View) : SongsContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
        loadSongs()
    }

    private fun loadSongs() {

        songsRepository.getSongs(object : SongsDataSource.GetSongsCallBack {
            override fun onStart() {
                view.setLoadingIndicator(true)
            }

            override fun onSuccess(songs: ArrayList<Song>) {
                SongList.list = songs
                if (SongList.list.size == 0) {
                    view.showNoSongs()
                } else {
                    view.showSongs()
                }
                view.setLoadingIndicator(false)
            }

            override fun onError(e: Exception) {
                view.showLoadingSongsError()
                view.setLoadingIndicator(false)
            }
        })
    }
}
