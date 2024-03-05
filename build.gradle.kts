import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
	id("io.spring.dependency-management") version PluginVersions.SPRING_MANAGE_VERSION
	id("com.ewerk.gradle.plugins.querydsl") version PluginVersions.QUERY_DSL_PLUGIN_VERSION

	kotlin("jvm") version PluginVersions.JVM_VERSION
	kotlin("plugin.spring") version PluginVersions.SPRING_PLUG_IN_VERSION
	kotlin("plugin.jpa") version PluginVersions.JPA_VERSION
	kotlin("kapt") version PluginVersions.KAPT_VERSION
	idea
}

group = "andreas311"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
	mavenCentral()
}

dependencies {

	// kotlin
	implementation(Dependencies.KOTLIN_JACKSON)
	implementation(Dependencies.KOTLIN_REFLECT)

	// web
	implementation(Dependencies.WEB)
	implementation(Dependencies.VALIDATION)

	// db
	implementation(Dependencies.SPRING_JPA)
	runtimeOnly(Dependencies.MARIA_DATABASE)

	// security
	implementation(Dependencies.SECURITY)

	// jjwt
	implementation(Dependencies.JWT_API)
	runtimeOnly(Dependencies.JWT_IMPL)
	runtimeOnly(Dependencies.JWT_JACKSON)

	// redis
	implementation(Dependencies.SPRING_REDIS)

	// mail
	implementation(Dependencies.MAIL)

	// s3
	implementation(Dependencies.SPRING_CLOUD)

	// test
	testImplementation(Dependencies.SPRING_TEST)

	// query_dsl
	implementation(Dependencies.QUERY_DSL)
	implementation(Dependencies.QUERY_DSL_APT)
	kapt(Dependencies.QUERY_DSL_APT)

	// web_hook
	implementation(Dependencies.OK_HTTP)

	// fcm
	implementation(Dependencies.FCM)
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

// query_dsl
idea {
	module {
		val kaptMain = file("build/generated/source/kapt/main")
		sourceDirs.add(kaptMain)
		generatedSourceDirs.add(kaptMain)
	}
}