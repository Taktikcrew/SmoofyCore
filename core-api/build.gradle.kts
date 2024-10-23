plugins {
    id("maven-publish")
}

dependencies {
    compileOnly(libs.velocity)

    compileOnly(libs.jansi)
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