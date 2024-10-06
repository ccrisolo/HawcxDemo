// src/LandingPage.js

import React from 'react';
import { View, Text, Button, StyleSheet } from 'react-native';

const LandingPage = ({ onLogout }) => {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Welcome to the Landing Page!</Text>
      <Button title="Logout" onPress={handleLogout} />
    </View>
  );

  function handleLogout() {
    // You can add any additional logic before logging out, if needed
    onLogout();
  }
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20, // Added padding for better UI
  },
  title: {
    fontSize: 24,
    marginBottom: 20,
    textAlign: 'center', // Centered text for better alignment
  },
});

export default LandingPage;
