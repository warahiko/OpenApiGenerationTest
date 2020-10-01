object Dependency {
    object Version {
        const val kotlin = "1.4.10"
        const val kotlinxSerializationRuntime = "0.20.0"

        const val androidGradlePlugin = "4.0.1"
        const val androidxCoreKtx = "1.3.1"
        const val androidxAppcompat = "1.2.0"
        const val androidxConstraintLayout = "2.0.1"
        const val androidxActivityKtx = "1.1.0"

        const val retrofit = "2.8.1"
        const val okHttp = "4.9.0"
        const val moshi = "1.10.0"

        const val junit = "4.12"
        const val androidxTestExtJunit = "1.1.2"
        const val androidxTestEspressoCore = "3.3.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
    const val kotlinStdLibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Version.kotlin}"
    const val kotlinxSerializationRuntime = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Version.kotlinxSerializationRuntime}"

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Version.androidGradlePlugin}"
    const val androidxCoreKtx = "androidx.core:core-ktx:${Version.androidxCoreKtx}"
    const val androidxAppcompat = "androidx.appcompat:appcompat:${Version.androidxAppcompat}"
    const val androidxConstraintLayout = "androidx.constraintlayout:constraintlayout:${Version.androidxConstraintLayout}"
    const val androidxActivityKtx = "androidx.activity:activity-ktx:${Version.androidxActivityKtx}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val retrofitConverterMoshi = "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
    const val retrofitConverterScalars = "com.squareup.retrofit2:converter-scalars:${Version.retrofit}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp}"
    const val moshi = "com.squareup.moshi:moshi:${Version.moshi}"
    const val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Version.moshi}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Version.moshi}"

    const val junit = "junit:junit:${Version.junit}"
    const val androidxTestExtJunit = "androidx.test.ext:junit:${Version.androidxTestExtJunit}"
    const val androidxTestEspressoCore = "androidx.test.espresso:espresso-core:${Version.androidxTestEspressoCore}"
}