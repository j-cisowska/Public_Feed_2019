package black.trevor.demo.publicfeed2019.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import black.trevor.demo.publicfeed2019.R
import black.trevor.demo.publicfeed2019.databinding.ItemFeedBinding
import black.trevor.demo.publicfeed2019.domain.PublicFeedItem
import black.trevor.demo.publicfeed2019.ui.viewmodel.PublicFeedItemViewModel

internal class PublicFeedListAdapter(private val items: List<PublicFeedItem>, context: Context) : RecyclerView.Adapter<PublicFeedListAdapter.ViewHolder>() {
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemFeedBinding>(layoutInflater, R.layout.item_feed, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val publicFeedItem = items[position]
        holder.bind(publicFeedItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    internal class ViewHolder(private val binding: ItemFeedBinding) : RecyclerView.ViewHolder(binding.root) {
        private val publicFeedItemViewModel: PublicFeedItemViewModel = PublicFeedItemViewModel()

        init {
            binding.itemViewModel = publicFeedItemViewModel
        }

        fun bind(item: PublicFeedItem) {
            publicFeedItemViewModel.setItem(item)
            binding.executePendingBindings()
        }
    }
}