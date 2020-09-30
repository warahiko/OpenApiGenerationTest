buildscript {
    val kotlinVersion: String by extra { "1.4.10" }
    val androidGradlePluginVersion: String by extra { "4.0.1" }
    val kotlinxSerializationRuntime: String by extra { "0.20.0" }
    val retrofitVersion: String by extra { "2.8.1" }
    val okHttpVersion: String by extra { "4.9.0" }
    val moshiVersion: String by extra { "1.10.0" }

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build", "gradle", version = androidGradlePluginVersion)
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath(kotlin("serialization", version = kotlinVersion))
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task<Delete>("clean") {
    delete = setOf(rootProject.buildDir)
}