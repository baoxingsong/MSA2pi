import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import me.songbx.service.ChromoSomeReadService;


/**
 * @author song
 * @version 1.0, 2018-09-20
 */

public class Msa2pi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Options options = new Options();
		options.addOption("i",true,"inputfile");
        options.addOption("r",true,"reference");
        CommandLineParser parser = new PosixParser();
        CommandLine cmd=null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
             // TODO Auto-generated catch block
            System.out.println("Check the input parameter please, Or you can contact songbaoxing168@163.com for help!");
            e.printStackTrace();
            System.exit(1);
        }
        
        StringBuffer helpMessage=new StringBuffer("caculate pi value file from multiple sequence alignment fasta file\nArguments:\n");
        helpMessage.append("\t-i inputfile, The path of the input file in fasta format.\n");
        helpMessage.append("\t-r reference sequence name [optional]\n"); 
        helpMessage.append("\t-h show this message");
        helpMessage.append("if reference is avaliable, all the IUPAC code other than A,T,U,C,G,- could be changed to the reference allele\n");
        helpMessage.append("if reference is not avaliable, all the IUPAC code other than A,T,U,C,G,- could be changed to '-'\n");
        
        
        if(cmd.hasOption("h") || cmd.hasOption("H") || cmd.hasOption("Help") || cmd.hasOption("HELP") || cmd.hasOption("help")){
                System.out.println(helpMessage);
                System.exit(0);
        }
        if(!cmd.hasOption("i") ){
            System.out.println("Error parameter!!!\n"+helpMessage);
            System.exit(1);
        }
        String inputFile = cmd.getOptionValue("i");
        ChromoSomeReadService chromoSomeReadService = new ChromoSomeReadService(inputFile);
        if(cmd.hasOption("r") ){
        	String reference = cmd.getOptionValue("r");
        	DiversityChecking.calPi(  chromoSomeReadService, reference);
        }else {
        	DiversityChecking.calPi(  chromoSomeReadService);
        }
	}
}
