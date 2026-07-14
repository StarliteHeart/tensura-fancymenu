architectury {
    common("fabric", "neoforge")
}

val generatedResources: File = file("src/generated")
sourceSets {
    main {
        resources.srcDir(generatedResources)
    }
}

repositories {
    maven("https://nexus.nighti.dev/repository/manasmods-public/")
}

dependencies {
    // We depend on Fabric Loader here to use the Fabric @Environment annotations,
    // which get remapped to the correct annotations on each platform.
    // Do NOT use other classes from Fabric Loader.
    modImplementation("net.fabricmc:fabric-loader:${rootProject.property("fabric_loader_version")}")
    modImplementation("dev.architectury:architectury:${rootProject.property("architectury_api_version")}")

    modImplementation(files("libs/manascore-attribute-fabric-${rootProject.property("manascore_version")}.jar"))
    modImplementation(files("libs/manascore-command-fabric-${rootProject.property("manascore_version")}.jar"))
    modImplementation(files("libs/manascore-config-fabric-${rootProject.property("manascore_version")}.jar"))
    modImplementation(files("libs/manascore-inventory-fabric-${rootProject.property("manascore_version")}.jar"))
    modImplementation(files("libs/manascore-keybind-fabric-${rootProject.property("manascore_version")}.jar"))
    modImplementation(files("libs/manascore-network-fabric-${rootProject.property("manascore_version")}.jar"))
    modImplementation(files("libs/manascore-race-fabric-${rootProject.property("manascore_version")}.jar"))
    modImplementation(files("libs/manascore-skill-fabric-${rootProject.property("manascore_version")}.jar"))
    modImplementation(files("libs/manascore-storage-fabric-${rootProject.property("manascore_version")}.jar"))

    modImplementation("maven.modrinth:tensura-reincarnated:${rootProject.property("tensura_version")}-1.21.1,common")
    modImplementation("maven.modrinth:fancymenu:${rootProject.property("fancymenu_version")}-1.21.1-fabric")
}
