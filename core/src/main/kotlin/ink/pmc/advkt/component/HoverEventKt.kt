package ink.pmc.advkt.component

import net.kyori.adventure.text.event.HoverEvent

fun hoverEvent(): HoverEventWithoutKt {
    return HoverEventWithoutKt()
}

fun showText(text: RootComponentKt.() -> Unit): HoverEventKt {
    return HoverEventKt(HoverEvent.showText(RootComponentKt().apply(text).build()))
}