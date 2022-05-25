apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {
    "implementation"(project(":core-data"))
    "implementation"(project(":core-model"))
    "implementation"(project(":core-database"))
}