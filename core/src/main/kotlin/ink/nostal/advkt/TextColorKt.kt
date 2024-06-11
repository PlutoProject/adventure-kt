package ink.nostal.advkt

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor

fun color(): TextColorWithoutKt { // this method is used for "without" method
    return TextColorWithoutKt()
}

fun rgb(r: Int, g: Int, b: Int): TextColorKt {
    return TextColorKt(TextColor.color(r, g, b))
}

fun rgb(rgb: Int): TextColorKt {
    return TextColorKt(TextColor.color(rgb))
}

fun hex(hex: String): TextColorKt {
    return TextColorKt(TextColor.fromHexString(hex)!!)
}

fun black(): TextColorKt {
    return TextColorKt(NamedTextColor.BLACK)
}

fun darkBlue(): TextColorKt {
    return TextColorKt(NamedTextColor.DARK_BLUE)
}

fun darkGreen(): TextColorKt {
    return TextColorKt(NamedTextColor.DARK_GREEN)
}

fun darkAqua(): TextColorKt {
    return TextColorKt(NamedTextColor.DARK_AQUA)
}

fun darkRed(): TextColorKt {
    return TextColorKt(NamedTextColor.DARK_RED)
}

fun darkPurple(): TextColorKt {
    return TextColorKt(NamedTextColor.DARK_PURPLE)
}

fun gold(): TextColorKt {
    return TextColorKt(NamedTextColor.GOLD)
}

fun gray(): TextColorKt {
    return TextColorKt(NamedTextColor.GRAY)
}

fun darkGray(): TextColorKt {
    return TextColorKt(NamedTextColor.DARK_GRAY)
}

fun blue(): TextColorKt {
    return TextColorKt(NamedTextColor.BLUE)
}

fun green(): TextColorKt {
    return TextColorKt(NamedTextColor.GREEN)
}

fun aqua(): TextColorKt {
    return TextColorKt(NamedTextColor.AQUA)
}

fun red(): TextColorKt {
    return TextColorKt(NamedTextColor.RED)
}

fun lightPurple(): TextColorKt {
    return TextColorKt(NamedTextColor.LIGHT_PURPLE)
}

fun yellow(): TextColorKt {
    return TextColorKt(NamedTextColor.YELLOW)
}

fun white(): TextColorKt {
    return TextColorKt(NamedTextColor.WHITE)
}