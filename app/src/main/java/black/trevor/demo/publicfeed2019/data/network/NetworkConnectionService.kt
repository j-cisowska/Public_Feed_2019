package black.trevor.demo.publicfeed2019.data.network

import black.trevor.demo.publicfeed2019.BuildConfig
import black.trevor.demo.publicfeed2019.data.protocol.GsonConverter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

object NetworkConnectionService {
    private val httpClient: OkHttpClient = getOkHttpClient()
    private const val connectionTimeout: Long = 1
    private const val writeTimeout: Long = 1
    private const val readTimeout: Long = 1


    fun <S> generateService(
        serviceClass: Class<S>): S {

        return Retrofit.Builder()
            .client(httpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverter.converter)
            .baseUrl(BuildConfig.API_URL) // "https://api.flickr.com/services/"
            .build()
            .create(serviceClass)
    }

    private fun getOkHttpClient(): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(connectionTimeout, TimeUnit.MINUTES)
            .writeTimeout(writeTimeout, TimeUnit.MINUTES)
            .readTimeout(readTimeout, TimeUnit.MINUTES)
        if (BuildConfig.DEBUG) {
            httpClientBuilder.addInterceptor(
                HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        return httpClientBuilder.build()
    }
}
