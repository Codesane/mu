apply { from(rootProject.file("gradle/versions.gradle.kts")) }

val kotlinVersion: String by extra

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlinVersion")
}
