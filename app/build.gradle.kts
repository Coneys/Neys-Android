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
        applicationId = "com.github.coneys.cookking"
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
    implementation(project(":shoppingList"))

    implementation(KoinDependencies.android)


    implementation(AndroidDependencies.appCompat)
    implementation(AndroidDependencies.constraintLayout)
    implementation(AndroidDependencies.viewModel)
    implementation(AndroidDependencies.lifecycleExtensions)
    implementation(AndroidDependencies.material)

    implementation(RetrofitDependencies.retrofit)
    implementation(RetrofitDependencies.moshiConverter)
    implementation(RetrofitDependencies.loggingInterceptor)

    implementation(AndroidDependencies.navigation)
    implementation(AndroidDependencies.navigationUi)

    implementation(KotlinDependencies.std)

    testImplementation (TestDependencies.kotlinTestRunner)


}

