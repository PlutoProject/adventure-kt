package ink.pmc.advkt

import ink.pmc.advkt.component.aqua
import ink.pmc.advkt.component.red
import ink.pmc.advkt.component.text
import ink.pmc.advkt.title.*
import kotlin.time.Duration.Companion.seconds

fun main() {
    val title = title {
        mainTitle {
            text("This is a title") with aqua()
        }
        subTitle {
            text("This is a subtitle") with red()
        }
        times {
            fadeIn(1.seconds)
            stay(1.seconds)
            fadeOut(1.seconds)
        }
    }
}