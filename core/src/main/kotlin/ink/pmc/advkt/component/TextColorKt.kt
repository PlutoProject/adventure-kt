package ink.pmc.advkt.component

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor

class GradientColor(
    private val from: TextColor,
    private val to: TextColor,
    private val more: List<TextColor>
) {

    fun buildString(): String {
        val builder = StringBuilder()
        builder.append(":")
            .append(this.from.asHexString())
            .append(":")
            .append(this.to.asHexString())
        for (color in this.more) {
            builder.append(":")
                .append(color.asHexString())
        }
        return builder.toString()
    }

}

fun color(): TextColorWithoutKt { // this method is used for "without" method
    return TextColorWithoutKt()
}

fun color(textColor: TextColor): TextColorKt {
    return TextColorKt(textColor)
}

fun rgb(r: Int, g: Int, b: Int): TextColorKt {
    return TextColorKt(TextColor.color(r, g, b))
}

fun rgb(rgb: Int): TextColorKt {
    return TextColorKt(TextColor.color(rgb))
}

fun hex(hex: String): TextColorKt {
    if (!hex.startsWith("#"))
        return TextColorKt(TextColor.fromHexString("#$hex")!!)
    return TextColorKt(TextColor.fromHexString(hex)!!)
}

fun gradient(from: TextColor, to: TextColor, vararg more: TextColor): GradientColor {
    return GradientColor(from, to, listOf(*more))
}

fun gradient(from: TextColorKt, to: TextColorKt, vararg more: TextColorKt): GradientColor {
    return GradientColor(from.textColor, to.textColor, more.map { it.textColor })
}

fun gradient(from: TextColorKt, to: TextColor, vararg more: TextColorKt): GradientColor {
    return GradientColor(from.textColor, to, more.map { it.textColor })
}

fun gradient(from: TextColor, to: TextColorKt, vararg more: TextColorKt): GradientColor {
    return GradientColor(from, to.textColor, more.map { it.textColor })
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