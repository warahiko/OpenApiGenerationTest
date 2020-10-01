plugins {
    kotlin("jvm")

    // https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc
    id("org.openapi.generator") version "4.3.1"
    id("kotlinx-serialization")
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation(Dependency.kotlinStdLibJdk8)
    implementation(Dependency.kotlinxSerializationRuntime)

    implementation(Dependency.retrofit)
    implementation(Dependency.retrofitConverterMoshi)
    implementation(Dependency.retrofitConverterScalars)

    implementation(Dependency.moshi)
    implementation(Dependency.moshiAdapters)
    implementation(Dependency.moshiKotlin)
}

// API名称（パッケージ名に使われるので小文字で）
val apiName = "sp"

// 自動生成先のパッケージ名
val basePackage = "com.example.openapigenerationtestapi"

fun String.packageToDir() = replace('.', '/')

task<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>("generate") {
    doFirst {
        delete(file("$buildDir/openApiGenerator/$apiName"))
    }

    generatorName.set("kotlin")
    library.set("jvm-retrofit2")
    inputSpec.set("$rootDir/openapi.yaml")
    outputDir.set("$buildDir/openApiGenerator/$apiName/")
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

task<Copy>("copy") {
    val dirFrom = "$buildDir/openApiGenerator/$apiName/src/main/kotlin/${basePackage.packageToDir()}/"
    val dirInto = "$projectDir/src/main/java/${basePackage.packageToDir()}/"

    doFirst {
        delete(file(dirInto))
    }

    dependsOn("generate")
    from(dirFrom)
    into(dirInto)

    doLast {
        println("copied $dirFrom -> $dirInto")
    }
}

task("buildApi") {
    dependsOn("generate", "copy")
}