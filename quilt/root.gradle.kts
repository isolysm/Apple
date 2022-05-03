// Each directory requires its own root.gradle.kts specifically for preprocessor.

plugins {
    kotlin("jvm") apply false
    kotlin("plugin.serialization") apply false
    id("com.replaymod.preprocessor") 
    id("dev.architectury.loom") version "0.11-SNAPSHOT" apply false
}

configurations.register("compileClasspath")
