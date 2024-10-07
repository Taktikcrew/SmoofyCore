plugins {
    id("java")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "de.smoofy.core"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://nexus.velocitypowered.com/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
    compileOnly("com.velocitypowered:velocity-api:3.1.1")

    annotationProcessor("org.projectlombok:lombok:1.18.34")
    compileOnly("org.projectlombok:lombok:1.18.34")

    compileOnly("org.fusesource.jansi:jansi:2.4.0")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Smoofy19/Core")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks {
    shadowJar {
        archiveClassifier.set("")
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    sourceCompatibility = JavaVersion.VERSION_21.toString()
    targetCompatibility = JavaVersion.VERSION_21.toString()
}