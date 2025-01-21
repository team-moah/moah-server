plugins {
    kotlin("jvm") version PluginVersions.JVM_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGEMENT_VERSION
    id("org.jlleitschuh.gradle.ktlint") version PluginVersions.KTLINT_VERSION
}

group = "team.moah"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring
    implementation(Dependencies.SPRING_WEB)
    testImplementation(Dependencies.SPRING_TEST)
    implementation(Dependencies.SPRING_VALIDATION)
    implementation(Dependencies.ACTUATOR)
    // Kotlin
    implementation(Dependencies.KOTLIN_REFLECT)
    testImplementation(Dependencies.KOTLIN_TEST_JUNIT5)
    testRuntimeOnly(Dependencies.JUNIT_PLATFORM_LAUNCHER)
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
