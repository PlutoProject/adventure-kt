package ink.pmc.advkt

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.HoverEvent

fun showText(text: RootComponentKt.() -> Unit): HoverEvent<Component> {
    return HoverEvent.showText(RootComponentKt().apply(text).build())
}