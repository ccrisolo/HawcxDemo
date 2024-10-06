import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import LoginScreen from './src/screens/LoginScreen';  // Update paths if necessary
import SignUpScreen from './src/screens/SignUpScreen';  // New screen for signup
import LandingPage from './src/screens/LandingPage';  // Update paths if necessary

const Stack = createNativeStackNavigator();

const App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="LoginScreen">
        <Stack.Screen
          name="LoginScreen"
          component={LoginScreen}
          options={{ title: 'Login' }}
        />
        <Stack.Screen
          name="SignUpScreen"
          component={SignUpScreen}
          options={{ title: 'Sign Up' }}
        />
        <Stack.Screen
          name="LandingPage"
          component={LandingPage}
          options={{ title: 'Welcome' }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;
