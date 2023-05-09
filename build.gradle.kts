plugins {
    id("org.springframework.boot") version ("2.6.3")
    id("io.spring.dependency-management") version ("1.0.11.RELEASE")
    `java-library`
}


group = "org.space"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

object Versions {
    const val springCloudVersion = "2021.0.3"
    const val swaggerVersion = "2.9.2"
    const val guavaVersion = "31.0.1-jre"
}

dependencies {
    implementation("org.springframework.boot", "spring-boot-starter-web")
    implementation("org.springframework.cloud", "spring-cloud-starter-openfeign")
    implementation("com.google.guava", "guava", Versions.guavaVersion)

    implementation ("org.springframework.boot", "spring-boot-starter-web")
    implementation ("org.springframework.boot", "spring-boot-starter-validation")
    implementation ("org.hibernate.validator","hibernate-validator")

    implementation ("javax.validation", "validation-api", "2.0.1.Final")

    compileOnly("org.projectlombok", "lombok")

    annotationProcessor("org.projectlombok", "lombok")

    testImplementation("org.springframework.boot", "spring-boot-starter-test")

    implementation("io.springfox", "springfox-swagger2", Versions.swaggerVersion)
    implementation("io.springfox", "springfox-swagger-ui", Versions.swaggerVersion)
}

dependencyManagement {
    imports {
        mavenBom ("org.springframework.cloud:spring-cloud-dependencies:${Versions.springCloudVersion}")
    }
}

tasks.test {
    useJUnitPlatform()
}
