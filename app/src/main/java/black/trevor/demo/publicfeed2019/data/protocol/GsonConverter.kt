package black.trevor.demo.publicfeed2019.data.protocol

import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory

internal object GsonConverter {

    private var gsonConverter: GsonConverterFactory =
        GsonConverterFactory.create(GsonBuilder().create())

    val converter: GsonConverterFactory
        get() {
            return gsonConverter
        }
}
