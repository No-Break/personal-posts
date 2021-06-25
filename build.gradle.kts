import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
    kotlin("jvm") version "1.4.30"
    kotlin("plugin.spring") version "1.4.30"
    kotlin("plugin.jpa") version "1.4.30"
    kotlin("kapt") version "1.5.10"
    jacoco
}

group = "study.nobreak"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.querydsl:querydsl-jpa:4.4.0")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    kapt("com.querydsl:querydsl-apt:4.4.0:jpa")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("mysql:mysql-connector-java")
    annotationProcessor("com.querydsl:querydsl-apt:4.4.0:jpa")
    testImplementation("com.ninja-squad:springmockk:3.0.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "mockito-core")
    }
}

jacoco {
    toolVersion = "0.8.7"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.test {
    finalizedBy("jacocoTestReport")
}

tasks.jacocoTestReport {
    classDirectories.setFrom(
        files(classDirectories.files.map {
            fileTree(mapOf("dir" to it, "exclude" to ('A'..'Z').map { a -> "**/Q$a*" }))
        })
    )
    executionData(fileTree(project.rootDir.absolutePath).include("**/build/jacoco/*.exec"))
    
    reports {
        xml.isEnabled = true
        html.isEnabled = false
        csv.isEnabled = false
        xml.destination = file("${buildDir}/reports/jacoco/report.xml")
    }
}
