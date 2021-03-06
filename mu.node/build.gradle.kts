apply { from(rootProject.file("gradle/versions.gradle.kts")) }

val ktorVersion: String by extra
val logbackVersion: String by extra

dependencies {
    compile(project(":mu.fn.platform.base"))

    compile("org.jetbrains.ktor:ktor-netty:$ktorVersion")

    compile("org.jetbrains.ktor:ktor-gson:$ktorVersion")
    compile("com.google.code.gson:gson:$ktorVersion")
    compile("com.github.salomonbrys.kotson:kotson:2.5.0")
    compile("org.xeustechnologies:jcl-core:2.7")

    compile("ch.qos.logback:logback-classic:$logbackVersion")
}
