package ink.pmc.advkt

import net.kyori.adventure.audience.Audience

fun Audience.send(message: RootComponentKt.() -> Unit) {
    this.sendMessage(RootComponentKt().apply(message).build())
}