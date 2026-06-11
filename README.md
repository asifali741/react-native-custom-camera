# @asif-pindi/react-native-custom-camera

A custom React Native native module for opening the device camera.

## Installation

Install the package in a React Native app:

```sh
npm install @asif-pindi/react-native-custom-camera
```

or:

```sh
yarn add @asif-pindi/react-native-custom-camera
```

After installing or updating a native module, rebuild the native app:

```sh
npx react-native run-android
```

## Usage

Import and call `openCamera`:

```tsx
import { openCamera } from '@asif-pindi/react-native-custom-camera';

openCamera();
```

Button example:

```tsx
import { Button, View } from 'react-native';
import { openCamera } from '@asif-pindi/react-native-custom-camera';

export default function App() {
  return (
    <View>
      <Button title="Open Camera" onPress={() => void openCamera()} />
    </View>
  );
}
```

## Android Permission

The package declares the Android camera permission. Android will ask the user for camera permission the first time the camera opens.

If permission is denied, call `openCamera()` again after the user enables camera permission from app settings.

## Platform Support

- Android: supported.
- iOS: native files are included, but camera opening behavior currently needs iOS implementation.
- Web: not supported. `openCamera()` rejects with an unsupported-platform error.

## Example App

Clone the repository and install dependencies:

```sh
git clone https://github.com/asifali741/react-native-custom-camera.git
cd react-native-custom-camera
yarn install
```

Start Metro:

```sh
yarn example start
```

Run the Android example:

```sh
yarn example android
```

## Updating The Package

When a new version is published, update it in your app:

```sh
npm install @asif-pindi/react-native-custom-camera@latest
```

or:

```sh
yarn add @asif-pindi/react-native-custom-camera@latest
```

Then rebuild the native app.

## License

MIT
