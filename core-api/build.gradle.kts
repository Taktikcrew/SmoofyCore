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
            url = uri("https://maven.pkg.github.com/smoofy19/SmoofyCore")
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
    }
}

java {
    withSourcesJar()
    withJavadocJar()
}