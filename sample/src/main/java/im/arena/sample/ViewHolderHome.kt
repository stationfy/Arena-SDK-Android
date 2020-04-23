package im.arena.sample

import android.view.View
import androidx.core.content.ContextCompat.getDrawable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_home.view.*

class ViewHolderHome(
    private val view: View,
    private val onClickListener: AdapterHome.OnClickListener
) :
    RecyclerView.ViewHolder(view), View.OnClickListener {

    init {
        with(view.view_holder_home) {
            setOnClickListener(this@ViewHolderHome)
            background = getDrawable(itemView.context, R.drawable.ripple_daisy_bush)
        }
    }

    fun bind(name: String) {
        view.view_holder_home_text_view_item.text = name
    }

    override fun onClick(view: View?) {
        onClickListener.click(view, adapterPosition)
    }
}