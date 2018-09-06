package framgia.com.gitsample.songs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import framgia.com.gitsample.R
import kotlinx.android.synthetic.main.fragment_songs.*


class SongsFragment : Fragment(), SongsContract.View {

    override lateinit var presenter: SongsContract.Presenter

    private lateinit var songsPresenter: SongsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        songsPresenter = SongsPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_songs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup views
        listSongsView.layoutManager = LinearLayoutManager(context)
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
