package ink.pmc.advkt.component

import net.kyori.adventure.text.format.TextDecoration

fun obfuscated(): TextDecorationKt {
    return TextDecorationKt(TextDecoration.OBFUSCATED)
}

fun bold(): TextDecorationKt {
    return TextDecorationKt(TextDecoration.BOLD)
}

fun strikethrough(): TextDecorationKt {
    return TextDecorationKt(TextDecoration.STRIKETHROUGH)
}

fun underlined(): TextDecorationKt {
    return TextDecorationKt(TextDecoration.UNDERLINED)
}

fun italic(): TextDecorationKt {
    return TextDecorationKt(TextDecoration.ITALIC)
}

fun TextDecoration.kt(): TextDecorationKt {
    return TextDecorationKt(this)
}