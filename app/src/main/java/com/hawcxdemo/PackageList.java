package com.hawcxdemo;

import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;

import java.util.ArrayList;
import java.util.List;

public class PackageList {

    public PackageList(ReactNativeHost application) {
    }

    public List<ReactPackage> getPackages() {
        return new ArrayList<ReactPackage>() {{
            // Add your packages here
            // For example, add(new MainReactPackage());
            add(new HawcxPackage()); // Add your HawcxPackage here
            // You can add other packages as needed
        }};
    }
}
