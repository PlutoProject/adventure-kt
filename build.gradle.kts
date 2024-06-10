plugins {
    alias(libs.plugins.kotlin.jvm)
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = "ink.nostal.advkt"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}