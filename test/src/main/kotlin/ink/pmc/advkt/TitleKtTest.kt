package ink.pmc.advkt

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