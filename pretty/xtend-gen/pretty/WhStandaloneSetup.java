/**
 * generated by Xtext 2.19.0
 */
package pretty;

import pretty.WhStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class WhStandaloneSetup extends WhStandaloneSetupGenerated {
  public static void doSetup() {
    new WhStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
