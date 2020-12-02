plugins {
    kotlin("jvm")
    id("com.google.cloud.tools.appengine")
    war
}

group = "me.pashashmigol"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven("https://kotlin.bintray.com/ktor")
}

sourceSets.getByName("main") {
    java.srcDir("../core")
    java.srcDir("src/main/kotlin")
}

dependencies {
//    implementation(project(":core"))
    implementation(kotlin("stdlib"))
    implementation("com.soywiz.korlibs.klock:klock:2.0.0-alpha")
    implementation("io.ktor:ktor-server-servlet:1.4.0")
    implementation("com.google.api-client:google-api-client:1.30.10")
    implementation("com.google.oauth-client:google-oauth-client-jetty:1.23.0")
    implementation("com.google.apis:google-api-services-sheets:v4-rev516-1.23.0")
    implementation("com.google.apis:google-api-services-drive:v3-rev165-1.25.0")
    implementation("com.google.appengine:appengine-api-1.0-sdk:1.9.76")
    implementation("com.google.auth:google-auth-library-oauth2-http:0.20.0")
    implementation("ch.qos.logback:logback-classic:1.2.3")
}

appengine {
    deploy {
        version = "GCLOUD_CONFIG"
        projectId = "GCLOUD_CONFIG"
    }
}
