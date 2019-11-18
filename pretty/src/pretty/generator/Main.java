/*
 * generated by Xtext 2.19.0
 */
package pretty.generator;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import pretty.WhStandaloneSetup;

public class Main {

	public static String FICHIER_NON_TROUVE = "Fichier non trouve";
	public static String FICHIER_MANQUANT = "Fichier manquant";
	public static String ERREUR_COMMANDE = "Erreur en executant la commande";
	public static String FILE_DEFAULT="test.wh";
	static final String syntax = "ppWh ou java -jar <FILE>";
	public static HelpFormatter formatter;

	/*public static class Fenetres extends JFrame implements ActionListener {
		private JPanel pan = new JPanel();
		private JButton bouton = new JButton("Mon bouton");
		private JButton help = new JButton("HELP");
		private JTextField file = new JTextField(1);
		private JTextArea textZone = new JTextArea(20, 30);

		JButton ouvrir;

		JFileChooser chooser;
		String choosertitle;

		public Fenetres() {
			ouvrir = new JButton("Ouvrir Fichier While");
			help.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						// open input stream test.txt for reading purpose.
						BufferedReader br = new BufferedReader(new FileReader("test.txt"));
						String thisLine;
						while ((thisLine = br.readLine()) != null) {
							
							textZone.setText(thisLine);;
						}
						
						br.close();
					} catch (Exception ev) {
						ev.printStackTrace();
					}
					
				}
			});
			
			
			ouvrir.addActionListener(this);
			
			this.setTitle("Animation");
			this.setSize(500, 250);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			// Ajout du bouton � notre content pane
			pan.add(bouton);
			pan.add(ouvrir);
			pan.add(file);
			pan.add(help);
			pan.add(textZone);

			this.setContentPane(pan);
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int result;

			chooser = new JFileChooser();
			chooser.setCurrentDirectory(new java.io.File("."));
			chooser.setDialogTitle(choosertitle);
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			//
			// disable the "All files" option.
			//
			chooser.setAcceptAllFileFilterUsed(false);
			//
			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
				System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
				file.setText(chooser.getSelectedFile()+"");
			} else {
				System.out.println("No Selection ");
			}

		}

	}*/

	public static void main(String[] args) {

		List<Integer> params = new ArrayList<Integer>();
		WhGenerator.init(params);

		formatter = new HelpFormatter();

		/* �tape 1 : D�finition des options. */
		Options options = helpOption();
		//Fenetres fenettre = new Fenetres();
		if (args.length == 0) {
			helpShow(FICHIER_NON_TROUVE, options);
		}

		/* �tape 2 : Analyse de la ligne de commande. */
		analyseCommande(options, args);
	}

	@SuppressWarnings("static-access")
	public static Options helpOption() {

		Options options = new Options();
		@SuppressWarnings("static-access")
		Option outputOption = OptionBuilder.withArgName("FILE").hasArg()
				.withDescription("Cree un fichier en sortie avec le nom donne en argument.").withLongOpt("output")
				.create('o');
		Option allOption = OptionBuilder.withArgName("INT").hasArg().withType(Integer.class)
				.withDescription("Nombre d'espace choisi pour l'indentation generale des blocs.")
				.withLongOpt("allindent").create("all");
		Option ifOption = OptionBuilder.withArgName("INT").hasArg().withType(Integer.class)
				.withDescription("Nombre d'espace choisi pour l'indentation des blocs if.").withLongOpt("ifindent")
				.create("if");
		Option whileOption = OptionBuilder.withArgName("INT").hasArg().withType(Integer.class)
				.withDescription("Nombre d'espace choisi pour l'indentation des blocs while.")
				.withLongOpt("whileindent").create("while");
		Option helpOption = new Option("help", "Donne une liste d'option que l'utilisateur peut utiliser en argument.");
		Option forOption = OptionBuilder.withArgName("INT").hasArg().withType(Integer.class)
				.withDescription("Nombre d'espace choisi pour l'indentation des blocs for.").withLongOpt("forindent")
				.create("for");
		Option foreachOption = OptionBuilder.withArgName("INT").hasArg().withType(Integer.class)
				.withDescription("Nombre d'espace choisi pour l'indentation des blocs foreach.")
				.withLongOpt("forindent").create("foreach");
		/* On les ajoute � notre groupe d'options. */
		options.addOption(outputOption);
		options.addOption(allOption);
		options.addOption(ifOption);
		options.addOption(whileOption);
		options.addOption(helpOption);
		options.addOption(forOption);
		options.addOption(foreachOption);
		return options;
	}

