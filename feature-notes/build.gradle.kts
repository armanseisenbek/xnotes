apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(project(":core-constants"))
    "implementation"(project(":core-common"))
    "implementation"(project(":core-domain"))
    "implementation"(project(":core-ui"))
}