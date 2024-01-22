object Versions {
    const val androidApplication = "8.2.1"
    const val jetbrainsKotlinAndroid = "1.9.22"
    const val materialComponents = "1.11.0"
    const val hilt = "2.47"
}

object Libs{
    object UI{
        const val material="com.google.android.material:material:${Versions.materialComponents}"
    }
    object Hilt{
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltKapt = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }
}
object Plugins {
    const val androidApplication = "com.android.application"
    const val jetBrainsKotlin = "org.jetbrains.kotlin.android"
    const val hilt = "dagger.hilt.android.plugin"
    const val kotlinKapt = "kotlin-kapt"
}
object Classpath {
    const val hilt = "com.google.dagger.hilt.android"
}