plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.returnpals"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.returnpals"
        minSdk = 30
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
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation("com.google.android.material:material:1.11.0")
    implementation ("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.6")
    implementation("androidx.navigation:navigation-compose:2.7.6")
    implementation("androidx.compose.material:material:1.6.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.1")

    /** AWS */

    // Amplify core dependency
    implementation("com.amplifyframework:core:2.14.11")
    implementation("com.amplifyframework:aws-auth-cognito:2.14.11")
    implementation("com.amplifyframework:aws-datastore:2.14.11")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")
    implementation("com.amplifyframework:aws-api:2.14.11")
    /** Android Testing */
    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test:core-ktx:1.1.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation("androidx.navigation:navigation-testing:2.7.6")



    /** Debug */
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    /** Amplify Dependencies **/
    implementation("com.amplifyframework:aws-datastore:2.14.11") {
        exclude(group = "com.amplifyframework", module = "aws-api-appsync")
    }

    implementation("com.amplifyframework:aws-api:1.38.8")









}
