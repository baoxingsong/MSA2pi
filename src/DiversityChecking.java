import java.util.HashMap;

import me.songbx.service.ChromoSomeReadService;


/**
 * @author song
 * @version 1.0, 2018-09-15
 */


public class DiversityChecking {

		
	public static void calPi( ChromoSomeReadService chromoSomeReadService, String refSeqName){
		double pi = 0.0;
		double capitalePi = 0.0;//so here is not the real PI value, since sequences have different lengths, since INDEL
		double validatedLength=0.0;
		
		for(int i=0; i < chromoSomeReadService.getChromoSomeById(chromoSomeReadService.getChromoSomeHashMap().keySet().toArray()[0].toString()).getSequence().length(); i++){
			HashMap<Character, Integer> narNumber = new HashMap<Character, Integer>();
			for(String seqName : chromoSomeReadService.getChromoSomeHashMap().keySet()){
				Character currentNar = chromoSomeReadService.getChromoSomeHashMap().get(seqName).getSequence().charAt(i);
				if(currentNar=='U'){
					currentNar='T';
				}
				if( currentNar=='A' || currentNar=='T' || currentNar=='C' || currentNar=='G' || currentNar=='-'  ){
					
				}else if ( chromoSomeReadService.getChromoSomeHashMap().containsKey(refSeqName) ){
					currentNar = chromoSomeReadService.getChromoSomeById(refSeqName).getSequence().charAt(i);
				}else {
					currentNar = '-';
				}
				if( currentNar != '-' ) {
					if(narNumber.containsKey(currentNar)){
						narNumber.put(currentNar, narNumber.get(currentNar)+1);
					}else{
						narNumber.put(currentNar, 1);
					}
				}
			}
			int sequenceNumber = 0;
			for(Character key : narNumber.keySet()){
				int value = narNumber.get(key);
				sequenceNumber += value;
			}
			validatedLength += (sequenceNumber*sequenceNumber-sequenceNumber)/2;
			double increase=0.0;				
			for(Character key : narNumber.keySet()){
				int value = narNumber.get(key);
				increase+=(double)value*(sequenceNumber-(double)value)/2;
			}
			capitalePi += increase;
			narNumber = new HashMap<Character, Integer>();
		}
		pi=capitalePi/validatedLength;
		System.out.println(pi);
	}
	
	public static void calPi( ChromoSomeReadService chromoSomeReadService){
		double pi = 0.0;
		double capitalePi = 0.0;//so here is not the real PI value, since sequences have different lengths, since INDEL
		double validatedLength=0.0;
		
		for(int i=0; i < chromoSomeReadService.getChromoSomeById(chromoSomeReadService.getChromoSomeHashMap().keySet().toArray()[0].toString()).getSequence().length(); i++){
			HashMap<Character, Integer> narNumber = new HashMap<Character, Integer>();
			for(String seqName : chromoSomeReadService.getChromoSomeHashMap().keySet()){
				Character currentNar = chromoSomeReadService.getChromoSomeHashMap().get(seqName).getSequence().charAt(i);
				if(currentNar=='U'){
					currentNar='T';
				}
				if( currentNar=='A' || currentNar=='T' || currentNar=='C' || currentNar=='G' || currentNar=='-'  ){
					
				}else {
					currentNar = '-';
				}
				if( currentNar != '-' ) {
					if(narNumber.containsKey(currentNar)){
						narNumber.put(currentNar, narNumber.get(currentNar)+1);
					}else{
						narNumber.put(currentNar, 1);
					}
				}
			}
			int sequenceNumber = 0;
			for(Character key : narNumber.keySet()){
				int value = narNumber.get(key);
				sequenceNumber += value;
			}
			validatedLength += (sequenceNumber*sequenceNumber-sequenceNumber)/2;
			double increase=0.0;				
			for(Character key : narNumber.keySet()){
				int value = narNumber.get(key);
				increase+=(double)value*(sequenceNumber-(double)value)/2;
			}
			capitalePi += increase;
			narNumber = new HashMap<Character, Integer>();
		}
		pi=capitalePi/validatedLength;
		System.out.println(pi);
	}
	
	public static void calProteinPi( ChromoSomeReadService chromoSomeReadService){
		double pi = 0.0;
		double capitalePi = 0.0;//so here is not the real PI value, since sequences have different lengths, since INDEL
		double validatedLength=0.0;
		
		for(int i=0; i < chromoSomeReadService.getChromoSomeById(chromoSomeReadService.getChromoSomeHashMap().keySet().toArray()[0].toString()).getSequence().length(); i++){
			HashMap<Character, Integer> narNumber = new HashMap<Character, Integer>();
			for(String seqName : chromoSomeReadService.getChromoSomeHashMap().keySet()){
				Character currentNar = chromoSomeReadService.getChromoSomeHashMap().get(seqName).getSequence().charAt(i);
				if( currentNar != '-' ) {
					if(narNumber.containsKey(currentNar)){
						narNumber.put(currentNar, narNumber.get(currentNar)+1);
					}else{
						narNumber.put(currentNar, 1);
					}
				}
			}
			int sequenceNumber = 0;
			for(Character key : narNumber.keySet()){
				int value = narNumber.get(key);
				sequenceNumber += value;
			}
			validatedLength += (sequenceNumber*sequenceNumber-sequenceNumber)/2;
			double increase=0.0;				
			for(Character key : narNumber.keySet()){
				int value = narNumber.get(key);
				increase+=(double)value*(sequenceNumber-(double)value)/2;
			}
			capitalePi += increase;
			narNumber = new HashMap<Character, Integer>();
		}
		pi=capitalePi/validatedLength;
		System.out.println(pi);
	}
}
