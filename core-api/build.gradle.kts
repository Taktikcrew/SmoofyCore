plugins {
    id("maven-publish")
}

dependencies {
    compileOnly("com.velocitypowered:velocity-api:3.1.1")

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