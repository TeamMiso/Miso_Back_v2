object Dependencies {

    // spring
    const val SPRING_JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
    const val SPRING_REDIS = "org.springframework.boot:spring-boot-starter-data-redis"
    const val MAIL = "org.springframework.boot:spring-boot-starter-mail"
    const val SECURITY = "org.springframework.boot:spring-boot-starter-security"
    const val VALIDATION = "org.springframework.boot:spring-boot-starter-validation"
    const val WEB = "org.springframework.boot:spring-boot-starter-web"
    const val SPRING_CLOUD = "org.springframework.cloud:spring-cloud-starter-aws:${DependencyVersions.SPRING_CLOUD_VERSION}"


    // kotlin
    const val KOTLIN_JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin"
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect"

    // db
    const val MARIA_DATABASE = "org.mariadb.jdbc:mariadb-java-client:${DependencyVersions.MARIA_DATABASE_VERSION}"

    // test
    const val SPRING_TEST = "org.springframework.boot:spring-boot-starter-test"

    // jwt
    const val JWT_API = "io.jsonwebtoken:jjwt-api:${DependencyVersions.JWT_API_VERSION}"
    const val JWT_IMPL = "io.jsonwebtoken:jjwt-impl:${DependencyVersions.JWT_IMPL_VERSION}"
    const val JWT_JACKSON = "io.jsonwebtoken:jjwt-jackson:${DependencyVersions.JWT_JACKSON_VERSION}"

    // querydsl
    const val QUERY_DSL = "com.querydsl:querydsl-jpa:${DependencyVersions.QUERY_DSL_VERSION}"
    const val QUERY_DSL_APT = "com.querydsl:querydsl-apt:${DependencyVersions.QUERY_DSL_APT_VERSION}:jpa"

    // web_hook
    const val OK_HTTP = "com.squareup.okhttp3:okhttp:${DependencyVersions.OK_HTTP_VERSION}"

    // fcm
    const val FCM = "com.google.firebase:firebase-admin:${DependencyVersions.FCM_VERSION}"
}