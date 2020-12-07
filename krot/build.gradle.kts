import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.4.10"
    id("com.android.library")
    id("kotlin-android-extensions")
}
group = "me.pashashmigol"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
    maven(url = "http://dl.bintray.com/kotlin/kotlin-eap")
    maven(url = "https://kotlin.bintray.com/kotlin-dev")
    maven(url = "https://plugins.gradle.org/m2/")
    maven(url = "https://dl.bintray.com/kotlin/kotlinx")
    maven(url = "https://dl.bintray.com/kotlin/ktor")
    maven(url = "https://kotlin.bintray.com/kotlinx")
    gradlePluginPortal()
}

kotlin {
    android()
    iosX64("ios") {
        binaries {
            framework {
                baseName = "krot"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            sourceSets.getByName("commonMain") {
                kotlin.srcDir("../core")
                kotlin.srcDir("src/main/kotlin")
            }
            dependencies {
                implementation("com.soywiz.korlibs.klock:klock:2.0.0-alpha")
                implementation("io.ktor:ktor-client-core:1.4.3")
                implementation("io.ktor:ktor-client-serialization:1.4.3")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")

                implementation("io.ktor:ktor-client-logging:1.4.3")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.core:core-ktx:1.3.2")
                implementation("io.ktor:ktor-client-android:1.4.3")

            }
        }
        val androidTest by getting
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.4.0")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:0.20.0-1.4-M1-release-99")
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val framework = kotlin.targets
        .getByName<KotlinNativeTarget>("ios")
        .binaries.getFramework(mode)

    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)