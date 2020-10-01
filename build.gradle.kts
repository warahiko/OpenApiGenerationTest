buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Dependency.androidGradlePlugin)
        classpath(Dependency.kotlinGradlePlugin)
        classpath(Dependency.kotlinSerialization)
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