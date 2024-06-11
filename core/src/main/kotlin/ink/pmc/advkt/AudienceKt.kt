package ink.pmc.advkt

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