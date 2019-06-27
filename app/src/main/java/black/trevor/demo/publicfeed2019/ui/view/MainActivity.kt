package black.trevor.demo.publicfeed2019.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import black.trevor.demo.publicfeed2019.R
import black.trevor.demo.publicfeed2019.databinding.ActivityPublicFeedBinding
import black.trevor.demo.publicfeed2019.domain.PublicFeedData
import black.trevor.demo.publicfeed2019.ui.viewmodel.PublicFeedListViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val publicFeedViewModel = ViewModelProviders.of(this).get(PublicFeedListViewModel::class.java)
        val binding = DataBindingUtil.setContentView<ActivityPublicFeedBinding>(this, R.layout.activity_public_feed)
        binding.listViewModel = publicFeedViewModel

//        val dataSource = PublicFeedData()
//        dataSource.loadDataForTest()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                if (it != null) {
//                    Log.d("ELEMENTS", "Size of data ${it.size}")
//                }
//            }, {
//            })
//
    }
}


