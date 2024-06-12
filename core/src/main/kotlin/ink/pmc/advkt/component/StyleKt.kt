package ink.pmc.advkt.component

import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
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

open class ClickEventWithoutKt : StyleKt {

    override fun with(original: Style): Style {
        throw IllegalAccessException("This style is only for without use")
    }

    override fun without(original: Style): Style {
        return original.clickEvent(null)
    }

}

class ClickEventKt(private val clickEvent: ClickEvent) : ClickEventWithoutKt() {

    override fun with(original: Style): Style {
        return original.clickEvent(this.clickEvent)
    }

}

open class HoverEventWithoutKt : StyleKt {

    override fun with(original: Style): Style {
        throw IllegalAccessException("This style is only for without use")
    }

    override fun without(original: Style): Style {
        return original.hoverEvent(null)
    }

}

class HoverEventKt(private val hoverEvent: HoverEvent<*>) : HoverEventWithoutKt() {

    override fun with(original: Style): Style {
        return original.hoverEvent(this.hoverEvent)
    }

}

open class InsertionWithoutKt() : StyleKt {

    override fun with(original: Style): Style {
        throw IllegalAccessException("This style is only for without use")
    }

    override fun without(original: Style): Style {
        return original.insertion(null)
    }

}

class InsertionKt(private val insertion: String) : InsertionWithoutKt() {

    override fun with(original: Style): Style {
        return original.insertion(this.insertion)
    }

}