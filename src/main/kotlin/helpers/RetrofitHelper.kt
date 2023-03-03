package co.novu.helpers

import mu.KotlinLogging
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val logger = KotlinLogging.logger {}

class RetrofitHelper(
    private val baseUrl: String,
    private val apiKey: String,
    private val loggerLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC
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


        return Retrofit.Builder().client(httpClient.build()).baseUrl(baseUrl)

            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}