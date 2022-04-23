pluginManagement {
    repositories {
        maven("https://jitpack.io")
        maven("https://maven.fabricmc.net")
        maven("https://maven.quiltmc.org/repository/release")
        maven("https://maven.quiltmc.org/repository/snapshot")
        maven("https://server.bbkr.space/artifactory/libs-release/")
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.dokka" -> {
                    useModule("org.jetbrains.dokka:dokka-gradle-plugin:${requested.version}")
                }
            }
            when (requested.id.id) {
                 "com.replaymod.preprocess" -> {
                        useModule("com.github.replaymod:preprocessor:${requested.version}")
                 }
            }
        }
    }
}

rootProject.name = "ModernMenu"
rootProject.buildFileName = "root.gradle.kts"

// For preprocessor
val appleVersion = listOf(

    // Forge (Legacy)
    "1.8.9-forge",
    "1.12.2-forge",

    // Fabric
    "1.17.1-fabric",
    "1.18.1-fabric",
    "1.18.2-fabric",

    // Quilt
    "1.18.1-quilt",
    "1.18.2-quilt"
)

appleVersion.forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../../build.gradle"
    }
}

gradle.settingsEvaluated{
    if (!JavaVersion.current().isCompatibleWith(JavaVersion.VERSION_17)) {
        throw GradleException("This build requires JDK 17. You're currently using ${getJavaVersion()}. Please make sure you're on the correct version, and try again.")
    }
}

fun getJavaVersion() {
    System.getProperty("java.home")
}

