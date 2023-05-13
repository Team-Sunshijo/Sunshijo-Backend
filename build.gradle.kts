import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.22"
}

subprojects{
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        version = "1.7.22"
    }

    apply {
        plugin("org.jetbrains.kotlin.kapt")
        version = "1.6.10"
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")

        //TEST
        testImplementation("io.kotest:kotest-runner-junit5-jvm:5.4.0")
        testImplementation("io.kotest:kotest-assertions-core-jvm:5.4.0")
        testImplementation("io.mockk:mockk:1.13.2")
    }
}

allprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"
    java.sourceCompatibility = JavaVersion.VERSION_17

    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}