# Onmo Wrapper Games SDK

Onmo Wrapper Games SDK is interface for UGames Store Android applications.
Wrapper Games Application have a access to UGames Store application data / features through this SDK.
Once you complete the set-up instructions below, just start your app and point


## Set-up

### Download
Download [the latest AAR](https://github.com/srinivasvadde/Wrapper_Games_SDKsample/releases/latest) or grab via Gradle:
```groovy
compile 'com.onmo.sdk:1.0'
```

For more details on how to customize the JavaScript runtime see [stetho-js-rhino](stetho-js-rhino/).

### Putting it together
Integrating with Onmo SDK is intended to be seamless and straightforward for
most existing Android applications.  There is a simple initialization step
which occurs in your `Application` class:

```java
public class MyApplication extends Application {
  public void onCreate() {
    super.onCreate();
    OnmoWGSDK.newInitializer(mContext);
  }
}
```
Also ensure that your `MyApplication` Java class is registered in your `AndroidManifest.xml` file, otherwise you will not see an "Inspect" button in `chrome://inspect/#devices` :

```xml
<manifest
        xmlns:android="http://schemas.android.com/apk/res/android"
        ...>
        <application
                android:name="MyApplication"
                ...>
         </application>
</manifest>
```

This brings up most of the default configuration but does not enable some
additional hooks (most notably, network inspection).  See below for specific
details on individual subsystems.

### Accessing SDK methods
This is currently the simplest way
and most straightforward way to access the SDK methods:

```java
IWGameSession mWGSession = OnmoWGSDK.newInitializer(mContext)
                              .build();
```

See the [`Wrapper_Games_SDKsample` project](Wrapper_Games_SDKsample) for more details.

## Going further

### Getting User details


```java
    if(mWGSession!=null)
        {
            mWGSession.getRegisterUser(new IResponseHandler<String>() {
                @Override
                public void handleResponse(String aUserId) {
                    // wrapper game get the aUserId from teh callback
                }

                @Override
                public void handleException(SDKException exception) {

                }
            });
        }
```

## License
We also provide an additional patent grant.
