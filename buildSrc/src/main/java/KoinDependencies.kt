object KoinDependencies{
    val ktor = "org.koin:koin-ktor:${Versions.koin}"
    val core = "org.koin:koin-core:${Versions.koin}"
    val android = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    object Versions{
        const val koin = "2.0.1"
    }
}