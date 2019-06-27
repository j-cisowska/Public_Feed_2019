package black.trevor.demo.publicfeed2019.ui.viewmodel

import androidx.databinding.ObservableField
import black.trevor.demo.publicfeed2019.domain.PublicFeedItem

class PublicFeedItemViewModel {
    val publicFeedItem = ObservableField<PublicFeedItem>()

    fun setItem(publicFeedItem: PublicFeedItem) {
        this.publicFeedItem.set(publicFeedItem)
    }
}