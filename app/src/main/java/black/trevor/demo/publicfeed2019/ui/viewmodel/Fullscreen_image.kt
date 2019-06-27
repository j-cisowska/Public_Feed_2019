package black.trevor.demo.publicfeed2019.ui.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import black.trevor.demo.publicfeed2019.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fullscreen_image.*

class Fullscreen_image : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fullscreen_image)
    }

    override fun onResume() {
        super.onResume()
        val b = intent.extras
        if(b != null) {
            val imageURL = b.getString("imageURL");
            println(imageURL)
            Picasso.get().load(imageURL).into(imageView)

        }
    }
}