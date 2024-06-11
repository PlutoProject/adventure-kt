package ink.pmc.advkt

import net.kyori.adventure.audience.Audience

fun Audience.send(message: RootComponentKt.() -> Unit) {
    this.sendMessage(RootComponentKt().apply(message).build())
}

fun Audience.showTitle(title: ComponentTitleKt.() -> Unit) {
    this.showTitle(ComponentTitleKt().apply(title).build())
}

fun Audience.sendActionBar(actionbar: RootComponentKt.() -> Unit) {
    this.sendActionBar(RootComponentKt().apply(actionbar).build())
}