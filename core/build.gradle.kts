dependencies {
    implementation(libs.adventure.api)
    implementation(libs.adventure.text.minimessage)
    implementation(libs.adventure.text.serializer.gson)
    implementation(libs.adventure.text.serializer.legacy)
    implementation(libs.adventure.text.serializer.plain)
    implementation(libs.adventure.text.serializer.ansi)
}

kotlin {
    jvmToolchain(8)
}