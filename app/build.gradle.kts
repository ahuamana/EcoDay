import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    //Kotlin Serialization for Safe Args
    alias(libs.plugins.kotlin.serialization.json)
    //Hilt & KSP
    alias(libs.plugins.kotlin.android.ksp)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
}


val localProperties = Properties().apply {
    FileInputStream(rootProject.file("local.properties")).use { load(it) }
}

val apiKey: String? = localProperties.getProperty("API_KEY")

android {
    namespace = "com.ahuaman.ecoday"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ahuaman.ecoday"
        minSdk = 26
        targetSdk = 35
        versionCode = 11
        versionName = "1.2.3"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            buildConfigField("String", "API_KEY", "\"$apiKey\"")
        }
        release {
            buildConfigField("String", "API_KEY", "\"$apiKey\"")
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
    buildFeatures {
        compose = true
        buildConfig = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Lottie
    implementation (libs.lottie.compose)

    //Navigation Safe
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlin.serialization.json)
    implementation (libs.magictablayout)

    //coil
    implementation(libs.coil)

    //AI Gemini

    implementation(libs.generativeai)

    implementation (libs.lifecycle.viewmodel.compose)
    implementation (libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.hilt.navigation.compose)

    //gson
    implementation (libs.converter.gson)


    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

}