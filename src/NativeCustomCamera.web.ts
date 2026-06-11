const CustomCamera = {
  openCamera(): Promise<string> {
    return Promise.reject(
      new Error(
        '@asif-pindi/react-native-custom-camera is not supported on web'
      )
    );
  },
};

export default CustomCamera;
