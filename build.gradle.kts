plugins {
    id("maven-publish")
    alias(libs.plugins.kotlin.jvm)
}

fun kt(dep: String): String {
    return "org.jetbrains.kotlin.$dep"
}

allprojects {
    apply {
        plugin("maven-publish")
        plugin(kt("jvm"))
    }

    group = "ink.pmc.advkt"
    version = "1.0.1"

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

subprojects {
    publishing {
        if (project.name == "test"){
            return@publishing
        }

        repositories {
            maven {
                name = "nostal"
                url = uri(
                    if (version.toString().endsWith("SNAPSHOT")) {
                        "https://maven.nostal.ink/repository/maven-snapshots/"
                    } else {
                        "https://maven.nostal.ink/repository/maven-releases/"
                    }
                )
                credentials(PasswordCredentials::class)
            }
        }

        publications.create<MavenPublication>("maven") {
            artifact(tasks.jar)
        }
    }
}