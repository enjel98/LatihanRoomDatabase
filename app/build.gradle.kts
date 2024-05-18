plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.latihanroomdatabase"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.latihanroomdatabase"
        minSdk = 26
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
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    val activityVersion = "1.9.0"
    val appCompatVersion = "1.6.1"
    val constraintLayoutVersion = "2.1.4"
    val coroutines = "1.7.1"
    val lifecycleVersion = "2.7.0"
    val materialVersion = "1.11.0"
    val roomVersion = "2.6.1"
    val kotlinVersion = "1.9.0"

    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("androidx.activity:activity-ktx:$activityVersion")
    implementation("androidx.core:core-ktx:1.13.0")

    // Room components
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    androidTestImplementation("androidx.room:room-testing:$roomVersion")

    // Lifecycle components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")

    // Kotlin components
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines")

    // UI
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion") // Corrected variable name
    implementation("com.google.android.material:material:$materialVersion")
}
