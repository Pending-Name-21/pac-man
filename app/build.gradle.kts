plugins {
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"

}

repositories {
    mavenCentral()
    flatDir {
        dirs("local/bridge")
    }
}

dependencies {
    implementation("bridge:bridge-0.0.0-alpha.0.2.0")
    testImplementation("bridge:bridge-0.0.0-alpha.0.2.0")
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testRuntimeOnly("bridge:bridge-0.0.0-alpha.0.2.0")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    mainClass.set("com.pac_man.App")
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "com.pac_man.App"
        )
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
