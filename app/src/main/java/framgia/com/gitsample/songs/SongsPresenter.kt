package framgia.com.gitsample.songs

class SongsPresenter(val view: SongsContract.View) : SongsContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
        loadSongs()
    }

    private fun loadSongs() {
        view.setLoadingIndicator(true)
        // TODO: Loading songs
    }
}
