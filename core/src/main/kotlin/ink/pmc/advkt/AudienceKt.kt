package ink.pmc.advkt

import ink.pmc.advkt.component.RootComponentKt
import ink.pmc.advkt.title.ComponentTitleKt
import net.kyori.adventure.audience.Audience

fun Audience.send(message: RootComponentKt.() -> Unit) {
    this.sendMessage(RootComponentKt().apply(message).build())
}

fun Audience.openBook(book: BookKt.() -> Unit) {
    this.openBook(BookKt().apply(book).build())
}

fun Audience.showTitle(title: ComponentTitleKt.() -> Unit) {
    this.showTitle(ComponentTitleKt().apply(title).build())
}

fun Audience.sendActionBar(actionbar: RootComponentKt.() -> Unit) {
    this.sendActionBar(RootComponentKt().apply(actionbar).build())
}

fun Audience.playSound(sound: SoundKt.() -> Unit) {
    this.playSound(SoundKt().apply(sound).build())
}

fun Audience.playSound(x: Double, y: Double, z: Double, sound: SoundKt.() -> Unit) {
    this.playSound(SoundKt().apply(sound).build(), x, y, z)
}

fun Audience.showBossBar(bossBar: BossBarKt.() -> Unit) {
    this.showBossBar(BossBarKt().apply(bossBar).build())
}

fun Audience.sendPlayerListHeader(content: RootComponentKt.() -> Unit) {
    this.sendPlayerListHeader(RootComponentKt().apply(content).build())
}

fun Audience.sendPlayerListFooter(content: RootComponentKt.() -> Unit) {
    this.sendPlayerListFooter(RootComponentKt().apply(content).build())
}