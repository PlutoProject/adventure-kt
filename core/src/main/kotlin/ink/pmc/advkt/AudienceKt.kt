package ink.pmc.advkt

import ink.pmc.advkt.book.BookKt
import ink.pmc.advkt.bossbar.BossBarKt
import ink.pmc.advkt.component.RootComponentKt
import ink.pmc.advkt.sound.SoundKt
import ink.pmc.advkt.title.ComponentTitleKt
import net.kyori.adventure.audience.Audience

inline fun Audience.send(message: RootComponentKt.() -> Unit) {
    this.sendMessage(RootComponentKt().apply(message).build())
}

inline fun Audience.openBook(book: BookKt.() -> Unit) {
    this.openBook(BookKt().apply(book).build())
}

inline fun Audience.showTitle(title: ComponentTitleKt.() -> Unit) {
    this.showTitle(ComponentTitleKt().apply(title).build())
}

inline fun Audience.sendActionBar(actionbar: RootComponentKt.() -> Unit) {
    this.sendActionBar(RootComponentKt().apply(actionbar).build())
}

inline fun Audience.playSound(sound: SoundKt.() -> Unit) {
    this.playSound(SoundKt().apply(sound).build())
}

inline fun Audience.playSound(x: Double, y: Double, z: Double, sound: SoundKt.() -> Unit) {
    this.playSound(SoundKt().apply(sound).build(), x, y, z)
}

inline fun Audience.showBossBar(bossBar: BossBarKt.() -> Unit) {
    this.showBossBar(BossBarKt().apply(bossBar).build())
}

inline fun Audience.sendPlayerListHeader(content: RootComponentKt.() -> Unit) {
    this.sendPlayerListHeader(RootComponentKt().apply(content).build())
}

inline fun Audience.sendPlayerListFooter(content: RootComponentKt.() -> Unit) {
    this.sendPlayerListFooter(RootComponentKt().apply(content).build())
}