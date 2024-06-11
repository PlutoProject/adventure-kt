package ink.pmc.advkt.title

import ink.pmc.advkt.component.RootComponentKt
import net.kyori.adventure.text.Component
import net.kyori.adventure.title.Title
import net.kyori.adventure.title.Title.Times

interface TitleKt {

    fun build(): Title

}

class ComponentTitleKt : TitleKt {

    internal var mainTitle: Component = Component.empty()
    internal var subTitle: Component = Component.empty()
    internal var times: Times? = null

    override fun build(): Title {
        return Title.title(mainTitle, subTitle, times)
    }

}

fun title(content: ComponentTitleKt.() -> Unit): Title {
    return ComponentTitleKt().apply(content).build()
}

fun ComponentTitleKt.mainTitle(component: Component) {
    mainTitle = component
}

fun ComponentTitleKt.mainTitle(content: RootComponentKt.() -> Unit) {
    mainTitle(RootComponentKt().apply(content).build())
}

fun ComponentTitleKt.subTitle(component: Component) {
    subTitle = component
}

fun ComponentTitleKt.subTitle(content: RootComponentKt.() -> Unit) {
    subTitle(RootComponentKt().apply(content).build())
}

fun ComponentTitleKt.times(times: Times) {
    this.times = times
}

fun ComponentTitleKt.times(content: TitleTimesKt.() -> Unit) {
    times(TitleTimesKt().apply(content).build())
}