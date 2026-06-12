pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net/")
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "tensura_fancymenu"

listOf(
    "common",
    "fabric",
    "neoforge"
).forEach { include(it) }
