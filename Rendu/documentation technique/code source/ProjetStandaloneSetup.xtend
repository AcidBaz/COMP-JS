/*
 * generated by Xtext 2.13.0
 */
package org.xtext.example


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class ProjetStandaloneSetup extends ProjetStandaloneSetupGenerated {

	def static void doSetup() {
		new ProjetStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
