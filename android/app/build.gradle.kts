import java.io.File

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.my_first_app"
    compileSdk = flutter.compileSdkVersion

    // Automatically select the highest installed NDK version
    val ndkDir = File(System.getenv("ANDROID_SDK_ROOT") ?: "")
    val ndkVersions = ndkDir.resolve("ndk").listFiles()?.map { it.name }?.sortedDescending()
    ndkVersion = ndkVersions?.firstOrNull() ?: "27.0.12077973" // fallback if none found

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        applicationId = "com.example.my_first_app"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}
