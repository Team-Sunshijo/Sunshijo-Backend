plugins {
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.7.22"
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("mysql:mysql-connector-java")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    annotationProcessor ("org.springframework.boot:spring-boot-configuration-processor")

    //UUID time based
    implementation("com.fasterxml.uuid:java-uuid-generator:3.1.4")

    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("org.springframework.boot:spring-boot-starter-security")

    annotationProcessor ("org.springframework.boot:spring-boot-configuration-processor")

    implementation ("org.mapstruct:mapstruct:1.5.2.Final")
    annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.2.Final")

    implementation("org.springframework.boot:spring-boot-starter-data-redis")

//    implementation("com.querydsl:querydsl-jpa:5.0.0")
//    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")

    implementation(project(":sunshijo-application"))
}
repositories {
    mavenCentral()
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.getByName<Jar>("jar") {
    enabled = false
}