object PluginDependencies {
    val android = "com.android.tools.build:gradle:${Versions.gradleAndroidPlugin}"
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object ProjectModules {
    val data = ":data"
    val domain = ":domain"
}

object ProjectDependencies {

    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val ktlint = "com.github.shyiko:ktlint:${Versions.ktlint}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    val koin = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"

    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutinesAdapter}"

    val supportAppCompat = "androidx.appcompat:appcompat:${Versions.supportLibrary}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.supportLibrary}"
    val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val coreAndroidX = "androidx.core:core-ktx:${Versions.coreAndroidX}"
    val cardView = "androidx.cardview:cardview:1.0.0${Versions.cardView}"
    val anko = "org.jetbrains.anko:anko:${Versions.anko}"
    val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    val junit = "junit:junit:${Versions.junit}"
    val assertJ = "org.assertj:assertj-core:${Versions.assertJ}"
    val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    val mockitoKotlin = "com.nhaarman:mockito-kotlin:${Versions.mockitoKotlin}"
    val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val kakao = "com.agoda.kakao:kakao:${Versions.kakao}"
    val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"

    val groupie = "com.xwray:groupie:${Versions.groupie}"
    val groupieExtension = "com.xwray:groupie-kotlin-android-extensions:${Versions.groupie}"
}

object Versions {
    val gradleAndroidPlugin = "3.0.1"

    val compileSdk = 28
    val targetSdk = 27
    val minSdkVersion = 21
    val releaseVersionCode = 2
    val releaseVersionName = "1.0.1"

    val constraintLayout = "1.1.3"
    val materialDesign = "1.0.0"
    val coreAndroidX = "1.0.2"
    val cardView = "1.0.0"
    val anko = "0.10.8"
    val navigation = "2.1.0-alpha05"

    val supportLibrary = "1.0.0"
    val kotlin = "1.3.0"
    val retrofit = "2.4.0"
    val coroutines = "1.0.1"
    val coroutinesAdapter = "0.9.2"

    val loggingInterceptor = "3.10.0"
    val ktlint = "0.20.0"
    val koin = "1.0.1"
    val lifecycle = "2.0.0-rc01"

    val junit = "4.12"
    val androidTestRunner = "1.1.0"
    val espresso = "3.1.0"
    val assertJ = "3.9.1"
    val mockito = "2.18.0"
    val mockitoKotlin = "1.5.0"
    val kakao = "1.4.0"
    val groupie = "2.3.0"
}
