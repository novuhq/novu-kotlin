package co.novu.helpers

import co.novu.NovuConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper(
    private val config: NovuConfig,
    private val loggerLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC
) {

    fun getInstance(): Retrofit {
        val httpClient = OkHttpClient.Builder()

        httpClient
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "ApiKey ${config.apiKey}")
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(HttpLoggingInterceptor().setLevel(loggerLevel))
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder().client(httpClient.build()).baseUrl(config.backendUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}
