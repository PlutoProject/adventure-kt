package ink.pmc.advkt.title

import net.kyori.adventure.title.Title.Times
import net.kyori.adventure.util.Ticks
import java.time.Duration
import kotlin.time.toJavaDuration

private typealias KtDuration = kotlin.time.Duration

interface TimesKt {

    fun build(): Times

}

class TitleTimesKt : TimesKt {

    object Defaults {
        val fadeIn = Ticks.duration(10)
        val stay = Ticks.duration(70)
        val fadeOut =  Ticks.duration(20)
    }

    internal var fadeIn = Defaults.fadeIn
    internal var stay = Defaults.stay
    internal var fadeOut = Defaults.fadeOut

    override fun build(): Times {
        return Times.times(fadeIn, stay, fadeOut)
    }

}

// I think nobody will use this separately
/*fun times(content: TitleTimesKt.() -> Unit): Times {
    return TitleTimesKt().apply(content).build()
}*/

fun TitleTimesKt.fadeIn(duration: Duration) {
    fadeIn = duration
}

fun TitleTimesKt.fadeIn(duration: KtDuration) {
    fadeIn(duration.toJavaDuration())
}

fun TitleTimesKt.stay(duration: Duration) {
    stay = duration
}

fun TitleTimesKt.stay(duration: KtDuration) {
    stay(duration.toJavaDuration())
}

fun TitleTimesKt.fadeOut(duration: Duration) {
    fadeOut = duration
}

fun TitleTimesKt.fadeOut(duration: KtDuration) {
    fadeOut(duration.toJavaDuration())
}