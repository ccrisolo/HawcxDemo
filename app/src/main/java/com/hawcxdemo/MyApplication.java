package com.hawcxdemo;

import android.app.Application;

import androidx.annotation.NonNull;

import com.facebook.react.BuildConfig;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import com.hawcx.HawcxInitializer; // Ensure you import HawcxInitializer
import java.util.List;
import com.hawcxdemo.HawcxPackage;


public class MyApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG; // Ensure BuildConfig is imported correctly
        }

        @Override
        protected List<ReactPackage> getPackages() {
            List<ReactPackage> packages = new PackageList(this).getPackages(); // Ensure PackageList is imported correctly
            packages.add(new HawcxPackage()); // Ensure this line is present
            return packages;
        }

        @Override
        protected String getJSMainModuleName() {
            return "index"; // Adjust this based on your project structure
        }
    };

    @NonNull
    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
        // Initialize Hawcx
        HawcxInitializer.getInstance().init(this, "LmVKd2x5a3NLd3lBUUFOQzd1QzVGWl94a3V1cE5aRFFxNW9NaFNVa185TzROZFAzZVJ6eTJ0UHJhaTV1SWNhMWJteHJleTh4MXVzWTJpNHZnWmZtenptODU3Z2NVV1JyZ1VKN2JNU2gzanBVUHowdjFZM3FkTFJ2cUtPamdTQ0VFYTNUU2FEcXdqbVJNUFFPQ2xVd0ltUUpUZ0pTVmNxelFST3pJUmtqaS13UDg0aTAzLlp2emZ3Zy5OQzF3UkxGeHp5TDVNVnF3TWFtNjF4VUVhQjNwMm1KazViSVl2LWFvSmR3eUs1ODIzSzU0MUh2TzJnQVUzSURpc1B4aXBDMllxS3o2cDZyV0pGUXVyQQ=="); // Use your actual API key
    }
}
