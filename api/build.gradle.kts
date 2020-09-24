plugins {
    kotlin("jvm")

    // https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc
    id("org.openapi.generator") version "4.3.1"
    id("kotlinx-serialization")
}

val kotlinVersion: String by rootProject.extra
val kotlinxSerializationRuntime: String by rootProject.extra
val retrofitVersion: String by rootProject.extra

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$kotlinxSerializationRuntime")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
}

// API名称（複数指定可能、パッケージ名に使われるので小文字で）
// val apiList = listOf("sp")
val apiName = "sp"

// 自動生成先のパッケージ名
val basePackage = "cc.cointrade.app.api"

task<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>("generate") {
    doFirst {
        delete(file("$buildDir/openApiGeneratorForModel/$apiName"))
    }

    generatorName.set("kotlin")
    inputSpec.set("$rootDir/swagger.yaml")
    outputDir.set("$buildDir/openApiGeneratorForModel/$apiName/")
    // outputDir.set("$rootDir/api/src/main/java")
    apiPackage.set("$basePackage.$apiName.api")
    packageName.set(basePackage)
    // invokerPackage.set("$basePackage.$apiName.invoker")
    modelPackage.set("$basePackage.$apiName.model")
    // modelFilesConstrainedTo.set(
    //     listOf(
    //         "Error"
    //     )
    // )
    configOptions.set(
        mapOf(
            "dateLibrary" to "java8"
        )
    )
    generateApiTests.set(false)
}
