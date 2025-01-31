plugins {
    java
    `java-library`
    `maven-publish`
    id("org.springframework.boot") version "3.4.2"
}

group = "io.github.meiiraru"
version = "1.0.0"

//dependencies versions
val cinnamonVersion = "0.0.1"

repositories {
    mavenCentral()
    //mavenLocal()
    maven("https://jitpack.io")
}

dependencies {
    implementation("io.github.meiiraru", "Cinnamon", cinnamonVersion)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = project.group as String
            artifactId = project.name
            version = project.version as String
            from(components["java"])
        }
    }
}

tasks.bootJar {
    from("LICENSE.md")
}