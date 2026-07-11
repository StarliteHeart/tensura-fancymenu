architectury {
    common("fabric", "neoforge")
}

val generatedResources: File = file("src/generated")
sourceSets {
    main {
        resources.srcDir(generatedResources)
    }
}

dependencies {
    // We depend on Fabric Loader here to use the Fabric @Environment annotations,
    // which get remapped to the correct annotations on each platform.
    // Do NOT use other classes from Fabric Loader.
    modImplementation("net.fabricmc:fabric-loader:${rootProject.property("fabric_loader_version")}")
    modImplementation("dev.architectury:architectury:${rootProject.property("architectury_api_version")}")

    modImplementation("io.github.manasmods:manascore-attribute-common:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-command-common:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-config-common:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-inventory-common:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-keybind-common:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-network-common:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-race-common:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-skill-common:${rootProject.property("manascore_version")}")
    modImplementation("io.github.manasmods:manascore-storage-common:${rootProject.property("manascore_version")}")

    modImplementation(files("libs/tensura-common-${rootProject.property("tensura_version")}.jar"))
    modImplementation(files("libs/fancymenu-common-${rootProject.property("fancymenu_version")}.jar"))

    modImplementation(files("libs/iris-neoforge-${rootProject.property("iris_version")}.jar"))
}
