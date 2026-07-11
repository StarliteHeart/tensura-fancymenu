plugins {
    id("com.github.johnrengelman.shadow")
}

architectury {
    platformSetupLoomIde()
    neoForge()
}

val generatedResources: File = file("../common/src/generated")
val defaultResources: File = file("../common/src/main/resources")
loom {
    enableTransitiveAccessWideners.set(true)
    runs {
        register("data") {
            data()
            programArgs("--all", "--mod", "tensura_fancymenu")
            programArgs("--output", generatedResources.absolutePath, "--existing", defaultResources.absolutePath)
        }
    }
}

val shadowBundle = configurations.create("shadowBundle")

repositories {
    maven("https://maven.neoforged.net/releases")
}

dependencies {
    neoForge("net.neoforged:neoforge:${rootProject.property("neoforge_version")}")
    modImplementation("dev.architectury:architectury-neoforge:${rootProject.property("architectury_api_version")}")

    implementation(project(":common", configuration = "namedElements"))
    "developmentNeoForge"(project(":common", configuration = "namedElements")) { isTransitive = false }
    shadowBundle(project(":common", configuration = "transformProductionNeoForge"))

    runtimeOnly(files("libs/geckolib-neoforge-${rootProject.property("geckolib_version")}.jar"))
    runtimeOnly(files("libs/smartbrainlib-neoforge-${rootProject.property("smartbrainlib_version")}.jar"))
    runtimeOnly(files("libs/terrablender-neoforge-${rootProject.property("terrablender_version")}.jar"))
    runtimeOnly(files("libs/manascore-neoforge-${rootProject.property("manascore_version")}.jar"))

    runtimeOnly(files("libs/konkrete-neoforge-${rootProject.property("konkrete_version")}.jar"))
    runtimeOnly(files("libs/melody-neoforge-${rootProject.property("melody_version")}.jar"))

    implementation(files("libs/tensura-neoforge-${rootProject.property("tensura_version")}.jar"))
    implementation(files("libs/fancymenu-neoforge-${rootProject.property("fancymenu_version")}.jar"))
}

tasks {
    processResources {
        inputs.property("mod_id", rootProject.property("mod_id"))
        inputs.property("mod_version", project.version)
        inputs.property("minecraft_version", rootProject.property("minecraft_version"))
        inputs.property("java_version", rootProject.property("java_version"))
        inputs.property("tensura_version", rootProject.property("tensura_version"))
        inputs.property("fancymenu_version", rootProject.property("fancymenu_version"))

        filesMatching("META-INF/neoforge.mods.toml") {
            expand(project.properties)
        }
    }

    jar {
        archiveClassifier.set("dev-slim")
    }

    shadowJar {
        archiveClassifier.set("dev-shadow")
        configurations = listOf(shadowBundle)
    }

    remapJar {
        dependsOn(shadowJar)
        inputFile.set(shadowJar.flatMap { it.archiveFile })
    }
}
