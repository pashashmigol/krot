plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    id("com.google.gms.google-services")
}
group = "me.pashashmigol"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
dependencies {
    implementation(project(":client"))
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
    implementation("com.google.firebase:firebase-analytics:18.0.0")
    implementation("com.google.firebase:firebase-messaging:21.0.1")
}
android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "me.pashashmigol.androidApp"
        minSdkVersion(28)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding = true
    }

    flavorDimensions("version")
    productFlavors {
        create("remote") {
            dimension = "version"
            buildConfigField(
                "String",
                "ENDPOINT",
                "\"https://bored-passenger-290806.oa.r.appspot.com\""
            )
        }
        create("local") {
            dimension = "version"
            buildConfigField(
                "String",
                "ENDPOINT",
                "\"http://10.0.2.2:8080\""
            )
        }
    }
}