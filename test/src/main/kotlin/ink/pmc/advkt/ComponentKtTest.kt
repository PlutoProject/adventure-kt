package ink.pmc.advkt

import ink.pmc.advkt.component.*
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver

fun main() {
    val text = component {
        defaults {
            with(rgb(1, 2, 3))
            with(italic())
        }

        provide(
            MiniMessage.builder()
                .strict(true)
                .build()
        )

        replacements {
            replacement {
                once()
                match("[a-zA-Z0-9]+")
                replace {
                    text("")
                }
            }
        }

        text("Hello world") with showText {
            text("Hover")
        } with hex("66ccff")
        newline()

        text("With color red!") with red() with bold() without italic()
        newline()

        text("Click me!") with callback {
            it.send {
                text("You just click a text!")
            }
        } without color()

        empty() // this can do nothing, but I added it lol

        translatable("minecraft.enchantment.protection") // should be "Protection" under English (US)
        space()
        miniMessage("<gray>MiniMessage!</gray>")
        space()
        keybind("key.keyboard.space") // should be "空格" under Simplified Chinese

        component {
            provide {
                strict(false)
                tags(TagResolver.standard())
            }

            text("You can even 套娃 in the component")
        }

        newline()

        component {
            join {
                separator(Component.text("!"))
            }

            replacements {
                override()
                replacement {
                    once()
                    match("[a-zA-Z0-9]+")
                    replace {
                        text("") with insertion("") // just showcase of insertion, i dont know what can it do
                    }
                }
            }
            text("first")
            text("second")
            text("third")
        }
    }

    println(text.ansi())
}