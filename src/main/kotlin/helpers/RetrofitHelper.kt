package co.novu.helpers

import com.google.gson.GsonBuilder
import mu.KotlinLogging
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val logger = KotlinLogging.logger {}

class RetrofitHelper(
    private val baseUrl: HttpUrl,
    private val apiKey: String,
    private val loggerLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
) {

    fun getInstance(): Retrofit {
        val httpClient = OkHttpClient.Builder()

        httpClient
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "ApiKey $apiKey")
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(HttpLoggingInterceptor().setLevel(loggerLevel))
            .build()
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder().client(httpClient.build()).baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}
