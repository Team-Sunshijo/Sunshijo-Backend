plugins {
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("plugin.spring") version "1.7.22"
}

dependencies {

}

tasks.getByName<Jar>("bootJar") {
    enabled = false
}