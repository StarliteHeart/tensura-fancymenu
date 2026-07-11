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

    runtimeOnly(files("libs/geckolib-fabric-${rootProject.property("geckolib_version")}.jar"))
    runtimeOnly(files("libs/smartbrainlib-fabric-${rootProject.property("smartbrainlib_version")}.jar"))
    runtimeOnly(files("libs/terrablender-fabric-${rootProject.property("terrablender_version")}.jar"))
    runtimeOnly(files("libs/manascore-fabric-${rootProject.property("manascore_version")}.jar"))

    runtimeOnly(files("libs/konkrete-fabric-${rootProject.property("konkrete_version")}.jar"))
    runtimeOnly(files("libs/melody-fabric-${rootProject.property("melody_version")}.jar"))

    implementation(files("libs/tensura-fabric-${rootProject.property("tensura_version")}.jar"))
    implementation(files("libs/fancymenu-fabric-${rootProject.property("fancymenu_version")}.jar"))
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
