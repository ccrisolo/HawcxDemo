package com.hawcxdemo;

import androidx.annotation.NonNull;
import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.hawcx.HawcxInitializer;
import com.hawcx.auth.SignIn;
import com.hawcx.auth.SignUp;
import com.hawcx.utils.AuthErrorHandler.SignInErrorCode;
import com.hawcx.utils.AuthErrorHandler.SignUpErrorCode;

public class HawcxModule extends ReactContextBaseJavaModule implements SignIn.SignInCallback, SignUp.SignUpCallback {

    private Promise currentPromise;

    public HawcxModule(ReactApplicationContext reactContext) {
        super(reactContext);
        // Initialize HAWCX SDK with the API key
        HawcxInitializer.getInstance().init(reactContext, "LmVKd2x5a3NLd3lBUUFOQzd1QzVGWl94a3V1cE5aRFFxNW9NaFNVa185TzROZFAzZVJ6eTJ0UHJhaTV1SWNhMWJteHJleTh4MXVzWTJpNHZnWmZtenptODU3Z2NVV1JyZ1VKN2JNU2gzanBVUHowdjFZM3FkTFJ2cUtPamdTQ0VFYTNUU2FEcXdqbVJNUFFPQ2xVd0ltUUpUZ0pTVmNxelFST3pJUmtqaS13UDg0aTAzLlp2emZ3Zy5OQzF3UkxGeHp5TDVNVnF3TWFtNjF4VUVhQjNwMm1KazViSVl2LWFvSmR3eUs1ODIzSzU0MUh2TzJnQVUzSURpc1B4aXBDMllxS3o2cDZyV0pGUXVyQQ==");
        Log.d("HawcxModule", "HawcxModule constructor called");
    }

    @NonNull
    @Override
    public String getName() {
        return "HawcxModule";
    }

    // Method to handle sign-in
    @ReactMethod
    public void login(String email, Promise promise) {
        currentPromise = promise;
        SignIn signIn = HawcxInitializer.getInstance().getSignIn();
        signIn.signIn(email, this);  // Sign in using HAWCX SDK
    }

    // Method to handle sign-up
    @ReactMethod
    public void signUp(String email, Promise promise) {
        currentPromise = promise;
        SignUp signUp = HawcxInitializer.getInstance().getSignUp();
        signUp.signUp(email, this);  // Sign up using HAWCX SDK
    }

    // Method to check the last logged-in user
    @ReactMethod
    public void checkLastUser(Promise promise) {
        currentPromise = promise;
        SignIn signIn = HawcxInitializer.getInstance().getSignIn();
        signIn.checkLastUser(this);  // Check if the last user exists
    }

    // Handling sign-in callbacks

    @Override
    public void onSuccessfulLogin(String loggedInEmail) {
        // Handle successful login, resolve the promise
        if (currentPromise != null) {
            currentPromise.resolve(loggedInEmail);  // Resolve promise with logged-in email
            currentPromise = null;
        }
    }

    @Override
    public void showError(String errorMessage) {
        // Handle general error during login, reject the promise
        if (currentPromise != null) {
            currentPromise.reject("LOGIN_ERROR", errorMessage);
            currentPromise = null;
        }
    }

    @Override
    public void showError(SignInErrorCode errorCode, String errorMessage) {
        // Handle sign-in specific error with error code, reject the promise
        if (currentPromise != null) {
            currentPromise.reject("LOGIN_ERROR", errorMessage);
            currentPromise = null;
        }
    }

    // Handle biometric authentication initiation
    @Override
    public void initiateBiometricLogin(Runnable onSuccess) {
        // Call onSuccess if biometric authentication is successful
        onSuccess.run();
    }

    @Override
    public void showEmailSignInScreen() {
        // Handle showing email sign-in screen if necessary
        System.out.println("Show email sign-in screen");
    }

    // Handling sign-up callbacks

    @Override
    public void onSuccessfulSignup() {
        // Handle successful sign-up, resolve the promise
        if (currentPromise != null) {
            currentPromise.resolve("Signup Successful");
            currentPromise = null;
        }
    }

    @Override
    public void onGenerateOTPSuccess() {
        // Handle successful OTP generation if necessary
        System.out.println("OTP generation successful");
    }

    @Override
    public void showError(SignUpErrorCode errorCode, String errorMessage) {
        // Handle sign-up specific error with error code, reject the promise
        if (currentPromise != null) {
            currentPromise.reject("SIGNUP_ERROR", errorMessage);
            currentPromise = null;
        }
        System.out.println("Sign-Up Error Code: " + errorCode + ", Message: " + errorMessage);
    }
}
