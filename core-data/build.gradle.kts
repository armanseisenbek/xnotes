apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(project(":core-model"))
    "implementation"(project(":core-domain"))
    "implementation"(project(":core-database"))
}