
plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
}

dependencies {

    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.21")
    implementation("com.squareup.retrofit2:retrofit:2.5.0")

    implementation ("io.reactivex.rxjava2:rxkotlin:2.2.0")

    // Converters
    implementation ("com.squareup.retrofit2:converter-moshi:2.5.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.1.0")


    // Retrofit & OkHttp
    implementation ("com.squareup.retrofit2:retrofit:2.5.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.5.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.12.1")
    compile(group = "commons-io", name = "commons-io", version = "2.6")

}

