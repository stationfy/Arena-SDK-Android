package im.arena.sample.service

import android.view.View
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import im.arena.realtimedata.model.Posts
import kotlinx.android.synthetic.main.view_holder_service_play_by_play.view.*

class ViewHolderPlayByPlay(view: View) : RecyclerView.ViewHolder(view) {
    private val textViewTitle = view.view_holder_service_play_by_play_text_view_title
    private val textViewDescription = view.view_holder_service_play_by_play_text_view_description

    fun bind(posts: Posts) {
        val title = posts.message?.title ?: ""
        val message = posts.message?.text ?: ""

        textViewTitle.text = title
        textViewDescription.text = HtmlCompat.fromHtml(message, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}