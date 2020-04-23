package im.arena.sample

import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterHome(
    private val itemsList: List<String> = emptyList(),
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<ViewHolderHome>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolderHome(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_holder_home,
                parent,
                false
            ), onClickListener
        )

    override fun onBindViewHolder(holder: ViewHolderHome, position: Int) =
        holder.bind(itemsList[position])

    override fun getItemCount() = itemsList.size

    interface OnClickListener {
        fun click(view: View?, position: Int)
    }
}