package ink.pmc.advkt.component

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.JoinConfiguration
import net.kyori.adventure.text.TextReplacementConfig
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
    internal var replaces: RootReplaces? = null
    internal var join: JoinConfiguration? = null
    internal val components: MutableList<ComponentKt> = mutableListOf()

    infix fun TextComponentKt.with(styleKt: StyleKt): TextComponentKt {
        this.component = this.component.style(styleKt.with(this.component.style()))
        return this
    }

    infix fun TextComponentKt.with(color: TextColor): TextComponentKt {
        this.component = this.component.color(color)
        return this
    }

    infix fun TextComponentKt.with(decoration: TextDecoration): TextComponentKt {
        this.component = this.component.decorate(decoration)
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

    infix fun TextComponentKt.without(decoration: TextDecoration): TextComponentKt {
        this.component = this.component.decoration(decoration, false)
        return this
    }

    infix fun TextComponentKt.without(color: TextColor): TextComponentKt {
        this.component = this.component.color(null)
        return this
    }

    override fun build(): Component {
        if (join == null) {
            var root: Component = Component.empty()
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
            return applyReplacement(root)
        } else {
            return Component.join(this.join!!, this.components.map { applyReplacement(it.build()) })
        }
    }

    private fun applyReplacement(component: Component): Component {
        var variable = component
        if (this.replaces != null) {
            var replacer = this.replaces
            while (replacer?.parent != null && !replacer.overriden) {
                for (replacementConfig in replacer.replaces) {
                    variable = variable.replaceText(replacementConfig)
                }
                replacer = replacer.parent
            }
        }
        return variable
    }

}

class RootDefaults {

    internal var style: Style = Style.empty()
    internal var hoverEvent: HoverEvent<*>? = null
    internal var clickEvent: ClickEvent? = null

    fun with(styleKt: StyleKt) {
        this.style = styleKt.with(this.style)
    }

    fun with(color: TextColor) {
        this.style = this.style.color(color)
    }

    fun with(decoration: TextDecoration) {
        this.style = this.style.decorate(decoration)
    }

    fun with(hoverEvent: HoverEvent<*>) {
        this.style = this.style.hoverEvent(hoverEvent)
    }

    fun with(clickEvent: ClickEvent) {
        this.style = this.style.clickEvent(clickEvent)
    }

    fun without(styleKt: StyleKt) {
        this.style = styleKt.without(this.style)
    }

    fun without(decoration: TextDecoration) {
        this.style = this.style.decoration(decoration, false)
    }

    fun without(color: TextColor) {
        this.style = this.style.color(null)
    }

}

class RootReplaces(
    internal val parent: RootReplaces?,
) {

    internal var overriden: Boolean = false
    internal val replaces: MutableList<TextReplacementConfig> = mutableListOf()

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
    component.replaces = this.replaces
    this.components.add(component.apply(content))
}

fun RootComponentKt.join(content: JoinConfiguration.Builder.() -> Unit) {
    this.join = JoinConfiguration.builder().apply(content).build()
}

fun RootComponentKt.replacements(content: RootReplaces.() -> Unit) {
    if (this.replaces != null) {
        this.replaces!!.apply(content)
    } else {
        this.replaces = RootReplaces(null).apply(content)
    }
}

fun RootReplaces.replacement(content: TextReplacementConfig.Builder.() -> Unit) {
    this.replaces.add(TextReplacementConfig.builder().apply(content).build())
}

fun RootReplaces.override() {
    this.overriden = true
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

fun RootComponentKt.text(text: Char): TextComponentKt {
    val component = TextComponentKt(Component.text(text))
    this.components.add(component)
    return component
}

fun RootComponentKt.text(text: Boolean): TextComponentKt {
    val component = TextComponentKt(Component.text(text))
    this.components.add(component)
    return component
}

fun RootComponentKt.text(text: Int): TextComponentKt {
    val component = TextComponentKt(Component.text(text))
    this.components.add(component)
    return component
}


fun RootComponentKt.text(text: Long): TextComponentKt {
    val component = TextComponentKt(Component.text(text))
    this.components.add(component)
    return component
}

fun RootComponentKt.text(text: Float): TextComponentKt {
    val component = TextComponentKt(Component.text(text))
    this.components.add(component)
    return component
}

fun RootComponentKt.text(text: Double): TextComponentKt {
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

fun Component.replace(string: String, component: Component): Component {
    val replaceConfig = TextReplacementConfig.builder()
        .match(string)
        .replacement(component)
        .build()

    return this.replaceText(replaceConfig)
}

fun Component.replace(string: String, text: String): Component {
    return this.replace(string, Component.text(text))
}

fun Component.replaceColor(targetColor: TextColor, newColor: TextColor): Component {
    val updatedComponent = if (this.color() == targetColor) {
        this.color(newColor)
    } else {
        this
    }

    return updatedComponent.children().fold(updatedComponent.children(emptyList())) { component, child ->
        component.append(child.replaceColor(targetColor, newColor))
    }
}

fun TextReplacementConfig.Builder.replace(content: RootComponentKt.() -> Unit) {
    this.replacement(RootComponentKt().apply(content).build())
}