package framgia.com.gitsample.songs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import framgia.com.gitsample.R
import framgia.com.gitsample.data.Song
import kotlinx.android.synthetic.main.list_item_song.view.*

class SongsAdapter(var songs: ArrayList<Song>) : RecyclerView.Adapter<SongsAdapter.SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(songs[position])
    }


    class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var view = itemView

        fun bind(song: Song) {
            view.titleSong.text = song.title
            view.subtitleSong.text = song.artistName
        }
    }
}