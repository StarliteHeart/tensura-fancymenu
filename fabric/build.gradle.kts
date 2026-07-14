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

dependencies {
    modImplementation("net.fabricmc:fabric-loader:${rootProject.property("fabric_loader_version")}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${rootProject.property("fabric_api_version")}")
    modImplementation("dev.architectury:architectury-fabric:${rootProject.property("architectury_api_version")}")

    implementation(project(":common", configuration = "namedElements"))
    "developmentFabric"(project(":common", configuration = "namedElements")) { isTransitive = false }
    shadowBundle(project(":common", configuration = "transformProductionFabric"))

    modRuntimeOnly("maven.modrinth:geckolib:${rootProject.property("geckolib_version")}-1.21.1,fabric")
    modRuntimeOnly("maven.modrinth:smartbrainlib:${rootProject.property("smartbrainlib_version")}-1.21.1,fabric")
    modRuntimeOnly("maven.modrinth:terrablender:${rootProject.property("terrablender_version")}-1.21.1,fabric")

    modRuntimeOnly("maven.modrinth:konkrete:${rootProject.property("konkrete_version")}-1.21-fabric")
    modRuntimeOnly("maven.modrinth:melody:${rootProject.property("melody_version")}-1.21-fabric")

    modRuntimeOnly("maven.modrinth:manascore:${rootProject.property("manascore_version")}-1.21.1,fabric")

    modImplementation("maven.modrinth:tensura-reincarnated:${rootProject.property("tensura_version")}-1.21.1,fabric")
    modImplementation("maven.modrinth:fancymenu:${rootProject.property("fancymenu_version")}-1.21.1-fabric")
}

tasks {
    processResources {
        inputs.property("mod_version", project.version)
        inputs.property("minecraft_version", rootProject.property("minecraft_version"))
        inputs.property("java_version", rootProject.property("java_version"))
        inputs.property("fabric_loader_version", rootProject.property("fabric_loader_version"))
        inputs.property("tensura_version", rootProject.property("tensura_version"))
        inputs.property("fancymenu_version", rootProject.property("fancymenu_version"))

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
