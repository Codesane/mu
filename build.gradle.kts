import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import java.net.URI

version = "1.0-SNAPSHOT"

buildscript {
    val kotlinVersion: String by extra { "1.1.4-2" }

    repositories {
        mavenCentral()
        jcenter()
        maven { url = uri("http://repo.spring.io/plugins-release") }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.springframework.build.gradle:propdeps-plugin:0.0.7")
        classpath("com.github.jengelman.gradle.plugins:shadow:2.0.1")
    }
}

task("wrapper", Wrapper::class) {
    gradleVersion = "4.1"
}

subprojects {
    apply {
        plugin("kotlin")
        plugin("propdeps")
        plugin("propdeps-idea")
        plugin("com.github.johnrengelman.shadow")
    }

    repositories {
        mavenCentral()
        jcenter()
        maven { url = URI("https://dl.bintray.com/kotlin/kotlinx") }
        maven { url = URI("https://dl.bintray.com/kotlin/ktor") }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    configure<KotlinProjectExtension> {
        experimental.coroutines = Coroutines.ENABLE
    }
}