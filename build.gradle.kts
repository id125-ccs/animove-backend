plugins {
    kotlin("jvm") version "2.3.10"
}

group = "ph.edu.dlsu.animove"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(24)
}

tasks.test {
    useJUnitPlatform()
}