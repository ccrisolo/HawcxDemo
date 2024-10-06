import React, { useState } from 'react';
import { View, TextInput, Button, StyleSheet, Text, TouchableOpacity } from 'react-native';
import { NativeModules } from 'react-native';

const { HawcxModule } = NativeModules;

const LoginScreen = ({ navigation }) => {
  const [email, setEmail] = useState('');
  const [error, setError] = useState('');

  const handleLogin = () => {
    console.log('hitting login');
    HawcxModule?.checkLastUser((user) => {
      if (user) {
        navigation.navigate('LandingPage');
      } else {
        // Passwordless login: initiate authentication with email only
        HawcxModule.login(email, null, (err) => {  // No password needed
          console.log(email, err);
          if (err) {
            setError('Login failed. Please try again.');
          } else {
            navigation.navigate('LandingPage');
          }
        });
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
      <Button title="Login" onPress={handleLogin} />

      <TouchableOpacity onPress={() => navigation.navigate('SignUpScreen')}>
        <Text style={styles.switchText}>Don't have an account? Sign Up</Text>
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

export default LoginScreen;
