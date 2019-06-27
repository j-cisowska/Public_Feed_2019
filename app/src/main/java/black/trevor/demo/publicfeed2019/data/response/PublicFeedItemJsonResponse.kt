package black.trevor.demo.publicfeed2019.data.response

data class PublicFeedItemJsonResponse(
    val title: String,
    val published: String?,
    val tags: String,
    val media: MediaJsonResponse)