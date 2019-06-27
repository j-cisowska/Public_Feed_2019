package black.trevor.demo.publicfeed2019.domain

import black.trevor.demo.publicfeed2019.data.response.PublicFeedItemJsonResponse
import java.text.DateFormat
import java.text.ParseException
import java.util.Date

fun PublicFeedItemJsonResponse.getPublishedDate(): Date? {
    val datePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    val dateFormatter: DateFormat = java.text.SimpleDateFormat(datePattern, java.util.Locale.getDefault())
    published?.let {
        return try {
            dateFormatter.parse(it)
        } catch (e: ParseException) {
            null
        }
    }
    return null
}

fun PublicFeedItemJsonResponse.getTags(): List<String> {
    val tagsSeparator = " "
    return tags.split(tagsSeparator.toRegex()).dropLastWhile { it.isEmpty() }.toList()
}