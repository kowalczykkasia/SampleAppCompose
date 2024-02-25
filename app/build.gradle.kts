plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    signingConfigs {
        getByName("debug") {
            storeFile = file("/Users/kasia/Desktop/SampleApp_portfolio/keystore.jks")
            storePassword = "sample"
            keyAlias = "keystore"
            keyPassword = "sample"
        }
    }
    namespace = "com.kasia.sample.app.compose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kasia.sample.app.compose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {

        }
    }

    buildFeatures {
        buildConfig = true
    }

    kotlinOptions {
        freeCompilerArgs += "-Xextended-compiler-checks"
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
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":feature"))
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.navigation:navigation-compose:2.7.6")
    implementation("androidx.compose.material3:material3:1.1.2")
    //Tests
    debugImplementation("androidx.compose.ui:ui-tooling")
    testImplementation("org.mockito:mockito-core:3.8.0")
    androidTestImplementation("org.mockito:mockito-android:3.8.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    testImplementation("com.google.truth:truth:1.1.2")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    //Coil
    implementation("io.coil-kt:coil-compose:2.0.0-rc01")
    //Hilt
    val hiltVersion = "2.50"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")
    val hiltComposeVersion = "1.1.0"
    implementation("androidx.hilt:hilt-navigation-compose:$hiltComposeVersion")
    //Compose
    val viewModelCompose = "2.7.0"
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$viewModelCompose")
    implementation("androidx.compose.material:material:1.6.0")
}