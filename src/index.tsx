import CustomCamera from './NativeCustomCamera';

export function openCamera(): Promise<string> {
  return CustomCamera.openCamera();
}
