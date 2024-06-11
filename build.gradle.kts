plugins {
    alias(libs.plugins.kotlin.jvm)
}

fun kt(dep: String): String {
    return "org.jetbrains.kotlin.$dep"
}

allprojects {
    apply {
        plugin(kt("jvm"))
    }

    group = "ink.nostal.advkt"
    version = "1.0.0-SNAPSHOT"

    repositories {
        mavenCentral()
        mavenLocal()
        maven(uri("https://maven.nostal.ink/repository/maven-public"))
    }

    dependencies {
        api(rootProject.libs.kotlin.stdlib)
        api(rootProject.libs.adventure.api)
        api(rootProject.libs.adventure.text.minimessage)
        api(rootProject.libs.adventure.text.serializer.gson)
        api(rootProject.libs.adventure.text.serializer.legacy)
        api(rootProject.libs.adventure.text.serializer.plain)
        api(rootProject.libs.adventure.text.serializer.ansi)
    }

    kotlin {
        jvmToolchain(8)
    }

    tasks.compileJava {
        targetCompatibility = "1.8"
        options.encoding = "UTF-8"
    }
}