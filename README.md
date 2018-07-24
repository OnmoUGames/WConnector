# Onmo Wrapper Games SDK

Onmo Wrapper SDK is Bridge access to UGames Store Android applications.
SDK provide required information through callback methods.
just start your app and complete the set-up given below instructions.


## Set-up

### Download
Download [the latest AAR](https://github.com/srinivasvadde/Wrapper_Games_SDKsample/releases/latest) or grab via Gradle:

```groovy
implementation 'com.github.onmo:wgSDK:1.01'
```


### Putting it together
Integrating with Onmo Wrapper SDK is simple, seamless and straightforward to Wrapper Game applications. There is a simple initialization step
which occurs in your `Main Activity` or `Application class`:

```java

    public class MyApplication extends Application {
      public void onCreate() {
        super.onCreate();
        //init the SDK
        OnmoWGSDK.newInitializer(mContext);
      }
    }
```

### Accessing SDK methods
To Access any of SDK method is allowed through  IWGameSession interface, example code given below :

```java
IWGameSession mWGSession = OnmoWGSDK.newInitializer(mContext)
                              .build();
```


#### Authenticating with accesses token

```java
//Basic authentication
IWGameSession mWGSession = OnmoWGSDK.newInitializer(mContext)
                              .build(o6a-PfU-Phc-3tq);
```

#### Example - Getting User ID

```java

        mWGSession.getRegisterUser(new IResponseHandler<String>() {
            @Override
            public void handleResponse(String aUserId) {
                // wrapper game get the aUserId in callback result
            }

            @Override
            public void handleException(SDKException exception) {

            }
        });

```


See the [`Wrapper_Games_SDKsample` project](Wrapper_Games_SDKsample) for more details.





#### License
We also provide an additional patent grant.
