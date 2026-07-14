import net.fabricmc.loom.api.LoomGradleExtensionAPI

plugins {
    kotlin("jvm") version ("2.2.20")
    id("dev.architectury.loom") version ("1.14-SNAPSHOT") apply false
    id("architectury-plugin") version ("3.4-SNAPSHOT")
    id("com.github.johnrengelman.shadow") version ("8.1.1") apply false
}

architectury {
    minecraft = "${rootProject.property("minecraft_version")}"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "architectury-plugin")

    group = "${rootProject.property("maven_group")}"
    version = "${rootProject.property("minecraft_version")}-${rootProject.property("mod_version")}"
}

subprojects {
    apply(plugin = "dev.architectury.loom")

    base {
        // Set up a suffixed format for the mod jar names, e.g. `example-fabric`.
        archivesName = "${rootProject.property("mod_id")}-${project.name}"
    }

    repositories {
        // Add repositories to retrieve artifacts from in here.
        // You should only use this when depending on other mods because
        // Loom adds the essential maven repositories to download Minecraft and libraries from automatically.
        // See https://docs.gradle.org/current/userguide/declaring_repositories.html
        // for more information about repositories.

        mavenCentral()
        maven("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
        maven("https://dl.cloudsmith.io/public/tslat/sbl/maven/")
        maven("https://maven.impactdev.net/repository/development/")
        maven("https://api.modrinth.com/maven")
        mavenLocal()
    }

    val loom = project.extensions.getByName<LoomGradleExtensionAPI>("loom")

    dependencies {
        "minecraft"("net.minecraft:minecraft:${rootProject.property("minecraft_version")}")
        "mappings"(loom.officialMojangMappings())
    }

    java {
        // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
        // if it is present.
        // If you remove this line, sources will not be generated.
        withSourcesJar()

        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks.withType(JavaCompile::class).configureEach {
        options.release = 21
    }
}
