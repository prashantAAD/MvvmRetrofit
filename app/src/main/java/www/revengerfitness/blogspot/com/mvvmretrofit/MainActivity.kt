package www.revengerfitness.blogspot.com.mvvmretrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import www.revengerfitness.blogspot.com.mvvmretrofit.api.QuoteService
import www.revengerfitness.blogspot.com.mvvmretrofit.api.RetrofitHelper
import www.revengerfitness.blogspot.com.mvvmretrofit.databinding.ActivityMainBinding
import www.revengerfitness.blogspot.com.mvvmretrofit.models.Result
import www.revengerfitness.blogspot.com.mvvmretrofit.repository.QuoteRepository
import www.revengerfitness.blogspot.com.mvvmretrofit.viewmodels.MainViewModel
import www.revengerfitness.blogspot.com.mvvmretrofit.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
   // private var adapter: QuoteAdapter? = null
    //private var layoutManager: RecyclerView.LayoutManager? = null


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)


        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)

        mainViewModel= ViewModelProvider(this,MainViewModelFactory(repository))[MainViewModel::class.java]

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        binding.recyclerView.layoutManager=binding.recyclerView.layoutManager
        mainViewModel.quotes.observe(this) { // here quotes is a live data which can be observe
            Log.d(
                "prashant chauhan" +
                        "", it.results.toString()
            )
            binding.recyclerView.adapter = QuoteAdapter(this, it.results as MutableList<Result>)
            binding.recyclerView.adapter!!.notifyDataSetChanged()
            binding.recyclerView.adapter = binding.recyclerView.adapter


        }


    }
}