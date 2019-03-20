## 项目配置

1. gradle.properties
```
#gradle配置
compile_sdk_version = 28
min_sdk_version = 15
target_sdk_version = 28
support_version = 28.0.0
constraint_version = 1.1.3

#component配置
loginRunAlone = false
mineRunAlone = false
```

2. app/build.gradle
```
dependencies {
    if (!loginRunAlone.toBoolean()) {
        implementation project(':login')
    }
    if (!mineRunAlone.toBoolean()) {
        implementation project(':mine')
    }
}
```

3. login/mine build.gradle
```
if (loginRunAlone.toBoolean()) { //单独运行还是作为Library依赖
    apply plugin: 'com.android.application'
} else {
    apply plugin: 'com.android.library'
}

apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
android {
    compileSdkVersion compile_sdk_version.toInteger()
    
    defaultConfig {
        if (loginRunAlone.toBoolean()) { //是否配置applicationId
            applicationId "com.example.login"
        }
        minSdkVersion min_sdk_version.toInteger()
        targetSdkVersion target_sdk_version.toInteger()
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    //独立运行与集成调试时使用不同的 AndroidManifest.xml 文件
    sourceSets {
        main {
            if (loginRunAlone.toBoolean()) {
                manifest.srcFile 'src/main/manifest/AndroidManifest.xml'
            } else {
                manifest.srcFile 'src/main/AndroidManifest.xml'
            }
        }
    }

}

dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation "com.android.support:appcompat-v7:$support_version"
    implementation "com.android.support.constraint:constraint-layout:$constraint_version"
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    implementation project(':componentlib')
}

```

4. 作为Library时，AndroidManifest.xml如下：

```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          package="com.example.login">

    <application>
        <activity android:name=".LoginActivity" />
        <activity android:name=".SecondActivity" />
    </application>

</manifest>
```
