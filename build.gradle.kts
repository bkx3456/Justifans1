// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.7.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}

buildscript {
    dependencies { classpath("com.android.tools.build:gradle:8.7.2")
    }
    repositories {
        mavenCentral()
    }
}

