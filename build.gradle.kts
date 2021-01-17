buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:4.1.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.28-alpha")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register ("clean" , Delete::class) {
   delete(rootProject.buildDir)
}