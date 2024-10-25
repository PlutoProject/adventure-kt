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
    maven(uri("https://maven.nostal.ink/repository/maven-public/"))
}
```

### dependency

```kotlin
dependencies {
    // Use shadowJar to shade the artifact into your jar
    api("ink.pmc.advkt:core:1.0.0-SNAPSHOT")
}

tasks.shadowJar {
    relocate("ink.pmc.advkt", "com.example.libs.advkt")
}
```

## ☕ examples

### creating a component

```kotlin
component {
    text("This is a text component, nothing special.")
    text("This is a colorized text component.") with red()
    text("This is a colorized text component.") with color(249, 226, 145) // support RGB and hex color
    newline()
    text("This is a styled text component.") with bold() without italic()
}

// you can also use the following syntax
player.send {
    text("This is a text component, nothing special.")
}
```

### creating a title

```kotlin
title {
    mainTitle {
        text("This is a main title.")
    }
    subTitle {
        text("This is a sub title.")
    }
    // support both Kotlin duration and Java duration
    times {
        fadeIn(1.seconds)
        stay(1.seconds)
        fadeOut(1.seconds)
    }
}
```
