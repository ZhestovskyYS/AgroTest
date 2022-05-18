object AndroidConfig {
    const val COMPILE_SDK_VERSION = 32
    const val MIN_SDK_VERSION = 26
    const val TARGET_SDK_VERSION = 30
    const val BUILD_TOOLS_VERSION = "30.0.2"

    const val ID = "com.example.agrotest"
    const val ANDROIDX_TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    const val ANDROID_TEST_INSTRUMENTATION_RUNNER = "android.support.test.runner.AndroidJUnitRunner"
    const val CONSUMER_PROGUARD_FILE = "consumer-rules.pro"
}

interface BuildTypeConfig {
    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
    val isShrinkResources: Boolean
}

object BuildTypeRelease : BuildTypeConfig {
    override val isMinifyEnabled = true
    override val isShrinkResources = true
}

object BuildTypeDebug : BuildTypeConfig {
    override val isMinifyEnabled = false
    override val isShrinkResources = false
}