package ink.pmc.advkt.component

fun insertion(): InsertionWithoutKt {
    return InsertionWithoutKt()
}

fun insertion(value: String): InsertionKt {
    return InsertionKt(value)
}