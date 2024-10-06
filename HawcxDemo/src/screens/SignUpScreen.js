import React, { useState } from 'react';
import { View, TextInput, Button, StyleSheet, Text, TouchableOpacity } from 'react-native';
import { NativeModules } from 'react-native';

const { HawcxModule } = NativeModules;

console.log('HawcxModule', HawcxModule);

const SignUpScreen = ({ navigation }) => {
  const [email, setEmail] = useState('');
  const [error, setError] = useState('');

  const handleSignUp = () => {
    console.log('hitting sign up');
    // Call HawcxModule to sign up user with email (modify based on HawcxModule's signUp method)
    HawcxModule.signUp(email, (err) => {
      if (err) {
        setError('Sign up failed. Please try again.');
      } else {
        navigation.navigate('LandingPage');
      }
    });
  };

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.input}
        placeholder="Email"
        value={email}
        onChangeText={setEmail}
      />
      {error && <Text style={styles.error}>{error}</Text>}
      <Button title="Sign Up" onPress={handleSignUp} />

      <TouchableOpacity onPress={() => navigation.navigate('LoginScreen')}>
        <Text style={styles.switchText}>Already have an account? Log In</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    padding: 20,
  },
  input: {
    height: 40,
    borderColor: 'gray',
    borderWidth: 1,
    marginBottom: 20,
    paddingHorizontal: 10,
  },
  error: {
    color: 'red',
    marginBottom: 20,
  },
  switchText: {
    marginTop: 20,
    color: 'blue',
    textAlign: 'center',
  },
});

export default SignUpScreen;
