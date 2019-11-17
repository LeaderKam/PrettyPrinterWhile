package pretty.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import pretty.WhStandaloneSetup;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws ParseException, FileNotFoundException {

		final String syntax = "whpp <FILE>";
		
		List<Integer> params = new ArrayList<Integer>();
		WhGenerator.init(params);

		String outputFile = "";
		Injector injector = new WhStandaloneSetup().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);
		
		HelpFormatter formatter = new HelpFormatter();


		/* �tape 1 : D�finition des options. */
		Options options = new Options();
        Option outputOption = OptionBuilder.withArgName("FILE").hasArg().withDescription("Creates an output file with the name given has an argument.").withLongOpt("output").create('o');
        Option allOption = OptionBuilder.withArgName("INT").hasArg().withType(Integer.class).withDescription("Number of spaces chosen for the general indentation for blocks.").withLongOpt("allindent").create("all");
        Option ifOption = OptionBuilder.withArgName("INT").hasArg().withType(Integer.class).withDescription("Number of spaces chosen for the indentation of the if blocks.").withLongOpt("ifindent").create("if") ;
        Option whileOption = OptionBuilder.withArgName("INT").hasArg().withType(Integer.class).withDescription("Number of spaces chosen for the indentation of the while blocks.").withLongOpt("whileindent").create("while");
        Option helpOption = new Option("help", "Gives a detailed list of the options the user can use for the whc command.");
        Option forOption = OptionBuilder.withArgName("INT").hasArg().withType(Integer.class).withDescription("Number of spaces chosen for the indentation of the for blocks.").withLongOpt("forindent").create("for");
        Option foreachOption = OptionBuilder.withArgName("INT").hasArg().withType(Integer.class).withDescription("Number of spaces chosen for the indentation of the foreach blocks.").withLongOpt("forindent").create("foreach");
		/* On les ajoute � notre groupe d'options. */
		options.addOption(outputOption);
		options.addOption(allOption);
		options.addOption(ifOption);
		options.addOption(whileOption);
		options.addOption(helpOption);
		options.addOption(forOption);
		options.addOption(foreachOption);
		
		if(args.length == 0) {
			System.err.println("Missing file");
			formatter.printHelp(syntax, options, true);
		}

		/* �tape 2 : Analyse de la ligne de commande. */
		try {
			CommandLineParser parser = new GnuParser();
			CommandLine cmd = parser.parse(options, args);
			/* Etape 3: R�cup�ration et traitement des r�sultat. */
			if (cmd.hasOption("help")) {
				System.out.println("NAME\n\twhpp - pretty print a WHILE program\n");
				System.out.println("SYNOPSIS\n\twhpp file [options]\n");
				System.out.println("DESCRIPTION\n\tTransform a source file written in WHILE language into a pretty printed output.\n"
						+ "\tThe output is redirected to the standard output or to a file by using the -o option.\n"
						+ "\tYou can define indentations with -all option (for all blocks) or -<block> (for a specific block).\n");
				//options
				formatter.printHelp(syntax, options, true);
				System.out.println("\nAUTHORS\n\tWritten by Th�o MARIE, Nicolas BOURDIN, Corentin DUCHATELET, Marlon KUQI et Corentin LEFRANC");
				System.exit(1);
			} 
            if(cmd.hasOption("all")){
            	params.set(WhGenerator.INDENT_ALL, Integer.parseInt(cmd.getOptionValue("all", WhGenerator.DEFAULT_ALL.toString())));
            }
            if(cmd.hasOption("if")){
            	params.set(WhGenerator.INDENT_IF,Integer.parseInt(cmd.getOptionValue("if", WhGenerator.DEFAULT_IF.toString())));
            }
            if(cmd.hasOption("while")){
            	params.set(WhGenerator.INDENT_WHILE, Integer.parseInt(cmd.getOptionValue("while", WhGenerator.DEFAULT_WHILE.toString())));
            }
            if(cmd.hasOption("for")){
            	params.set(WhGenerator.INDENT_FOR, Integer.parseInt(cmd.getOptionValue("for", WhGenerator.DEFAULT_FOR.toString())));
            }
            if(cmd.hasOption("foreach")){
            	params.set(WhGenerator.INDENT_FOREACH, Integer.parseInt(cmd.getOptionValue("foreach", WhGenerator.DEFAULT_FOREACH.toString())));
            }
            if(cmd.hasOption("o")){
                outputFile = cmd.getOptionValue("o", "");    
            }
            if(!(new File(args[0]).exists())) {
            	System.err.println("Unreachable file");
            	formatter.printHelp(syntax, options, true);
            	System.exit(1);
            }
            main.runGenerator(args[0], outputFile, params);

		} catch (ParseException e) {
			System.err.println("Error while parsing the command line: " + e.getMessage());
			formatter.printHelp(syntax, options, true);
			System.exit(1);
		} catch (Exception e) {
			//e.printStackTrace();
		}

		
	}

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	@Inject
	private WhGenerator generator;

	@Inject
	private JavaIoFileSystemAccess fileAccess;

	protected void runGenerator(String input, String output, List<Integer> indentations) {
		// Load the resource
		System.out.println("parsing " + input + "...");
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createFileURI(input), true);

		// Validate the resource
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				System.err.println(issue);
			}
			return;
		}

		// Configure and start the generator
		fileAccess.setOutputPath("./");
		// System.out.println(URI.createFileURI(output).path());
		// fileAccess.setOutputPath(URI.createFileURI(output).path());
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		generator.doGenerate(resource, fileAccess, context, output, indentations);

		System.out.println("Pretty printing done");
	}
}