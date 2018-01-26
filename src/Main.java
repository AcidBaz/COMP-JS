/*
 * generated by Xtext 2.12.0
 */
package org.xtext.example.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.IResourceValidator;
import org.xtext.example.ProjetStandaloneSetupGenerated;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class Main {

	public static void main(String[] args) {
		
		boolean helpMode = false;
		boolean repoMode = true;
		String source = "";
		String path = "src-gen";
		if (args.length == 0) {
			System.err.println("Aborting: no path to EMF resource provided!");
			return;
			
		} else if(args.length == 1 && args[0].equals("man") || args[0].equals("--help")){
			
			helpMode = true;
			
			System.out.println("Lance le processus de pretty printing des fichiers .wh cibles.\n");
			
			System.out.println("> java -jar pretty.jar --src=[file-src]");
			System.out.println("\tCompile le fichier 'file-src' et genere sa version pretty printee dans le meme repertoire.\n");
			
			System.out.println("> java -jar pretty.jar --src=[file-src] --target=[target]");
			System.out.println("\tCompile le fichier 'file-src' et genere sa version pretty printee dans le dossier cible 'target'.\n");
			
			System.out.println("> java -jar pretty.jar --src=[folder-src]");
			System.out.println("\tCompile l'ensemble des fichiers .wh contenus dans le dossier 'folder-src' et les place dans le meme repertoire.\n");
			
			System.out.println("> java -jar pretty.jar --src=[folder-src] --target=[target]");
			System.out.println("\tCompile l'ensemble des fichiers .wh contenus dans le dossier 'folder-src' et les place dans le dossier 'target'.\n");
			
			System.out.println("> java -jar pretty.jar man | java -jar pretty.jar --help");
			System.out.println("\tAffiche les instructions d'utilisation de la commande et les differents arguments possibles.\n");
			
		} else {
			ArrayList<String> options = new ArrayList<String>(Arrays.asList(args));
			for ( String s : options ) {
				if ( s.split("=")[0].equalsIgnoreCase("--src")) {
					source = s.split("=")[1];
					if ( source.contains(".")) {
						repoMode = false;
					}
				} else if (s.split("=")[0].equalsIgnoreCase("--target")) {
					path = s.split("=")[1];
				} else {
					System.out.println("wrong usage, use --help or man to see available options.");
				}
			}
		}
		
		
		if(!helpMode){
			Injector injector = new ProjetStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
			Main main = injector.getInstance(Main.class);
			if (source.equals("")) {
				System.out.println("Generation failed, use --help or man.");
			} else {
				if ( repoMode) {
					File folder = new File(source);
					for (File f : folder.listFiles()) {
						System.out.println(f.getPath());
						main.runGenerator(f.getPath(), path+"/"+f.getName());
					}
				} else {
					main.runGenerator(source, path);
				}
			}
		}
	}

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	@Inject
	private GeneratorDelegate generator;

	@Inject 
	private JavaIoFileSystemAccess fileAccess;

	protected void runGenerator(String string, String path) {
		// Load the resource
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createFileURI(string), true);
		
		// Configure and start the generator
		System.out.println("File is being pretty printed in repository " + path);
		fileAccess.setOutputPath(path);
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		System.out.println(resource);
		System.out.println(fileAccess);
		System.out.println(context);
		generator.generate(resource, fileAccess, context);

		System.out.println("Pretty-printing finished.");
		
		// Start 3@ code generation
		System.out.println("3@ code is being generated");
		CodeGenerator gen = new CodeGenerator();
		gen.generate(resource);
		System.out.println("3@ code generation finished.\n");
		
		// generation JS
		System.out.println("JS code is being generated");
		JsGenerator jsGen = new JsGenerator(gen.getFuncTab());
		jsGen.translate();
		System.out.println("JS code generation finished.\n");
	}
}
