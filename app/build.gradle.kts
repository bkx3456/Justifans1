plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.justifans"
    compileSdk = 34
    buildFeatures{
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.example.justifans"  // Sesuaikan dengan nama paket aplikasi
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
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

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("com.google.firebase:firebase-auth-ktx:21.1.0")  // Tambahkan versi Firebase Auth
    implementation("androidx.cardview:cardview:1.0.0")
    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core)
}

// Ini untuk memastikan plugin Google Services ditambahkan
apply(plugin = "com.google.gms.google-services")
