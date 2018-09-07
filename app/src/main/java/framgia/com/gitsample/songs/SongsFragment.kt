package framgia.com.gitsample.songs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import framgia.com.gitsample.R
import framgia.com.gitsample.data.Song
import kotlinx.android.synthetic.main.fragment_songs.*


class SongsFragment : Fragment(), SongsContract.View {

    override lateinit var presenter: SongsContract.Presenter

    private val songsAdapter = SongsAdapter(ArrayList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_songs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup views
        listSongsView.layoutManager = LinearLayoutManager(context)
        listSongsView.adapter = songsAdapter
        swipeRefresh.setOnRefreshListener {
            presenter.start()
            swipeRefresh.isRefreshing = false
        }

        presenter.start()
    }

    override fun setLoadingIndicator(active: Boolean) {
        swipeRefresh.isRefreshing = active
        notifyText.visibility = View.GONE
    }

    override fun showSongs(songs: ArrayList<Song>) {
        swipeRefresh.isRefreshing = false
        songsAdapter.songs = songs
        songsAdapter.notifyDataSetChanged()
        notifyText.visibility = View.GONE
    }

    override fun showLoadingSongsError() {
        notifyText.text = getString(R.string.loading_songs_error)
        notifyText.visibility = View.VISIBLE
    }

    override fun showNoSongs() {
        notifyText.text = getString(R.string.empty_list)
        notifyText.visibility = View.VISIBLE
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment SongsFragment.
         */
        @JvmStatic
        fun newInstance() = SongsFragment()
    }
}
