package ink.nostal.advkt

import net.kyori.adventure.text.format.Style
import net.kyori.adventure.text.format.TextDecoration

fun obfuscated(): Style {
    return Style.style(TextDecoration.OBFUSCATED)
}

fun bold(): Style {
    return Style.style(TextDecoration.BOLD)
}

fun strikethrough(): Style {
    return Style.style(TextDecoration.STRIKETHROUGH)
}

fun underlined(): Style {
    return Style.style(TextDecoration.UNDERLINED)
}

fun italic(): Style {
    return Style.style(TextDecoration.ITALIC)
}
