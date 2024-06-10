package ink.nostal.advkt

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor

fun color(): TextColor { // this method is used for "without" method
    return rgb(0)
}

fun rgb(r: Int, g: Int, b: Int): TextColor {
    return TextColor.color(r, g, b)
}

fun rgb(rgb: Int): TextColor {
    return TextColor.color(rgb)
}

fun hex(hex: String): TextColor {
    return TextColor.fromHexString(hex)!!
}

fun black(): TextColor {
    return NamedTextColor.BLACK
}

fun darkBlue(): TextColor {
    return NamedTextColor.DARK_BLUE
}

fun darkGreen(): TextColor {
    return NamedTextColor.DARK_GREEN
}

fun darkAqua(): TextColor {
    return NamedTextColor.DARK_AQUA
}

fun darkRed(): TextColor {
    return NamedTextColor.DARK_RED
}

fun darkPurple(): TextColor {
    return NamedTextColor.DARK_PURPLE
}

fun gold(): TextColor {
    return NamedTextColor.GOLD
}

fun gray(): TextColor {
    return NamedTextColor.GRAY
}

fun darkGray(): TextColor {
    return NamedTextColor.DARK_GRAY
}

fun blue(): TextColor {
    return NamedTextColor.BLUE
}

fun green(): TextColor {
    return NamedTextColor.GREEN
}

fun aqua(): TextColor {
    return NamedTextColor.AQUA
}

fun red(): TextColor {
    return NamedTextColor.RED
}

fun lightPurple(): TextColor {
    return NamedTextColor.LIGHT_PURPLE
}

fun yellow(): TextColor {
    return NamedTextColor.YELLOW
}

fun white(): TextColor {
    return NamedTextColor.WHITE
}