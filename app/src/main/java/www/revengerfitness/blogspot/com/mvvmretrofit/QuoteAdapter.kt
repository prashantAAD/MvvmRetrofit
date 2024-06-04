package www.revengerfitness.blogspot.com.mvvmretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import www.revengerfitness.blogspot.com.mvvmretrofit.databinding.QuoteLayoutBinding
import www.revengerfitness.blogspot.com.mvvmretrofit.models.Result

class QuoteAdapter(
    private var context: Context,
    private var quoteModelList: List<Result>
) :
    RecyclerView.Adapter<QuoteAdapter.QuoteBindingViewHolder>() {

    inner class QuoteBindingViewHolder( val quoteBinding: QuoteLayoutBinding) : RecyclerView.ViewHolder(quoteBinding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteBindingViewHolder {
        val rootView:QuoteLayoutBinding = QuoteLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuoteBindingViewHolder(
            rootView
        )
    }
    override fun onBindViewHolder(holder: QuoteBindingViewHolder, position: Int) {
        val result: Result = quoteModelList[position]
        holder.quoteBinding.quoteProduct = result
    }
    override fun getItemCount(): Int {
        return quoteModelList.size
    }

}