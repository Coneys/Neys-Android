import groovy.lang.Closure

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    compileSdkVersion(ApplicationVariables.compileSdk)
    defaultConfig {
        minSdkVersion(ApplicationVariables.minSdk)
        targetSdkVersion(ApplicationVariables.targetSdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    api (CoroutineDependencies.coroutines)
    implementation (CoroutineDependencies.coroutinesAndroid)

    implementation (AndroidDependencies.appCompat)

    implementation (RxDependencies.rxAndroid)
    implementation (RxDependencies.rxKotlin)


    testImplementation (TestDependencies.kotlinTestRunner)




}
