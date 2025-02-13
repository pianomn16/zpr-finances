import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.1.8.RELEASE"
  id("io.spring.dependency-management") version "1.0.8.RELEASE"
  id("org.flywaydb.flyway")  version "5.0.3"
  kotlin("jvm") version "1.2.71"
  kotlin("plugin.spring") version "1.2.71"
  kotlin("plugin.jpa") version "1.2.71"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8
repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-data-rest")
  implementation("org.flywaydb:flyway-core")
  runtime("org.postgresql:postgresql")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "1.8"
  }
}

flyway {
  url = "jdbc:postgresql://localhost:5432/zprfinances"
  user = "user"
  password = "123456"
  outOfOrder = true
}