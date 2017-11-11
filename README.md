# PersianJodaTime
JodaTime with Persian/Solar calendar  

## Usage

### Download

1) Add JitPack repository in your root `build.gradle` at the end of `repositories` :

```java

allprojects {
  repositories {
      ...
      maven { url 'https://jitpack.io' }
  }
}

```
 
2) Add dependency to your root `build.gradle` :

```java
dependencies {
  ...
  compile 'com.github.mohamadian:PersianJodaTime:1.2'
}
```

### Call JodaTimeAndroid.init()
You must initialize the library before using it by calling `JodaTimeAndroid.init()`. I suggest putting this code in `Application.onCreate()` :

```java
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }
}
```

and use `MyApplication` class in `AndroidManifest.xml` like this:
```java
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.mohamadian.testapp">

    <application
        android:name=".MyApplication"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```

### How to create Persian DateTime and how to use it
Ok, just create a `PersianChronology` object and pass it to `DateTime` class, all done:

```java

PersianChronology perChr = PersianChronologyKhayyam.getInstance(DateTimeZone.forID("Asia/Tehran"));
DateTime now = new DateTime(perChr);

DateTime dt = new DateTime(1396, 8, 2, 0, 0, perChr);
```

### Credits 
This libary is based on [joda-time](https://github.com/JodaOrg/joda-time) and [zubinkavarana/joda-time](https://github.com/zubinkavarana/joda-time).

### Thanks
Special thanks to [zubinkavarana](https://github.com/zubinkavarana).
