# adventure-kt

[English](https://github.com/PlutoProject/adventure-kt) | **简体中文**

> [!WARNING]
>
> 该项目仍然**处于开发状态**。
>
> 一些接口可能会在未来的版本中移除或不可用。
>
> 请确保您已知晓该风险。

⛏️ 为 [Kyori Adventure](https://github.com/KyoriPowered/adventure) 打造的完整 Kotlin 支持。

## 🤔 主旨

自从 Kotlin 引入了对 [拓展](https://kotlinlang.org/docs/extensions.html) 的支持，我们可以创建 DSL *(Domain Specific Language, 领域特定语言)* 了。

该项目皆在提供一系列的 DSL 包装给 Adventure 原有的构建器模式 API，让开发更轻松。

## 📦 成品

###  仓库

```kotlin
repositories {
    maven(uri("https://maven.nostal.ink/repository/maven-public"))
}
```

### 依赖

```kotlin
dependencies {
    // 用 shadowJar 来打包进你的 jar
    api("ink.pmc.advkt:core:1.0.0-SNAPSHOT")
}

tasks.shadowJar {
    relocate("ink.pmc.advkt", "com.example.libs.advkt")
}
```

## ☕ 实例

### 创建一个组件

```kotlin
component {
    text("这是一个文字组件，没什么特殊的。")
    text("这是一个有颜色的文字组件。") with red()
    text("这是一个有颜色的文字组件。") with color(249, 226, 145) // 支持 RGB 和 16 进制颜色。
    newline()
    text("这是一个有样式的文字组件。") with bold() without italic()
}

// 你也可以使用这样的语法
player.send {
    text("这是一个文字组件，没什么特殊的。")
}
```

### 创建一个标题

```kotlin
title {
    mainTitle {
        text("这是一个主标题。")
    }
    subTitle {
        text("这是一个副标题。")
    }
    // 支持传入 Kotlin Duration 和 Java Duration
    times {
        fadeIn(1.seconds)
        stay(1.seconds)
        fadeOut(1.seconds)
    }
}
```