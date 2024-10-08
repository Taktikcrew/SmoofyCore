import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("net.minecrell.plugin-yml.paper") version "0.6.0"
    id("io.papermc.paperweight.userdev") version "1.7.3"
}

repositories {
    maven("https://repo.codemc.io/repository/maven-releases/")
    maven("https://maven.evokegames.gg/snapshots")

    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation(project(":core-api"))

    paperweight.paperDevBundle("1.21.1-R0.1-SNAPSHOT")

    compileOnly("com.velocitypowered:velocity-api:3.1.1")

    implementation("com.github.retrooper:packetevents-spigot:2.5.0")
    implementation("me.tofaa.entitylib:spigot:2.4.10-SNAPSHOT")

    implementation("dev.httpmarco.evelon:evelon-sql-mariadb:1.0.46-SNAPSHOT")
}

tasks.shadowJar {
    archiveBaseName.set("Core")
    archiveClassifier.set("")
    manifest {
        attributes["paperweight-mappings-namespace"] = "spigot"
    }
}

tasks.assemble {
    dependsOn(tasks.reobfJar)
}

paper {
    name = "Core"
    version = project.version.toString()
    author = "Smoofy"
    apiVersion = "1.21"
    main = "de.smoofy.core.base.bootstrap.PaperBootstrap"

    load = BukkitPluginDescription.PluginLoadOrder.POSTWORLD
}