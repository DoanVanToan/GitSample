package framgia.com.gitsample.data

import java.io.Serializable

data class Song(
        var id: Long,
        var albumId: Long,
        var title: String,
        var artistName: String,
        var albumName: String,
        var duration: Int,
        var data: String
) : Serializable {
    override fun toString(): String {
        return "$id: $albumId; $title; $artistName; $albumName; $duration; $data"
    }
}