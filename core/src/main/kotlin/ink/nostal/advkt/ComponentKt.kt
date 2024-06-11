package ink.nostal.advkt

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.JoinConfiguration
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import net.kyori.adventure.text.format.Style
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.serializer.ansi.ANSIComponentSerializer
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import net.kyori.ansi.ColorLevel

interface ComponentKt {

    fun build(): Component

}

class TextComponentKt(internal var component: Component) : ComponentKt {

    override fun build(): Component {
        return this.component
    }

}

class RootComponentKt : ComponentKt {

    internal var miniMessage: MiniMessage = MiniMessage.miniMessage()
    internal var defaults: RootDefaults? = null
    internal var join: JoinConfiguration? = null
    internal val components: MutableList<ComponentKt> = mutableListOf()

    infix fun TextComponentKt.with(styleKt: StyleKt): TextComponentKt {
        this.component = this.component.style(styleKt.with(this.component.style()))
        return this
    }

    infix fun TextComponentKt.with(hoverEvent: HoverEvent<*>): TextComponentKt {
        this.component = this.component.hoverEvent(hoverEvent)
        return this
    }

    infix fun TextComponentKt.with(clickEvent: ClickEvent): TextComponentKt {
        this.component = this.component.clickEvent(clickEvent)
        return this
    }

    infix fun TextComponentKt.without(styleKt: StyleKt): TextComponentKt {
        this.component = this.component.style(styleKt.without(this.component.style()))
        return this
    }

    override fun build(): Component {
        if (join == null) {
            var root = Component.empty()
            if (this.defaults != null) {
                root = root.style(this.defaults!!.style)
                if (this.defaults!!.hoverEvent != null) {
                    root = root.hoverEvent(this.defaults!!.hoverEvent)
                }
                if (this.defaults!!.clickEvent != null) {
                    root = root.clickEvent(this.defaults!!.clickEvent)
                }
            }
            for (component in this.components) {
                root = root.append(component.build())
            }
            return root
        } else {
            return Component.join(this.join!!, this.components.map { it.build() })
        }
    }

}

class RootDefaults {

    internal var style: Style = Style.empty()
    internal var hoverEvent: HoverEvent<*>? = null
    internal var clickEvent: ClickEvent? = null

    fun with(styleKt: StyleKt) {
        this.style = styleKt.with(this.style)
    }

    fun without(styleKt: StyleKt) {
        this.style = styleKt.without(this.style)
    }

    fun with(hoverEvent: HoverEvent<*>) {
        this.hoverEvent = hoverEvent
    }

    fun with(clickEvent: ClickEvent) {
        this.clickEvent = clickEvent
    }

}

fun component(content: RootComponentKt.() -> Unit): Component {
    return RootComponentKt().apply(content).build()
}

fun RootComponentKt.defaults(content: RootDefaults.() -> Unit) {
    this.defaults = RootDefaults().apply(content)
}

fun RootComponentKt.provide(miniMessage: MiniMessage) {
    this.miniMessage = miniMessage
}

fun RootComponentKt.provide(builder: MiniMessage.Builder.() -> Unit) {
    this.miniMessage = MiniMessage.builder().apply(builder).build()
}

fun RootComponentKt.component(content: RootComponentKt.() -> Unit) {
    val component = RootComponentKt()
    component.miniMessage = this.miniMessage
    this.components.add(component.apply(content))
}

fun RootComponentKt.join(content: JoinConfiguration.Builder.() -> Unit) {
    this.join = JoinConfiguration.builder().apply(content).build()
}

fun RootComponentKt.raw(text: Component): TextComponentKt {
    val component = TextComponentKt(text)
    this.components.add(component)
    return component
}

fun RootComponentKt.text(text: String): TextComponentKt {
    val component = TextComponentKt(Component.text(text))
    this.components.add(component)
    return component
}

fun RootComponentKt.translatable(key: String): TextComponentKt {
    val component = TextComponentKt(Component.translatable(key))
    this.components.add(component)
    return component
}

fun RootComponentKt.keybind(keybind: String): TextComponentKt {
    val component = TextComponentKt(Component.keybind(keybind))
    this.components.add(component)
    return component
}

fun RootComponentKt.miniMessage(rawText: String): TextComponentKt {
    val component = TextComponentKt(this.miniMessage.deserialize(rawText))
    this.components.add(component)
    return component
}

fun RootComponentKt.newline(): TextComponentKt {
    val component = TextComponentKt(Component.newline())
    this.components.add(component)
    return component
}

fun RootComponentKt.empty(): TextComponentKt {
    val component = TextComponentKt(Component.empty())
    this.components.add(component)
    return component
}

fun RootComponentKt.space(): TextComponentKt {
    val component = TextComponentKt(Component.space())
    this.components.add(component)
    return component
}

fun Component.json(): String {
    return GsonComponentSerializer.gson().serialize(this)
}

fun Component.legacy(): String {
    return LegacyComponentSerializer.legacySection().serialize(this)
}

fun Component.plain(): String {
    return PlainTextComponentSerializer.plainText().serialize(this)
}

fun Component.ansi(): String {
    return ANSIComponentSerializer.builder().colorLevel(ColorLevel.TRUE_COLOR).build().serialize(this)
}