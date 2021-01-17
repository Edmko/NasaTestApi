plugins{
    id("java-library")
    id("kotlin")
    kotlin("kapt")
}
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation ("io.reactivex.rxjava3:rxkotlin:3.0.1")
    implementation ("com.jakewharton.rxrelay3:rxrelay:3.0.0")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.28-alpha")
    kapt("com.google.dagger:hilt-android-compiler:2.28-alpha")
}