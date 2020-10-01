plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.1")

    defaultConfig {
        applicationId = "com.example.openapigenerationtest"
        minSdkVersion(16)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(project(":api"))

    implementation(Dependency.kotlinStdLib)
    implementation(Dependency.androidxCoreKtx)
    implementation(Dependency.androidxAppcompat)
    implementation(Dependency.androidxConstraintLayout)
    implementation(Dependency.androidxActivityKtx)
    implementation(Dependency.junit)
    implementation(Dependency.androidxTestExtJunit)
    implementation(Dependency.androidxTestEspressoCore)

    implementation(Dependency.retrofit)
    implementation(Dependency.okHttpLoggingInterceptor)
}
