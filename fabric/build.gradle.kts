plugins {
    id("com.github.johnrengelman.shadow")
}

architectury {
    platformSetupLoomIde()
    fabric()
}

loom {
    enableTransitiveAccessWideners.set(true)
}

val shadowBundle = configurations.create("shadowBundle")

repositories {

}

dependencies {
    modImplementation("net.fabricmc:fabric-loader:${rootProject.property("fabric_loader_version")}")

    implementation(project(":common", configuration = "namedElements"))
    "developmentFabric"(project(":common", configuration = "namedElements")) { isTransitive = false }
    shadowBundle(project(":common", configuration = "transformProductionFabric"))

    modImplementation("io.github.manasmods:manascore-attribute-fabric:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-command-fabric:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-config-fabric:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-inventory-fabric:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-keybind-fabric:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-network-fabric:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-race-fabric:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-skill-fabric:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-storage-fabric:${rootProject.property("manascore_version")}")

    modImplementation("local.io.github.manasmods:tensura-fabric:${rootProject.property("tensura_version")}")

    modImplementation("local.de.keksuccino:fancymenu-fabric:${rootProject.property("fancymenu_version")}")
}

tasks {
    processResources {
        inputs.property("mod_version", project.version)
        inputs.property("minecraft_version", rootProject.property("minecraft_version"))
        inputs.property("java_version", rootProject.property("java_version"))
        inputs.property("fabric_loader_version", rootProject.property("fabric_loader_version"))

        filesMatching("fabric.mod.json") {
            expand(project.properties)
        }
    }

    jar {
        archiveClassifier.set("dev-slim")
    }

    shadowJar {
        configurations = listOf(shadowBundle)
        archiveClassifier.set("dev-shadow")
    }

    remapJar {
        dependsOn(shadowJar)
        inputFile.set(shadowJar.flatMap { it.archiveFile })
    }
}
