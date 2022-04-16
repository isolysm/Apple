import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.serialization") version "1.6.20"
    id("org.quiltmc.loom") version "0.12.+"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    `maven-publish`
    // I hate you Groovy, but just this once.
    groovy
    java
}

group = "dev.myosyn"
version = "1.0.0"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.quiltmc.org/repository/release")
    maven("https://maven.quiltmc.org/repository/snapshot")
    maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
}

dependencies {
    minecraft("com.mojang:minecraft:${findProperty("minecraft_version").toString()}")
    mappings("net.fabricmc:yarn:${findProperty("yarn_mappings").toString()}:v2")
    modImplementation("net.fabricmc:fabric-loader:${findProperty("loader_version").toString()}")

    // Kotlin support
    modImplementation("net.fabricmc:fabric-language-kotlin:${findProperty("fabric_kotlin_version").toString()}")

    // Fabric API. This is technically optional, but you probably want it anyway.
    modImplementation("net.fabricmc.fabric-api:fabric-api:${findProperty("fabric_version").toString()}")

    implementation(kotlin("stdlib-jdk8", "1.6.20"))
    implementation(kotlin("stdlib-jdk8", "1.6.20"))
    implementation(kotlin("reflect", "1.6.20"))

}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
}
