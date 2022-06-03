apply {
    from("$rootDir/library-build.gradle")
}

dependencies {
    "implementation"(project(":core-model"))
    "implementation"(project(":core-common"))

    // Coroutines
    "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
}