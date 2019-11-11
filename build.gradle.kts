import groovy.lang.Closure
import java.net.URI

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

        maven {
            val artifactory_username: String by project
            val artifactory_password: String by project

            url = URI("https://repo.amistad.pl/artifactory/libs-release-local")
            credentials {
                username = artifactory_username
                password = artifactory_password
            }

        }
    }



}


