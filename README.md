# Onmo Wrapper Games SDK

Onmo Wrapper Games SDK is interface for UGames Store Android applications.
Wrapper Games have a access to UGames Store application's data through this SDK.
Once you complete the set-up instructions below, just start your app and point


## Set-up

### Download
Download [the latest AAR](https://github.com/srinivasvadde/Wrapper_Games_SDKsample/releases/latest) or grab via Gradle:
```groovy
compile 'com.onmo.wgsdk:1.0'
```


### Putting it together
Integrating with Onmo SDK is intended to be seamless and straightforward to Wrapper Game applications. There is a simple initialization step
which occurs in your `MainActivity`:

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
                    // wrapper game get the aUserId in callback result
                }

                @Override
                public void handleException(SDKException exception) {

                }
            });
        }
```

## License
We also provide an additional patent grant.
