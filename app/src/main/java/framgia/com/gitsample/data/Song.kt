package framgia.com.gitsample.data

import java.io.Serializable

data class Song(
        var id: Long,
        var albumId: Long,
        var title: String,
        var artistName: String,
        var albumName: String,
        var duration: Int,
        var data: String,
        var art: ByteArray?
) : Serializable {

    companion object {
        fun createSampleData(): ArrayList<Song> {
            val list = ArrayList<Song>()

            for (i in 0..100) {
                val song = Song(
                        i.toLong(),
                        (i + 10).toLong(),
                        "title $i",
                        "artist $i",
                        "",
                        0,
                        "",
                        null)
                list.add(song)
            }

            return list
        }
    }
}