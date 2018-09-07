package framgia.com.gitsample.songs

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import framgia.com.gitsample.R
import framgia.com.gitsample.data.source.SongsRepository
import framgia.com.gitsample.extension.containsOnly
import framgia.com.gitsample.extension.isPermissionGranted
import framgia.com.gitsample.extension.replaceFragmentInActivity
import framgia.com.gitsample.extension.requestPermission

class SongsActivity : AppCompatActivity() {

    private lateinit var presenter: SongsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs)

        if (checkExternalStoragePermission()) {
            addSongsFragment()
        } else {
            requestPermission(PERMISSION_EXTERNAL_STORAGE, REQUEST_EXTERNAL_STORAGE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_EXTERNAL_STORAGE) {
            if (grantResults.containsOnly(PackageManager.PERMISSION_GRANTED)) {
                addSongsFragment()
            } else {
                finish()
            }
        }
    }

    private fun checkExternalStoragePermission(): Boolean {
        return isPermissionGranted(PERMISSION_EXTERNAL_STORAGE)
    }

    private fun addSongsFragment() {
        val songsFragment = supportFragmentManager.findFragmentById(R.id.songsFragment)
                as SongsFragment? ?: SongsFragment.newInstance().also {
            replaceFragmentInActivity(it, R.id.songsFragment)
        }

        val songsRepository = SongsRepository(this)
        presenter = SongsPresenter(songsRepository, songsFragment)
    }

    companion object {
        const val PERMISSION_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE
        const val REQUEST_EXTERNAL_STORAGE = 123
    }
}
