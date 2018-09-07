package framgia.com.gitsample.songs

import framgia.com.gitsample.data.Song

class SongsPresenter(val view: SongsContract.View) : SongsContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
        loadSongs()
    }

    private fun loadSongs() {
        view.setLoadingIndicator(true)
        val songs = Song.createSampleData()
        if (songs.size == 0) {
            view.showNoSongs()
        } else {
            view.showSongs(songs)
        }
        view.setLoadingIndicator(false)
    }
}
