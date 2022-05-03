includeBuild("build-logic")

pluginManagement {
    repositories {
        maven("https://jitpack.io")
        maven("https://maven.fabricmc.net")
        maven("https://maven.quiltmc.org/repository/release")
        maven("https://maven.quiltmc.org/repository/snapshot")
        maven("https://maven.minecraftforge.net")
        maven("https://maven.architectury.dev/)
        maven("https://server.bbkr.space/artifactory/libs-release/")
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                 "com.replaymod.preprocess" -> {
                        useModule("com.github.replaymod:preprocessor:${requested.version}")
                }
            }
        }
    }
}

rootProject.buildFileName = "root.gradle.kts"

// All of the versions are to have their different directories
// Both Forge and Fabric will use Essential's loom
// Quilt will use architectury loom

val appleForgeVersions = listOf (
    "1.8.9-forge",
    "1.12.2-forge"
)

appleForgeVersions.forEach { version ->
    include(":$forge")
    project(":$forge").apply {
        projectDir = file("forge")
        buildFileName = "../forge/build.gradle.kts"
    }
}

val appleFabricVersions = listOf (
    "1.16.5-fabric",
    "1.17.1-fabric",
    "1.18.1-fabric",
    "1.18.2-fabric"
)

appleFabricVersions.forEach { version ->
    include(":$fabric")
    project(":$fabric") {
        projectDir = file("quilt")
        buildFileName = "../fabric/build.gradle.kts"
    }

}

val appleQuiltVersions = listOf(
    "1.18.1-quilt",
    "1.18.2-quilt"
)

appleQuiltVersions.forEach { version ->
    include(":$quilt")
    project(":$quilt").apply {
        projectDir = file("quilt")
        buildFileName = "../quilt/build.gradle.kts"
    }

}
/*
gradle.settingsEvaluated{
    if (!JavaVersion.current().isCompatibleWith(JavaVersion.VERSION_17)) {
        throw GradleException("This build requires JDK 17. You're currently using ${getJavaVersion()}. Please make sure you're on the correct version, and try again.")
    }
}

fun getJavaVersion() {
    System.getProperty("java.home")
}

*/