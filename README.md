# adventure-kt

**English** | [简体中文](https://github.com/PlutoProject/adventure-kt/blob/master/README_CN.md)

> [!WARNING]
>
> This project is still **working in progress**.
>
> Some interfaces may not work / change in the future.
>
> Use it as your own risk.

⛏️ Full Kotlin support for [Kyori Adventure](https://github.com/KyoriPowered/adventure).

## 🤔 purpose

Since Kotlin brought us the ability to create [Extensions](https://kotlinlang.org/docs/extensions.html), we can create DSLs.

This project aimed to create many DSL utilities for adventure's builder pattern API, which make your life easier.

## 📦 artifacts

###  repository

```kotlin
repositories {
    maven(uri("https://maven.nostal.ink/repository/maven-public"))
}
```

### dependency

```kotlin
dependencies {
    // Use shadowJar to shade the artifact in your jar
    api("ink.pmc.advkt:core:1.0.0-SNAPSHOT")
}

tasks.shadowJar {
    relocate("ink.pmc.advkt", "com.example.libs.advkt")
}
```