plugins {
    id("java")
}

group = "de.smoofy.core"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    implementation("dev.httpmarco.polocloud:api:1.0.11-SNAPSHOT")
}