	public static void helpShow(String erreur, Options options) {
		System.err.println(erreur);
		formatter.printHelp(syntax, options, true);
	}

	public static void analyseCommande(Options options, String[] args) {
		List<Integer> params = new ArrayList<Integer>();
		WhGenerator.init(params);

		Injector injector = new WhStandaloneSetup().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);

		try {
			CommandLineParser parser = new GnuParser();
			CommandLine cmd = parser.parse(options, args);
			/* Etape 3: R�cup�ration et traitement des r�sultat. */
			if (cmd.hasOption("help")) {
				System.out.println("NAME\n\tppWh - pretty print un programme WHILE\n");
				System.out.println("SYNOPSIS\n\tppWh fichier [options]\n");
				System.out.println(
						"DESCRIPTION\n\tTransforme un fichier source ecris dans le langage WHILE en sortie bien formatte(pretty print).\n"
								+ "\tLa sortie est soit la sortie standard soit un fichier en utilisant l'option -o.\n"
								+ "\tVous pouvez definit l'indentation avec l'option -all (pour tous les blocs) ou -<bloc> (pour un bloc specifiquqe).\n");
				// options
				formatter.printHelp(syntax, options, true);
				System.out.println("\nAUTEURS\n\tEcris par Sie Vincent KAM, Marius KATOU, Achraff JAFFAR, Lou Anna VI");
				System.exit(1);
			}
			if (cmd.hasOption("all")) {
				params.set(WhGenerator.INDENT_ALL,
						Integer.parseInt(cmd.getOptionValue("all", WhGenerator.DEFAULT_ALL.toString())));
			}
			if (cmd.hasOption("if")) {
				params.set(WhGenerator.INDENT_IF,
						Integer.parseInt(cmd.getOptionValue("if", WhGenerator.DEFAULT_IF.toString())));
			}
			if (cmd.hasOption("while")) {
				params.set(WhGenerator.INDENT_WHILE,
						Integer.parseInt(cmd.getOptionValue("while", WhGenerator.DEFAULT_WHILE.toString())));
			}
			if (cmd.hasOption("for")) {
				params.set(WhGenerator.INDENT_FOR,
						Integer.parseInt(cmd.getOptionValue("for", WhGenerator.DEFAULT_FOR.toString())));
			}
			if (cmd.hasOption("foreach")) {
				params.set(WhGenerator.INDENT_FOREACH,
						Integer.parseInt(cmd.getOptionValue("foreach", WhGenerator.DEFAULT_FOREACH.toString())));
			}
			String outputFile = "";
			if (cmd.hasOption("o")) {
				outputFile = cmd.getOptionValue("o", "");
			}
			if (!(new File(args[0]).exists())) {
				helpShow(FICHIER_NON_TROUVE, options);
				System.exit(1);
			}
			main.runGenerator(args[0], outputFile, params);

		} catch (ParseException e) {
			helpShow(ERREUR_COMMANDE + e.getMessage(), options);
			formatter.printHelp(syntax, options, true);
			System.exit(1);
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	// @Inject
	// private GeneratorDelegate generator;

	@Inject
	private WhGenerator generator;
	@Inject
	private JavaIoFileSystemAccess fileAccess;

	protected void runGenerator(String input, String output, List<Integer> indentations) {
		// Load the resource
		System.out.println("Lecture " + input + "...");
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
		// fileAccess.setOutputPath("src-gen/");
		fileAccess.setOutputPath("./");
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		// generator.generate(resource, fileAccess, context);
		generator.doGenerate(resource, fileAccess, context, output, indentations);

		System.out.println("Code generation finished.");
	}
}
