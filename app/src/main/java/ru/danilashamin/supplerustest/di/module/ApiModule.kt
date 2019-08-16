package ru.danilashamin.supplerustest.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.danilashamin.supplerustest.BuildConfig
import ru.danilashamin.supplerustest.api.Api
import ru.danilashamin.supplerustest.utils.Constants.API_URL
import ru.danilashamin.supplerustest.utils.TrustAllCertificatesManager
import java.security.SecureRandom
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

@Module
class ApiModule {

    @Singleton
    @Provides
    fun apiProvider(
        callAdapterFactory: CallAdapter.Factory,
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Api {
        return Retrofit.Builder()
            .addCallAdapterFactory(callAdapterFactory)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .baseUrl(API_URL)
            .build()
            .create(Api::class.java)
    }

    @Singleton
    @Provides
    fun providesCallAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()


    @Singleton
    @Provides
    fun providesConverterFactory(gson: Gson): Converter.Factory = GsonConverterFactory.create(gson)

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: LoggingInterceptor,
        sslContext: SSLContext,
        trustManager: X509TrustManager
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .hostnameVerifier { _, _ -> true }
            .sslSocketFactory(sslContext.socketFactory, trustManager)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideX509TrustManager(): X509TrustManager = TrustAllCertificatesManager()

    @Singleton
    @Provides
    fun provideSSLContext(trustManager: X509TrustManager, secureRandom: SecureRandom): SSLContext {
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, arrayOf(trustManager), secureRandom)
        return sslContext
    }

    @Singleton
    @Provides
    fun provideSecureRandom() = SecureRandom()

    @Singleton
    @Provides
    fun getLoggingInterceptor(): LoggingInterceptor {
        return LoggingInterceptor.Builder()
            .loggable(BuildConfig.DEBUG)
            .setLevel(Level.BODY)
            .log(Platform.INFO)
            .tag("SuppleRusHttps")
            .build()
    }

}