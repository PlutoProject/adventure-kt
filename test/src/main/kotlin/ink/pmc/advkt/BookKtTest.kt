package ink.pmc.advkt

import ink.pmc.advkt.book.author
import ink.pmc.advkt.book.book
import ink.pmc.advkt.book.page
import ink.pmc.advkt.book.title
import ink.pmc.advkt.component.text

fun main() {
    val book = book {
        title {
            text("Just a book")
        }
        author {
            text("DeeChael")
        }

        page {
            text("You are in the first page")
        }
        page {
            text("now in the second!")
        }
    }
}