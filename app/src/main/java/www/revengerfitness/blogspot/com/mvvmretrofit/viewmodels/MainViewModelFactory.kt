package www.revengerfitness.blogspot.com.mvvmretrofit.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import www.revengerfitness.blogspot.com.mvvmretrofit.repository.QuoteRepository

class MainViewModelFactory(private val repository: QuoteRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}