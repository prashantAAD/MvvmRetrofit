package www.revengerfitness.blogspot.com.mvvmretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import www.revengerfitness.blogspot.com.mvvmretrofit.models.QuoteList
import www.revengerfitness.blogspot.com.mvvmretrofit.repository.QuoteRepository

class MainViewModel(val repository: QuoteRepository):ViewModel(){

    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getQuotes(1)
        }

    }

    val quotes : LiveData<QuoteList>
        get() = repository.quotes
}