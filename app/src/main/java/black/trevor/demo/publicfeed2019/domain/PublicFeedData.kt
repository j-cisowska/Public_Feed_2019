package black.trevor.demo.publicfeed2019.domain

import black.trevor.demo.publicfeed2019.data.network.NetworkConnectionService
import black.trevor.demo.publicfeed2019.data.protocol.PublicFeedApi
import black.trevor.demo.publicfeed2019.data.response.PublicFeedItemJsonResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class PublicFeedData {

    fun loadData(): Single<List<PublicFeedItem>> {
        return NetworkConnectionService.generateService(PublicFeedApi::class.java)
            .publicFeed.toObservable()
            .flatMapIterable<PublicFeedItemJsonResponse>({ it.items })
            .map { publicFeedItemJsonResponse ->
                PublicFeedItem(
                    publicFeedItemJsonResponse.title,
                    publicFeedItemJsonResponse.media.m,
                    publicFeedItemJsonResponse.getPublishedDate(),
                    publicFeedItemJsonResponse.getTags())
            }
            .toList().subscribeOn(Schedulers.io())
    }

    fun loadDataForTest(): Single<List<PublicFeedItemJsonResponse>> {
        return NetworkConnectionService.generateService(PublicFeedApi::class.java)
            .publicFeed.toObservable()
            .flatMapIterable<PublicFeedItemJsonResponse>({ it.items })
            .toList().subscribeOn(Schedulers.io())
    }

}