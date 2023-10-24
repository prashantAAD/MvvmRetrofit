package www.revengerfitness.blogspot.com.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import www.revengerfitness.blogspot.com.mvvmretrofit.api.QuoteService
import www.revengerfitness.blogspot.com.mvvmretrofit.api.RetrofitHelper
import www.revengerfitness.blogspot.com.mvvmretrofit.repository.QuoteRepository
import www.revengerfitness.blogspot.com.mvvmretrofit.viewmodels.MainViewModel
import www.revengerfitness.blogspot.com.mvvmretrofit.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)

        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.quotes.observe(this, Observer {
            Log.d("prashant chauhan" +
                    "",it.results.toString())
        })
    }
}