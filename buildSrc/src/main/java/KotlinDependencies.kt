object KotlinDependencies{
    val std = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotliner = "org.jmailen.gradle:kotlinter-gradle:${Versions.kotliner}"


    object Versions{
        const val kotlin = "1.3.50"
        const val kotliner = "1.24.0"

    }
}

