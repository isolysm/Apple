import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.serialization") version "1.6.20"
    id("org.quiltmc.loom") version "0.12.+"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.github.juuxel.loom-quiltflower") version "1.6.1"
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
    minecraft("com.mojang:minecraft:1.18.2")

    // Fabric stuff
    mappings("net.fabricmc:yarn:1.18.2+build.1")
    modImplementation("net.fabricmc:fabric-loader:0.13.3")
    modImplementation("net.fabricmc:fabric-language-kotlin:1.7.1+kotlin.1.6.10")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.47.8+1.18.2")
    modImplementation("net.fabricmc.fabric-api:fabric-key-binding-api-v1")

    // UI implementation


    // Other stuff
    // I don't want to force Essential down anyone's throat, so this is here
    include("com.github.LlamaLad7:MixinExtras:0.0.8")


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
            listOf(
                "-opt-in=kotlin.RequiresOptIn"
            )
        }
    }
}

// Don't worry about this for now because I am kinda stupid and don't know how to properly work Jfrog.

publishing {
    publications {
        register<MavenPublication>("ModernUI-${version}") {
            groupId = "dev.myosyn"
            artifactId = "ModernUI-${version}"
        }
        filterIsInstance<MavenPublication>().forEach {publication ->
            publication.pom {
                name.set("ModernMenu")
                description.set("Sleek and clean menu.")
                url.set("https://github.com/isolysm/modernmenu")

                licenses {
                    license {
                        name.set("GNU General Public License (GPL) 3.0")
                        url.set("https://github.com/isolysm/ModernMenu/blob/main/LICENSE")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/isolysm/ModernMenu.git")
                    developerConnection.set("scm:git:https://github.com/isolysm/ModernMenu.git")
                    url.set("https://github.com/isolysm/modernmenu")
                }
            }
        }
    }
    repositories {
        maven {
            setUrl("https://myosyn.jfrog.io/artifactory/modernui-gradle-dev/")

            credentials {
                username = System.getenv("JFROG_USERNAME")
                password = System.getenv("JFROG_PASSWORD")
            }
        }
    }
}