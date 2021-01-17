plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
}
android {
    compileSdkVersion(30)
    buildToolsVersion("29.0.3")

    defaultConfig {
        applicationId = "com.example.nasatestapi"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules-debug.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules-debug.pro"
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
flavorDimensions("version")
    productFlavors {
        create("dev") {
            dimension = "version"
            buildConfigField("String", "NASA_BASE_URL", "\"https://api.nasa.gov\"")
            buildConfigField("String", "NASA_IMAGE_URL", "\"https://images-api.nasa.gov\"")
        }
        create("prod") {
            dimension = "version"
            buildConfigField("String", "NASA_BASE_URL", "\"https://api.nasa.gov\"")
            buildConfigField("String", "NASA_IMAGE_URL", "\"https://images-api.nasa.gov\"")
        }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    //KTX
    implementation("androidx.core:core-ktx:1.3.2")

    //AppCompat
    implementation("androidx.appcompat:appcompat:1.2.0")

    //Material Design
    implementation("com.google.android.material:material:1.2.1")

    //Constraint
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.28-alpha")
    kapt("com.google.dagger:hilt-android-compiler:2.28-alpha")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02")
    kapt("androidx.hilt:hilt-compiler:1.0.0-alpha02")

    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    //Test
    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    //RxJava
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")
    implementation("com.jakewharton.rxrelay3:rxrelay:3.0.0")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.0")

    //Timber
    implementation("com.jakewharton.timber:timber:4.7.1")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.11.0")
    kapt("com.github.bumptech.glide:compiler:4.11.0")

    //Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.2.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.2.0")

    //Navigation
    implementation("androidx.navigation:navigation-runtime-ktx:2.3.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.2")

    //BindingHelper
    implementation("com.kirich1409.viewbindingpropertydelegate:vbpd-noreflection:1.4.1")
}