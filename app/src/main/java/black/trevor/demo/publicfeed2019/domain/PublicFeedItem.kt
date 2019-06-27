package black.trevor.demo.publicfeed2019.domain

import java.util.*

data class PublicFeedItem(
    val title: String,
    val imageUrl: String,
    val publishedDate: Date?,
    val tags: List<String>)