object AndroidDependencies {

    val ktx = "androidx.core:core-ktx:${Version.ktx}"
    val material = "com.google.android.material:material:${Version.material}"
    val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
    val navigation= "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    val navigationUi= "androidx.navigation:navigation-ui-ktx:${Version.navigation}"


    object Version {
        val ktx = "1.0.2"
        val material = "1.1.0-alpha10"
        val appCompat = "1.1.0-rc01"
        val constraintLayout = "2.0.0-beta1"
        val lifecycle = "2.0.0"
        val navigation = "2.1.0"
    }

}