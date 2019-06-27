package black.trevor.demo.publicfeed2019.ui.databinding

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import black.trevor.demo.publicfeed2019.ui.viewmodel.Fullscreen_image
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("imageBind")
fun bindFlickrImage(imageView: ImageView, imageUrl: String) {
    Picasso.get().load(imageUrl).into(imageView)

    imageView.setOnClickListener {
        val intent = Intent(it.context, Fullscreen_image::class.java)

        val b = Bundle()
        b.putString("imageURL", imageUrl);
        intent.putExtras(b);

        ContextCompat.startActivity(it.context, intent, null)

    }
}

@BindingAdapter("publishedDateBind")
fun bindPublishedDate(textView: TextView, date: Date?) {
    val format = SimpleDateFormat("dd/MM/yyy")
    textView.setText(format.format(date))
}

@BindingAdapter("tagsBind")
fun bindTags(textView: TextView, tags: List<String>) {
    textView.text = max3tagsToString(tags)
}


fun max3tagsToString(tags: List<String>): String {
    var tagsStr:String = ""
    for (tag in tags.take(3)) {
        tagsStr += "#"+tag.toString()+" "
    }
    return tagsStr
}
