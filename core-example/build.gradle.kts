plugins {
    id("java")
}

group = "de.smoofy.core"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("de.smoofy.core:core-api:1.0-SNAPSHOT")
}