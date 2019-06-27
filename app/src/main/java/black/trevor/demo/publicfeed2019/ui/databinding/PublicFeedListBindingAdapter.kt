package black.trevor.demo.publicfeed2019.ui.databinding

import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import black.trevor.demo.publicfeed2019.R
import black.trevor.demo.publicfeed2019.domain.PublicFeedItem
import black.trevor.demo.publicfeed2019.ui.view.adapter.PublicFeedListAdapter
import black.trevor.demo.publicfeed2019.ui.viewmodel.PublicFeedListViewModel
import com.google.android.material.snackbar.Snackbar

@BindingAdapter("publicFeedList")
fun bindList(recyclerView: RecyclerView, items: List<PublicFeedItem>?) {
    if (items == null) {
        recyclerView.adapter = PublicFeedListAdapter(ArrayList(0), recyclerView.context)
    } else {
        recyclerView.adapter = PublicFeedListAdapter(items, recyclerView.context)
    }
}

@BindingAdapter("refreshBind")
fun bindRefreshAction(view: SwipeRefreshLayout, viewModel: PublicFeedListViewModel) {
    view.setOnRefreshListener({ viewModel.reloadData() })
}

@BindingAdapter("isLoadingBind")
fun bindLoadingState(view: SwipeRefreshLayout, isLoading: Boolean) {
    view.isRefreshing = isLoading
}

@BindingAdapter("showErrorBind")
fun bindShowError(view: View, error: Throwable?) {
    if (error != null){
        if(isOnline(view.context)) {
            showSnackbar(view, R.string.error_during_data_loading)
        } else {
            showSnackbar(view, R.string.error_no_internet)
        }
    }
}

private fun showSnackbar(view: View, rId: Int) {
    //TODO
    Snackbar.make(view, rId, Snackbar.LENGTH_LONG).show()
}

private fun isOnline(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = cm.activeNetworkInfo
    return netInfo != null && netInfo.isConnected
}