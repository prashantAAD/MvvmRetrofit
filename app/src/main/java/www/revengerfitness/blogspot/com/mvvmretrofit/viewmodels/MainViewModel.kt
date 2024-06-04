package www.revengerfitness.blogspot.com.mvvmretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import www.revengerfitness.blogspot.com.mvvmretrofit.models.QuoteList
import www.revengerfitness.blogspot.com.mvvmretrofit.repository.QuoteRepository

class MainViewModel(private val repository: QuoteRepository):ViewModel(){ // parameterized constructor of viewmodel so that use model factory

    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getQuotes(1) // go to repository and get quotes
        }

    }

    val quotes : LiveData<QuoteList>
        get() = repository.quotes
}