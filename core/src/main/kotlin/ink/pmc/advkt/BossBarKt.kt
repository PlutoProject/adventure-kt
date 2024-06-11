package ink.pmc.advkt

import ink.pmc.advkt.component.RootComponentKt
import ink.pmc.advkt.component.component
import net.kyori.adventure.bossbar.BossBar
import net.kyori.adventure.text.Component

class BossBarKt {

    object Defaults {
        const val PROGRESS: Float = 0.0F
        val color: BossBar.Color = BossBar.Color.WHITE
        val overlay: BossBar.Overlay = BossBar.Overlay.PROGRESS
    }

    internal var name: Component = component {  }
    internal var progress: Float = Defaults.PROGRESS
    internal var color: BossBar.Color = Defaults.color
    internal var overlay: BossBar.Overlay = Defaults.overlay
    internal var flags: MutableSet<BossBar.Flag> = mutableSetOf()

    fun build(): BossBar {
        return BossBar.bossBar(name, progress, color, overlay, flags)
    }

}

fun bossBar(content: BossBarKt.() -> Unit): BossBar {
    return BossBarKt().apply(content).build()
}

fun BossBarKt.name(component: Component) {
    this.name = component
}

fun BossBarKt.name(content: RootComponentKt.() -> Unit) {
    name(RootComponentKt().apply(content).build())
}

fun BossBarKt.progress(progress: Float) {
    this.progress = progress
}

fun BossBarKt.color(color: BossBar.Color) {
    this.color = color
}

fun BossBarKt.overlay(overlay: BossBar.Overlay) {
    this.overlay = overlay
}

fun BossBarKt.flag(flag: BossBar.Flag) {
    this.flags.add(flag)
}