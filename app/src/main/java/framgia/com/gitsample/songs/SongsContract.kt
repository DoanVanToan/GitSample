package framgia.com.gitsample.songs

import framgia.com.gitsample.base.BasePresenter
import framgia.com.gitsample.base.BaseView

class SongsContract {

    interface View : BaseView<Presenter> {
        fun setLoadingIndicator(active: Boolean)
        fun showSongs()
        fun showLoadingSongsError()
        fun showNoSongs()
    }

    interface Presenter : BasePresenter {

    }
}
