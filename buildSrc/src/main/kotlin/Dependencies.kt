object Dependencies {
    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:${Version.androidPlugin}"
    }

    object Library {
        object Kotlin {
            const val test = "org.jetbrains.kotlin:kotlin-test:${Version.kotlin}"
            const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Version.kotlin}"
        }

        object Spek2 {
            const val dslJvm = "org.spekframework.spek2:spek-dsl-jvm:${Version.spek}"
            const val runnerJunit5 = "org.spekframework.spek2:spek-runner-junit5:${Version.spek}"
        }

        const val mockk = "io.mockk:mockk:${Version.mockk}"
    }

    object Version {
        // Language
        const val kotlin = "1.3.72"

        // Plugin
        const val androidPlugin = "3.6.1"
        const val gradlePublishPlugin = "0.12.0"
        const val ktlintGradlePlugin = "9.2.1"
        const val gradleVersionsPlugin = "0.28.0"

        // Library
        const val spek = "2.0.10"
        const val mockk = "1.10.0"
    }
}
