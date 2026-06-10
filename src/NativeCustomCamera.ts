import { TurboModuleRegistry, type TurboModule } from 'react-native';

export interface Spec extends TurboModule {
  openCamera(): Promise<string>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('CustomCamera');
