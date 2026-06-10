const CustomCamera = {
  openCamera(): Promise<string> {
    return Promise.reject(
      new Error('react-native-custom-camera is not supported on web')
    );
  },
};

export default CustomCamera;
