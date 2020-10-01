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
    implementation(Dependency.okHttpLoggingInterceptor)

    implementation(Dependency.moshi)
    implementation(Dependency.moshiAdapters)
    implementation(Dependency.moshiKotlin)
}

// API名称（パッケージ名に使われるので小文字で）
val apiName = "sp"

// ビルド先ディレクトリ
val buildApiDir = "$buildDir/openApiGenerator/$apiName"

// 自動生成先のパッケージ名
val basePackage = "com.example.openapigenerationtestapi"

fun String.packageToDir() = replace('.', '/')

task<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>("generate") {
    doFirst {
        delete(file(buildApiDir))
    }

    generatorName.set("kotlin")
    library.set("jvm-retrofit2")
    templateDir.set("$rootDir/template")
    inputSpec.set("$rootDir/openapi.yaml")
    outputDir.set(buildApiDir)
    packageName.set(basePackage)
    apiPackage.set("$basePackage.$apiName.api")
    modelPackage.set("$basePackage.$apiName.model")
    configOptions.set(mapOf(
        "dateLibrary" to "java8"
    ))
    additionalProperties.set(mapOf(
        "doNotUseRxAndCoroutines" to "true"
    ))
    generateApiTests.set(false)
}

task<Copy>("copy") {
    val dirFrom = "$buildApiDir/src/main/kotlin/${basePackage.packageToDir()}/"
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