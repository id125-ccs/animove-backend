import org.gradle.api.tasks.testing.Test

plugins {
    id("io.kotest") version "6.1.11"
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:6.1.11")
    testImplementation("io.kotest:kotest-assertions-core:6.1.11")
    testImplementation("io.kotest:kotest-property:6.1.11")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()

    testLogging {
        events("passed", "skipped", "failed")

        showStandardStreams = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}