plugins {
    id("java")
}

group = "de.smoofy.core"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()

    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("de.smoofy.core:core-api:1.0-SNAPSHOT")

    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")

    annotationProcessor("org.projectlombok:lombok:1.18.34")
    compileOnly("org.projectlombok:lombok:1.18.34")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    sourceCompatibility = JavaVersion.VERSION_21.toString()
    targetCompatibility = JavaVersion.VERSION_21.toString()
}