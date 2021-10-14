plugins {
    val kotlinVersion = "1.5.31"
    kotlin("multiplatform") version kotlinVersion apply false
    kotlin("jvm") version kotlinVersion apply false
}

group = "org.example"
version = "1.0-SNAPSHOT"