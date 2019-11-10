import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib-jdk8"))
    api(KoinDependencies.core)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}