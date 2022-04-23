plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.fabricmc.net/")
    maven("https://maven.minecraftforge.net")
    maven("https://jitpack.io")
    maven("https://server.bbkr.space/artifactory/libs-release/")
    maven("https://maven.quiltmc.org/repository/release")
    maven("https://maven.quiltmc.org/repository/snapshot")
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())
}
