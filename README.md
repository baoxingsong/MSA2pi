# MSA2pi
This is a simple software to calculate π value file from multiple sequence alignment fasta file.

# Install 

Make sure you have [JDK>=1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [ant](http://ant.apache.org/) installed on your computer.
````
git clone https://github.com/baoxingsong/MSA2pi.git
cd MSA2pi
ant
````
You will get MSA2pi.jar under folder `dist`



# Usage
````
java -jar MSA2pi.jar -i inputFile [-r reference sequence name]

The input file should be in multiple fasta format and aligned with multiple sequnce alignment application.

If your sequence used wide IUPAC code (https://www.bioinformatics.org/sms/iupac.html) and the reference sequence name is assighed in the parameter, those ambiguous letters could be changed to the reference letter at the same positon. If the reference sequence name is no assighed, the ambiguous letters would be treated in the same way with INDEL (-).
````



## Motivation

Nucleotide diversity, $\pi$ was defined as, the average number of nucleotide differences per site between two sequences. And it is a widely used measure for sequence conservation.

As the accumulation of our knowledge, we find it is controversial to calculate π value for INDELs. If there are INDELs with positive overlap with each other, since we do not know the evolution process, it is not convincing to take each INDEL as a single variant. If we take the INDEL as missing value, and divide the total number of variants by the total sequence length, there would be bias. Since $\frac {length\times n \times (n-1)}{2}​$ times of comparison have not been performed. And I did not find detailed document about how to deal with INDELs for $\pi​$ value calculation, I decide to write this simple.

For the comparison of a pair of sequences, sequence i and sequence j (j>i), MSA2 calculates two values, 1) the number of base pairs without missing value for both sequences; 2) the number of SNPs. And I defined a temporary value P as (the number of SNPs)/(the number of base pairs without missing value for both sequences). For n sequences  $\pi=\sum \frac{P_{i,j}}{\frac{n*(n-1)}{2}}$.

