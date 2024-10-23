# Smoofy Core

This is a useful core that will simplify your coding experience with paper, velocity, ...

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Documentation & Examples](#documentation--examples)
- [Contributing](#contributing)
- [License](#license)

## Installation
1. Download the latest version of the Core from the [releases](https://github.com/Smoofy19/Core/releases).
2. Place the `.jar` file in the `plugins` folder of your server.
3. Restart your server.
4. You are able to use the API now.

## Usage
To use the API in your plugin, add the following line to your `plugin.yml` file:
```yaml
depend: [Core]
```

You also have to add the dependency to your project. You can do this by adding the following to your 
`build.gradle.kts`, `build.gradle` or `pom.xml` file:

### Repository
#### Gradle Kotlin DSL
```kotlin
maven("https://maven.pkg.github.com/Smoofy19/Core")
```
#### Gradle Groovy
```groovy
maven { url 'https://maven.pkg.github.com/Smoofy19/Core' }
```
#### Maven
```xml
<repository>
   <id>smoofycore</id>
   <url>https://maven.pkg.github.com/Smoofy19/Core</url>
</repository>
```

### Dependency
#### Gradle Kotlin DSL
```kotlin
compileOnly("de.smoofy.core:core-api:VERSION")
```
#### Gradle Groovy
```groovy
compileOnly("de.smoofy.core:core-api:VERSION")
```
#### Maven
```xml
<dependency>
  <groupId>de.smoofy.core</groupId>
  <artifactId>core-api</artifactId>
  <version>VERSION</version>
</dependency>
```

## Documentation & Examples
For examples on how to use the API, please refer to the [examples](https://github.com/Smoofy19/Core/core-example).

## Contributing
Contributions are welcome! If you have suggestions or found any issues, please open an issue or create a pull request.

## License
This project is licensed under the [Apache-2.0 license](https://github.com/Smoofy19/Core/blob/master/LICENSE).