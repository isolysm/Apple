plugins {
    kotlin("jvm") version "1.6.21" apply false
    kotlin("plugin.serialization") version "1.6.21" apply false
    id("com.replaymod.preprocess") version "73d8bed"
}

preprocess {
    // Apparently qm is the official mapping for quilt, but if it breaks, I can substitute it for yarn
    // You also cannot preprocess from 1.8.9 to 1.18.2 in like 2 seconds so great.
    val quilt11802 = createNode("1.18.2-quilt", 11802, "qm")
    val quilt11801 = createNode("1.18.1-quilt", 11801, "qm")

    val fabric11802 = createNode("1.18.2-fabric", 11802, "yarn")
    val fabric11801 = createNode("1.18.1-fabric", 11801, "yarn")
    val fabric11701 = createNode("1.17.1-fabric", 11701, "yarn")

    // val forge11202 = createNode("1.12.2-forge", 11202, "srg")
    // val forge10809 = createNode("1.8.9-forge", 10809, "srg")

    quilt11802.link(quilt11801)
    fabric11801.link(fabric11802)
    // forge10809.link(forge10809)
}