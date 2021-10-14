plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
}

kotlin {

    jvm {
        val main by compilations.getting {
            withJava()
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }
}