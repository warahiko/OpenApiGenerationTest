buildscript {
    val kotlinVersion: String by extra { "1.3.72" }
    val androidGradlePluginVersion: String by extra { "4.0.1" }

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build", "gradle", version = androidGradlePluginVersion)
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
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