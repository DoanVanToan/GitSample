package framgia.com.gitsample.songs

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import framgia.com.gitsample.R
import framgia.com.gitsample.extension.replaceFragmentInActivity

class SongsActivity : AppCompatActivity() {

    private lateinit var presenter: SongsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs)

        val songsFragment = supportFragmentManager.findFragmentById(R.id.songsFragment)
                as SongsFragment? ?: SongsFragment.newInstance().also {
            replaceFragmentInActivity(it, R.id.songsFragment)
        }

        presenter = SongsPresenter(songsFragment)
    }
}
