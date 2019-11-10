import groovy.lang.Closure

buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(BuildDependencies.gradlePlugin)
        classpath(KotlinDependencies.gradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }



}


