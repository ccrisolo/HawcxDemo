//package com.hawcxdemo;
//import android.os.Bundle;
//
//import com.hawcx.auth.SignIn;
//import com.hawcx.utils.AuthErrorHandler.SignInErrorCode;
//import com.hawcx.HawcxInitializer;
//import androidx.appcompat.app.AppCompatActivity;
//
//
//
//public class MainActivity extends AppCompatActivity implements SignIn.SignInCallback {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        String email = "YOUR_EMAIL_HERE";
//
//        // Example: Implement secure login
//        // User Login
//        SignIn loginAct = HawcxInitializer.getInstance().getSignIn();
//
//        // Check last logged in user and signal biometric auth if applicable
//        loginAct.checkLastUser(this);
//
//        loginAct.signIn(email, this);
//
//    }
//    @Override
//    public void onSuccessfulLogin(String loggedInEmail) {
//        // Handle successful login
//    }
//
//    @Override
//    public void showError(String errorMessage) {
//        // Handle login failure
//    }
//
//    @Override
//    public void showError(SignInErrorCode errorCode, String errorMessage) {
//        // Handle error with error code and message
//    }
//
//    // If lastuser found
//    @Override
//    public void initiateBiometricLogin(Runnable onSuccess) {
//        // Handle Biometric Auth
//    }
//
//    // If no last user is found
//    @Override
//    public void showEmailSignInScreen() {
//        // Handle the Email screen
//    }
//}
//

package com.hawcxdemo;

import android.os.Bundle;
import com.hawcx.auth.SignIn;
import com.hawcx.utils.AuthErrorHandler.SignInErrorCode;
import com.hawcx.HawcxInitializer;
import com.facebook.react.ReactActivity;

public class MainActivity extends ReactActivity implements SignIn.SignInCallback {

    @Override
    protected String getMainComponentName() {
        return "HawcxDemo"; // This should match the name you used in your JavaScript code
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Note: setContentView is not needed for ReactActivity; it manages the view for you.

        String email = "YOUR_EMAIL_HERE";

        // Example: Implement secure login
        // User Login
        SignIn loginAct = HawcxInitializer.getInstance().getSignIn();

        // Check last logged in user and signal biometric auth if applicable
        loginAct.checkLastUser(this);
        loginAct.signIn(email, this);
    }

    @Override
    public void onSuccessfulLogin(String loggedInEmail) {
        // Handle successful login
    }

    @Override
    public void showError(String errorMessage) {
        // Handle login failure
    }

    @Override
    public void showError(SignInErrorCode errorCode, String errorMessage) {
        // Handle error with error code and message
    }

    @Override
    public void initiateBiometricLogin(Runnable onSuccess) {
        // Handle Biometric Auth
    }

    @Override
    public void showEmailSignInScreen() {
        // Handle the Email screen
    }
}
