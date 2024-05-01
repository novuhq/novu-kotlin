package co.novu.helpers

import co.novu.NovuConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Properties

class RetrofitHelper(
    private val config: NovuConfig
) {

    private lateinit var retrofit: Retrofit

    fun getInstance(): Retrofit {
        if (this::retrofit.isInitialized) {
            return retrofit
        }

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "ApiKey ${config.apiKey}")
                .addHeader("User-Agent", "novu/Kotlin@${retrieveProjectVersion()}")
                .build()
            chain.proceed(request)
        }.also {
            if (config.enableLogging) it.addInterceptor(HttpLoggingInterceptor().setLevel(config.apiLogLevel))
        }
        val gson = GsonBuilder().setLenient().create()
        retrofit = Retrofit.Builder()
            .client(httpClient.build())
            .baseUrl(if (config.enableEuVersion) config.euBackendUrl else config.backendUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit
    }

    private fun retrieveProjectVersion(): String {
        val properties = Properties()
        val inputStream = this.javaClass.getResourceAsStream("/version.properties") ?: return ""
        inputStream.use {
            properties.load(it)
            return properties.getProperty("version") ?: ""
        }
    }
}
