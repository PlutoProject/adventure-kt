package ink.pmc.advkt.component

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.event.ClickCallback
import net.kyori.adventure.text.event.ClickEvent
import java.net.URL

fun clickEvent(): ClickEventWithoutKt {
    return ClickEventWithoutKt()
}

fun openUrl(url: String): ClickEventKt {
    return ClickEventKt(ClickEvent.openUrl(url))
}

fun openUrl(url: URL): ClickEventKt {
    return ClickEventKt(ClickEvent.openUrl(url))
}

fun openFile(file: String): ClickEventKt {
    return ClickEventKt(ClickEvent.openFile(file))
}

fun runCommand(command: String): ClickEventKt {
    return ClickEventKt(ClickEvent.runCommand(command))
}

fun suggestCommand(command: String): ClickEventKt {
    return ClickEventKt(ClickEvent.suggestCommand(command))
}

fun changePage(page: String): ClickEventKt {
    return ClickEventKt(ClickEvent.changePage(page))
}

fun changePage(page: Int): ClickEventKt {
    return ClickEventKt(ClickEvent.changePage(page))
}

fun copyToClipboard(text: String): ClickEventKt {
    return ClickEventKt(ClickEvent.copyToClipboard(text))
}

fun callback(function: (Audience) -> Unit): ClickEventKt {
    return ClickEventKt(ClickEvent.callback(function))
}

fun callback(options: ClickCallback.Options, function: (Audience) -> Unit): ClickEventKt {
    return ClickEventKt(ClickEvent.callback(function, options))
}

fun ClickEvent.kt(): ClickEventKt {
    return ClickEventKt(this)
}