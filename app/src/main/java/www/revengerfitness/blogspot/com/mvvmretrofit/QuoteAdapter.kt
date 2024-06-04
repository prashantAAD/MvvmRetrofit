package www.revengerfitness.blogspot.com.mvvmretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import www.revengerfitness.blogspot.com.mvvmretrofit.models.Result

class QuoteAdapter(
    private var context: Context,
    private var quoteModelList: List<Result>
) :
    RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {

    inner class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var quoteText: TextView= itemView.findViewById<TextView>(R.id.textView)
        var quoteAuthor: TextView = itemView.findViewById<TextView>(R.id.textView2)





    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder(
            LayoutInflater.from(context).inflate(R.layout.quote_layout, parent, false)
        )
    }



    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.quoteText.text = quoteModelList[position].content
        holder.quoteAuthor.text = quoteModelList[position].author

    }
    override fun getItemCount(): Int {
        return quoteModelList.size
    }

}