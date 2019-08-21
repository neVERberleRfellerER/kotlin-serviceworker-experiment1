import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfigWriter.DevServer

plugins {
    kotlin("js") version "1.3.41"
}

repositories {
    jcenter()
}

kotlin {
    target {
        browser {
            runTask {
                devServer = DevServer(contentBase = listOf("$projectDir/src/jsMain/web"))
            }
            webpackTask {
            }
        }
    }

    sourceSets["main"].dependencies {
        implementation(kotlin("stdlib-js"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.3.0-RC2")
    }
}
