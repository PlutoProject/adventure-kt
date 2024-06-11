package ink.pmc.advkt

import net.kyori.adventure.key.Key
import net.kyori.adventure.sound.Sound
import net.kyori.adventure.sound.Sound.Source
import net.kyori.adventure.sound.Sound.Type

class SoundKt {

    object Defaults {
        const val VOLUME = 1.0F
        const val PITCH = 1.0F
    }

    internal var key: Key? = null
    internal var type: Type? = null
    internal var source: Source? = null
    internal var volume: Float = Defaults.VOLUME
    internal var pitch: Float = Defaults.PITCH

    fun build(): Sound {
        return if (key != null) {
            Sound.sound(key!!, source!!, volume, pitch)
        } else {
            Sound.sound(type!!, source!!, volume, pitch)
        }
    }

}

fun sound(content: SoundKt.() -> Unit): Sound {
    return SoundKt().apply(content).build()
}

fun SoundKt.key(key: Key) {
    this.key = key
}

fun SoundKt.type(type: Type) {
    this.type = type
}

fun SoundKt.source(source: Source) {
    this.source = source
}

fun SoundKt.volume(volume: Float) {
    this.volume = volume
}

fun SoundKt.pitch(pitch: Float) {
    this.pitch = pitch
}