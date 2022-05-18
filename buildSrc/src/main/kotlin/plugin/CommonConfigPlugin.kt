package plugin

import BuildTypeConfig
import BuildTypeDebug
import BuildTypeRelease
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.BuildType
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class CommonConfigPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val androidExtension = project.extensions.getByName("android")
        (androidExtension as? BaseExtension)?.apply {
            val pluginManager = project.pluginManager
            val isAppModule = pluginManager.hasPlugin(GradlePluginId.ANDROID_APPLICATION)
            compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
            buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)

            defaultConfig {
                if (isAppModule) {
                    it.applicationId = AndroidConfig.ID
                    it.testInstrumentationRunner =
                        AndroidConfig.ANDROIDX_TEST_INSTRUMENTATION_RUNNER
                } else {
                    it.consumerProguardFile(AndroidConfig.CONSUMER_PROGUARD_FILE)
                    it.testInstrumentationRunner = AndroidConfig.ANDROID_TEST_INSTRUMENTATION_RUNNER
                }
                it.targetSdk = AndroidConfig.TARGET_SDK_VERSION
                it.minSdk = AndroidConfig.MIN_SDK_VERSION
            }

            buildTypes {
                it.getByName(BuildTypeConfig.RELEASE) { buildType ->
                    buildType.configure(BuildTypeRelease, isAppModule, this)
                }
                it.getByName(BuildTypeConfig.DEBUG) { buildType ->
                    buildType.configure(BuildTypeDebug, isAppModule, this)
                }
            }

            compileOptions {
                it.targetCompatibility = JavaVersion.VERSION_1_8
                it.sourceCompatibility = JavaVersion.VERSION_1_8
            }
        }
    }



    private fun BuildType.configure(config: BuildTypeConfig, isAppModule: Boolean, baseExtension: BaseExtension) {
        proguardFiles(
            baseExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
            "proguard-rules.pro",
            "proguard-release.pro"
        )
        isMinifyEnabled = config.isMinifyEnabled
        if (isAppModule) isShrinkResources = config.isShrinkResources
    }
}