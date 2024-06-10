package ink.nostal.advkt

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.Style
import net.kyori.adventure.text.format.TextColor


fun rgb(r: Int, g: Int, b: Int): Style {
    return Style.style(TextColor.color(r, g, b))
}

fun rgb(rgb: Int): Style {
    return Style.style(TextColor.color(rgb))
}

fun hex(hex: String): Style {
    return Style.style(TextColor.fromHexString(hex))
}

fun black(): Style {
    return Style.style(NamedTextColor.BLACK)
}

fun darkBlue(): Style {
    return Style.style(NamedTextColor.DARK_BLUE)
}

fun darkGreen(): Style {
    return Style.style(NamedTextColor.DARK_GREEN)
}

fun darkAqua(): Style {
    return Style.style(NamedTextColor.DARK_AQUA)
}

fun darkRed(): Style {
    return Style.style(NamedTextColor.DARK_RED)
}

fun darkPurple(): Style {
    return Style.style(NamedTextColor.DARK_PURPLE)
}

fun gold(): Style {
    return Style.style(NamedTextColor.GOLD)
}

fun gray(): Style {
    return Style.style(NamedTextColor.GRAY)
}

fun darkGray(): Style {
    return Style.style(NamedTextColor.DARK_GRAY)
}

fun blue(): Style {
    return Style.style(NamedTextColor.BLUE)
}

fun green(): Style {
    return Style.style(NamedTextColor.GREEN)
}

fun aqua(): Style {
    return Style.style(NamedTextColor.AQUA)
}

fun red(): Style {
    return Style.style(NamedTextColor.RED)
}

fun lightPurple(): Style {
    return Style.style(NamedTextColor.LIGHT_PURPLE)
}

fun yellow(): Style {
    return Style.style(NamedTextColor.YELLOW)
}

fun white(): Style {
    return Style.style(NamedTextColor.WHITE)
}