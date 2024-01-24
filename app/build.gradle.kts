plugins {
    id(Plugins.androidApplication)
    id(Plugins.jetBrainsKotlin)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
}

android {
    namespace = "com.mahammadjafarzade.structureofprojects"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mahammadjafarzade.structureofprojects"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

    implementation(project(":features:account"))
    implementation(project(":features:flights"))

    implementation(Libs.UI.material)
    implementation(Libs.Hilt.hilt)


    implementation(Libs.Navigation.navigationUi)
    implementation(Libs.Navigation.navigationFragment)
    kapt(Libs.Hilt.hiltKapt)
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}