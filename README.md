# react-native-custom-camera

A custom React Native native module for opening the device camera.

## Installation

Install the package in your React Native app:

```sh
npm install react-native-custom-camera
```

or:

```sh
yarn add react-native-custom-camera
```

After installing a native module, rebuild the native app:

```sh
npx react-native run-android
```

## Usage

Call `openCamera` directly:

```tsx
import { openCamera } from 'react-native-custom-camera';

openCamera();
```

Use it from a button:

```tsx
import { Button, View } from 'react-native';
import { openCamera } from 'react-native-custom-camera';

export default function App() {
  return (
    <View>
      <Button title="Open Camera" onPress={() => void openCamera()} />
    </View>
  );
}
```

## Run The Example App

From this repository:

```sh
cd "D:\Camera Plugin\react-native-custom-camera"
node .yarn\releases\yarn-4.11.0.cjs install
```

Start Metro in one terminal:

```sh
cd "D:\Camera Plugin\react-native-custom-camera"
node .yarn\releases\yarn-4.11.0.cjs workspace react-native-custom-camera-example start
```

Run Android in another terminal:

```sh
cd "D:\Camera Plugin\react-native-custom-camera"
node .yarn\releases\yarn-4.11.0.cjs workspace react-native-custom-camera-example android
```

## Notes

- Android will ask for camera permission the first time the camera opens.
- If you update this package in an app, rebuild the native app again.
- Web builds use an unsupported fallback and will reject `openCamera()`.

## Contributing

- [Development workflow](CONTRIBUTING.md#development-workflow)
- [Sending a pull request](CONTRIBUTING.md#sending-a-pull-request)
- [Code of conduct](CODE_OF_CONDUCT.md)

## License

MIT
