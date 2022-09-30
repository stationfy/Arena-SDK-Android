package im.arena.sample

import android.view.View
import androidx.core.content.ContextCompat.getDrawable
import androidx.recyclerview.widget.RecyclerView
import im.arena.sample.databinding.ViewHolderHomeBinding

class ViewHolderHome(
    view: View,
    private val onClickListener: AdapterHome.OnClickListener
) : RecyclerView.ViewHolder(view), View.OnClickListener {
    private var viewHolderHomeBinding = ViewHolderHomeBinding.bind(view)

    init {
        viewHolderHomeBinding.viewHolderHome.apply {
            setOnClickListener(this@ViewHolderHome)
            background = getDrawable(itemView.context, R.drawable.ripple_daisy_bush)
        }
    }

    fun bind(name: String) {
        viewHolderHomeBinding.viewHolderHomeTextViewItem.text = name
    }

    override fun onClick(view: View?) {
        onClickListener.click(view, bindingAdapterPosition)
    }
}