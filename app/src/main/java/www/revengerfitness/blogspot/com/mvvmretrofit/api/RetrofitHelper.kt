package www.revengerfitness.blogspot.com.mvvmretrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper { // retrofit object or instance

    private const val BASE_URL = "http://quotable.io"

    fun getInstance():Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}