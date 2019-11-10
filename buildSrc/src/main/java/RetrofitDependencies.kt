object RetrofitDependencies {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"

    object Version {
        const val retrofit = "2.6.1"
        const val okhttp = "3.12.1"
    }
}