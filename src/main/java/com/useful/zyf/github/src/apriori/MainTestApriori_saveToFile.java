package com.useful.zyf.github.src.apriori;

import java.io.IOException;

/**
 * Example of how to use APRIORI algorithm from the source code.
 * @author Philippe Fournier-Viger (Copyright 2008)
 */
public class MainTestApriori_saveToFile {

	public void computeApriori() throws IOException{

		String input = "src/github/output/githubfilenameresult.txt";;
		String output = "src/github/output/githuboutput.txt";  // the path for saving the frequent itemsets found


		
		double minsup = 0.0003; // means a minsup of 2 transaction (we used a relative support)
		
		// Applying the Apriori algorithm
		AlgoApriori algo = new AlgoApriori();
		
		// Uncomment the following line to set the maximum pattern length (number of items per itemset)
		algo.setMaximumPatternLength(2);

		algo.runAlgorithm(minsup, input, output);
		algo.printStats();

//		AlgoApriori algo_committername = new AlgoApriori();
//		algo_committername.setMaximumPatternLength(2);
//
//		algo_committername.runAlgorithm(minsup, input_committername, output_committername);
//		algo_committername.printStats();
	}

}
