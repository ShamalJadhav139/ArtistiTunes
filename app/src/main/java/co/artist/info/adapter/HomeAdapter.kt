package co.artist.info.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.artist.info.MainActivity
import co.artist.info.R
import co.artist.info.databinding.ItemViewItunesGridBinding
import co.artist.info.model.ArtistiTunesResponse
import com.squareup.picasso.Picasso


class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    var mContext: Context? = null
    var artistList = emptyList<ArtistiTunesResponse.Projects>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = ItemViewItunesGridBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (!artistList[position].artworkUrl30.isNullOrBlank()) {
            Picasso.get().load(artistList[position].artworkUrl100).fit().centerCrop()
                .placeholder(R.drawable.itunes)
                .error(R.drawable.itunes)
                .into(holder.binding.roundedBg)
        }

        holder.binding.trackName.text = artistList[position].trackName

        holder.itemView.setOnClickListener {
            (mContext as MainActivity).launchDetailsFragment(artistList[position])
        }
    }

    fun setData(artistList: List<ArtistiTunesResponse.Projects>?) {
        this.artistList = artistList!!
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: ItemViewItunesGridBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var binding = itemView
    }

    fun filterData(s: CharSequence) {
        var tmpList: List<ArtistiTunesResponse.Projects>? = mutableListOf()
        artistList = artistList

        if (s.length > 0) {
            for (model in artistList) {
                if (tmpList != null) {
                    if (model.trackName!!.toLowerCase().contains(s.toString().toLowerCase())) {
                        tmpList += model
                    }
                }
            }

            this.artistList = tmpList!!
            notifyDataSetChanged()

        } else {
            this.artistList = artistList
            notifyDataSetChanged()
        }


    }
}