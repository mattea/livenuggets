/**
 * Active Learning loop for Nuggets Procedure
 */
package edu.neu.ccs.mlir.nuggets;
import org.apache.commons.cli.*;

/**
 * @author mattea
 *
 */
public class ActiveLearning {
	String queryid, querytext;
	Config config;
	
	ActiveLearning(String queryid, String querytext, String paramfile) {
		this.queryid = queryid;
		this.querytext = querytext;
		this.config = new Config(paramfile);
	}
	
	public void run() {
		// Set up SIGNAL Handling
	}

	/**
	 * @param args Requires a queryid, querytext (quoted) and query class
	 */
	public static void main(String[] args) {
		String paramfile = "../parameter-files/parameters-live.txt";
		CommandLineParser parser = new BasicParser();
		Options options = new Options();
		HelpFormatter formatter = new HelpFormatter();
		
		options.addOption("h", "help", false, "print this message" );
		options.addOption("V", "version", false, "print the version information and exit" );
		options.addOption("q", "quiet", false, "be extra quiet" );
		options.addOption("v", "verbose", false, "be extra verbose" );
		options.addOption("d", "debug", false, "print debugging information" );
		options.addOption("p", "parameters-file", true, "path to parameters file" );
		
		try {
			CommandLine line = parser.parse(options, args);
			args = line.getArgs();
			if (line.hasOption( "parameters-file" )) {
				paramfile = line.getOptionValue( "parameters-file" );
			} else if (args.length > 2) {
				paramfile = "../parameter-files/parameters-" + args[2] + ".txt";
			}
			if (args.length < 2) {
				formatter.printHelp( "active_learning", options, true );
			}
		}
		catch ( ParseException exp ) {
			System.out.println( "Unexpected exception:" + exp.getMessage() );
			formatter.printHelp( "active_learning", options, true );
		}
		
		String queryid = args[0];
		String querytext = args[1];
		ActiveLearning al = new ActiveLearning(queryid, querytext, paramfile);
		al.run();
	}

}
