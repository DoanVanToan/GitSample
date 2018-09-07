package framgia.com.gitsample.data.loader

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import android.text.TextUtils
import framgia.com.gitsample.data.Song
import java.util.*

object SongLoader {

    /**
     * Use to get all songs in storage
     *
     * @param context is your current context
     *
     * @return list of songs in storage
     */
    fun getAllSongs(context: Context): ArrayList<Song> {
        return getSongsForCursor(makeSongCursor(context, null, null))
    }

    private fun getSongsForCursor(cursor: Cursor?): ArrayList<Song> {
        val arrayList = ArrayList<Song>()
        if (cursor != null && cursor.moveToFirst())
            do {
                val id = cursor.getLong(0)
                val title = cursor.getString(1)
                val artistName = cursor.getString(2)
                val albumName = cursor.getString(3)
                val duration = cursor.getInt(4)
                val albumId = cursor.getLong(5)
                val data = cursor.getString(6)

                arrayList.add(Song(id, albumId, title, artistName, albumName, duration, data))
            } while (cursor.moveToNext())
        cursor?.close()
        return arrayList
    }

    private fun makeSongCursor(context: Context, selection: String?, paramArrayOfString: Array<String>?): Cursor? {

        val songSortOrder = MediaStore.Audio.Media.DEFAULT_SORT_ORDER

        return makeSongCursor(context, selection, paramArrayOfString, songSortOrder)
    }

    private fun makeSongCursor(context: Context, selection: String?, paramArrayOfString: Array<String>?, sortOrder: String): Cursor? {
        val projection = arrayOf(
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ALBUM_ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA
        )

        var selectionStatement = "is_music != 0 AND title != ''"

        if (!TextUtils.isEmpty(selection)) {
            selectionStatement = "$selectionStatement AND $selection"
        }
        return context.contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                selectionStatement,
                paramArrayOfString,
                sortOrder)

    }
}
