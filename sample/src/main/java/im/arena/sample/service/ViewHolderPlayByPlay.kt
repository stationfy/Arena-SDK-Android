package im.arena.sample.service

import android.view.View
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import im.arena.realtimedata.model.Posts
import im.arena.sample.databinding.ViewHolderServicePlayByPlayBinding

class ViewHolderPlayByPlay(view: View) : RecyclerView.ViewHolder(view) {
    private val viewHolderServicePlayByPlayBinding = ViewHolderServicePlayByPlayBinding.bind(view)
    private val textViewTitle = viewHolderServicePlayByPlayBinding.viewHolderServicePlayByPlayTextViewTitle
    private val textViewDescription = viewHolderServicePlayByPlayBinding.viewHolderServicePlayByPlayTextViewDescription

    fun bind(posts: Posts) {
        val title = posts.message?.title.orEmpty()
        val message = posts.message?.text.orEmpty()

        textViewTitle.text = title
        textViewDescription.text = HtmlCompat.fromHtml(message, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}