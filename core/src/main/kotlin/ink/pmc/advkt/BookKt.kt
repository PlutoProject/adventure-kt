package ink.pmc.advkt

import net.kyori.adventure.inventory.Book
import net.kyori.adventure.text.Component

class BookKt {

    internal var title: Component = Component.empty()
    internal var author: Component = Component.empty()
    internal val pages = mutableListOf<Component>()

    fun build(): Book {
        return Book.book(title, author, pages)
    }

}

fun book(content: BookKt.() -> Unit): Book {
    return BookKt().apply(content).build()
}

fun BookKt.title(content: RootComponentKt.() -> Unit) {
    this.title = RootComponentKt().apply(content).build()
}

fun BookKt.author(content: RootComponentKt.() -> Unit) {
    this.author = RootComponentKt().apply(content).build()
}

fun BookKt.page(content: RootComponentKt.() -> Unit) {
    this.pages.add(RootComponentKt().apply(content).build())
}