package black.trevor.demo.publicfeed2019.ui.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableList
import androidx.lifecycle.ViewModel
import black.trevor.demo.publicfeed2019.domain.PublicFeedData
import black.trevor.demo.publicfeed2019.domain.PublicFeedItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class PublicFeedListViewModel : ViewModel() {

    val isLoading = ObservableField(false)
    val onError = ObservableField<Throwable>()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val dataSource = PublicFeedData()

    var items: ObservableList<PublicFeedItem> = ObservableArrayList()

    init {
        reloadData()
    }

    fun reloadData() {
        isLoading.set(true)
        compositeDisposable.add(
            dataSource.loadData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    isLoading.set(false)
                    if (it != null) {
                        items.clear()
                        items.addAll(it)
                    }
                }, {
                    onError.set(it)
                    isLoading.set(false)
                })
        )

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}