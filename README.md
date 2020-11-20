# MSA2pi
This is a simple software to calculate π value file from multiple sequence alignment fasta file.

# Install 

Make sure you have [JDK>=1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [ant](http://ant.apache.org/) installed on your computer.
````
git clone https://github.com/baoxingsong/MSA2pi.git
cd MSA2pi
ant
````
You will get MSA2pi.jar



# Usage
````
java -jar MSA2pi.jar -i inputFile [-r reference sequence name]

The input file should be in multiple fasta format and aligned with multiple sequence alignment application.

For DNA sequence, if your sequence used wide IUPAC code (https://www.bioinformatics.org/sms/iupac.html) 
and the reference sequence name is assigned in the parameter, 
those ambiguous letters could be changed to the reference letter at the same position. 
If the reference sequence name is no assigned, the ambiguous letters would be treated 
in the same way with INDEL (-).
````



## Motivation

Nucleotide diversity, π, was defined as, the average number of nucleotide differences per site between two sequences. And it is a widely used measure for sequence conservation.

As the accumulation of our knowledge, we find it is controversial to calculate π value for INDELs. Especially when there are INDELs with positive overlap with each other, since we do not know the evolution process, it is not convincing to take each INDEL as a single variant. If we take the INDEL as missing value, and divide the total number of variants by the total sequence length, there would be bias. Since sequence_length\*n\*(n-1)/2 times of comparison have not been performed. And I did not find available application with detailed document about how to deal with INDELs for π value calculation, I decide to write this simple application.

For n sequences with length l, 1<=i<=l, we calculate total number of pair-wised variants at position i. We have the allele frequency f<sub>a,i</sub> for the allele a and total number of accession with no INDEL at position i, m<sub>i</sub>. Then P<sub>i</sub>=sum(f<sub>a,i</sub>\*(m<sub>i</sub>-f<sub>a,i</sub>)/2), N<sub>i</sub>=m<sub>i</sub>*(m<sub>i</sub>-1)/2. And
P=sum(P<sub>i</sub>), N=sum(N<sub>i</sub>).

π=P/N


