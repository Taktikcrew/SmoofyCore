plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.papermc.paperweight.userdev") version "1.7.3"
}

group = "de.smoofy.core"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()

    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://nexus.velocitypowered.com/repository/maven-public/")
}

dependencies {
    implementation("de.smoofy.core:core-api:1.0-SNAPSHOT")

    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
    paperweight.paperDevBundle("1.21.1-R0.1-SNAPSHOT")

    compileOnly("com.velocitypowered:velocity-api:3.1.1")

    annotationProcessor("org.projectlombok:lombok:1.18.34")
    compileOnly("org.projectlombok:lombok:1.18.34")
}

tasks.shadowJar {
    archiveBaseName.set("Core")
    archiveClassifier.set("")
    manifest {
        attributes["paperweight-mappings-namespace"] = "spigot"
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    sourceCompatibility = JavaVersion.VERSION_21.toString()
    targetCompatibility = JavaVersion.VERSION_21.toString()
}

tasks.assemble {
    dependsOn(tasks.reobfJar)
}