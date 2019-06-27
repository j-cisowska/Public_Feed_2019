package black.trevor.demo.publicfeed2019.data.protocol

import black.trevor.demo.publicfeed2019.data.response.PublicFeedJsonResponse
import io.reactivex.Single
import retrofit2.http.GET

interface PublicFeedApi {
    @get:GET("feeds/photos_public.gne?format=json&nojsoncallback=1")
    val publicFeed: Single<PublicFeedJsonResponse>
}