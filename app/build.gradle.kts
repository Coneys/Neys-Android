import groovy.lang.Closure

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}


android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }

    compileSdkVersion(ApplicationVariables.compileSdk)
    defaultConfig {
        applicationId = "com.github.coneys.neys"
        minSdkVersion(ApplicationVariables.minSdk)
        targetSdkVersion(ApplicationVariables.targetSdk)
        versionCode = 1
        versionName = "0.0.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
    }


    testOptions {
        unitTests.isReturnDefaultValues = true
        val closureOf = closureOf<Test> {
            useJUnitPlatform()
        } as Closure<Test>
        unitTests.all(closureOf)
    }
}

dependencies {

    implementation(project(":androidArchitecture"))
    implementation(project(":core"))
    implementation(project(":shoppingList:application"))

    implementation(KoinDependencies.android)


    implementation(AndroidDependencies.appCompat)
    implementation(AndroidDependencies.constraintLayout)
    implementation(AndroidDependencies.viewModel)
    implementation(AndroidDependencies.lifecycleExtensions)
    implementation(AndroidDependencies.material)
    implementation(AndroidDependencies.ktx)

    implementation(RetrofitDependencies.retrofit)
    implementation(RetrofitDependencies.moshiConverter)
    implementation(RetrofitDependencies.loggingInterceptor)

    implementation(AndroidDependencies.navigation)
    implementation(AndroidDependencies.navigationUi)

    implementation(KotlinDependencies.std)
    implementation("pl.amistad.library:lists:2.2.1")

    testImplementation (TestDependencies.kotlinTestRunner)


    /*Views*/
    implementation("com.jaredrummler:animated-svg-view:1.0.6")



}

