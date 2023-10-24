package www.revengerfitness.blogspot.com.mvvmretrofit.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import www.revengerfitness.blogspot.com.mvvmretrofit.models.QuoteList

interface QuoteService {
@GET("/quotes")
    suspend fun getQuotes(@Query("page")page:Int):Response<QuoteList> // baseurl + "/quotes" + ?page=1
}