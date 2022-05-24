apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies {

    // Room
    "implementation"("androidx.room:room-runtime:2.4.2")
    "kapt"("androidx.room:room-compiler:2.4.2")

    // Kotlin Extensions and Coroutines support for Room
    "implementation"("androidx.room:room-ktx:2.4.2")

}