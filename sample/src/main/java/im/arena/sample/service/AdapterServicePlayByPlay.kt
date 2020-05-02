package im.arena.sample.service

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import im.arena.realtimedata.model.Posts
import im.arena.sample.R

class AdapterServicePlayByPlay : ListAdapter<Posts, ViewHolderPlayByPlay>(object :
    DiffUtil.ItemCallback<Posts>() {
    override fun areItemsTheSame(oldItem: Posts, newItem: Posts) =
        oldItem.key == newItem.key

    override fun areContentsTheSame(oldItem: Posts, newItem: Posts) =
        oldItem == newItem
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolderPlayByPlay(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_holder_service_play_by_play,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolderPlayByPlay, position: Int) =
        holder.bind(getItem(position))
}