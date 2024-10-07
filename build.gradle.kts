plugins {
    id("java")
}

allprojects {
    apply(plugin = "java-library")

    group = "de.smoofy.core"
    version = project.version

    repositories {
        mavenCentral()

        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://nexus.velocitypowered.com/repository/maven-public/")
    }

    dependencies {
        implementation("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")

        annotationProcessor("org.projectlombok:lombok:1.18.34")
        compileOnly("org.projectlombok:lombok:1.18.34")
    }

    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        sourceCompatibility = JavaVersion.VERSION_21.toString()
        targetCompatibility = JavaVersion.VERSION_21.toString()
    }
}