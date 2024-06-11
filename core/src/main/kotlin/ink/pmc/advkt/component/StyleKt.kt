package ink.pmc.advkt.component

import net.kyori.adventure.text.format.Style
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration

interface StyleKt {

    fun with(original: Style): Style

    fun without(original: Style): Style

}

open class TextColorWithoutKt : StyleKt {

    override fun with(original: Style): Style {
        throw IllegalAccessException("This style is only for without use")
    }

    override fun without(original: Style): Style {
        return original.color(null)
    }

}

class TextColorKt(private val textColor: TextColor) : TextColorWithoutKt() {

    override fun with(original: Style): Style {
        return original.color(this.textColor)
    }

}

class TextDecorationKt(private val textDecoration: TextDecoration) : StyleKt {

    override fun with(original: Style): Style {
        return original.decoration(this.textDecoration, true)
    }

    override fun without(original: Style): Style {
        return original.decoration(this.textDecoration, false)
    }

}