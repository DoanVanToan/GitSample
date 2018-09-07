package framgia.com.gitsample.songs

import framgia.com.gitsample.base.BasePresenter
import framgia.com.gitsample.base.BaseView
import framgia.com.gitsample.data.Song

class SongsContract {

    interface View : BaseView<Presenter> {
        fun setLoadingIndicator(active: Boolean)
        fun showSongs(songs: ArrayList<Song>)
        fun showLoadingSongsError()
        fun showNoSongs()
    }

    interface Presenter : BasePresenter {

    }
}
