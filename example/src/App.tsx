import { Button, StyleSheet, View } from 'react-native';
import { openCamera } from 'react-native-custom-camera';

export default function App() {
  return (
    <View style={styles.container}>
      <Button
        title="Open Camera"
        onPress={() => {
          openCamera().catch((error) => {
            console.warn(error);
          });
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
