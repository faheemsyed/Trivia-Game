/*Developed by: Faheem Syed and Marianna Sullivan
 * 
 * The Content class uses a csv file.
 * The csv file is arranged in this order:
 * 			First column is questions
 * 			Second column is correct answers
 * 			Third, fourth and fifth columns 
 * 			are incorrect answers
 * The questions and answers are both stored in an array.
 * The correct answers are stored in 0 to qSize (amount of questions) 
 * with the incorrect ones being in the rest of the array.
 */

package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Content {
	private static String[] questions;
	private static String[] answers;
	
	//Questions used.
	private boolean[] used;
	
	//Current questions answer set.
	private boolean[] usedAns;
	
	private int correct;
	private String[] set;
	public static int qSize = 57;
	public int aSize = qSize*4;
	Randomizer rand;
	private int num;
	
	/*
	 * Initializes questions, answers,
	 * used, set, usedAns, rand and calls 
	 * readFile()
	 */
	public Content(){
		questions = new String[qSize];
		answers = new String[aSize];
		used = new boolean[qSize];
		set = new String[5];
		usedAns = new boolean[4];
		for (int i = 0; i < 4; i++){
			usedAns[i] = false;
		}
		for (int i = 0; i < qSize; i++){
			used[i] = false;
		}
		rand = new Randomizer();
		readFile();
	}
	
	
	/*
	 * Gets a random question and answer.
	 * Stores the answers in a random order
	 * with the correct answer in "correct"
	 */
	public String[] getQA(){
		num = rand.generateInt(0, qSize);
		if (used[num] == false){
			used[num] = true;
			set[0] = questions[num];
			
			/*
			 * for loop to store answers
			 * in random order.
			 */
			int g;
			for (int c = 1; c < 5; c++){
				g = generateAns();
				if (g == 0){
					set[c] = answers[num];
					correct = c;
				}
				else if (g == 1){
					set[c] = answers[num + qSize];
				}
				else if (g == 2){
					set[c] = answers[num + qSize*2];
				}
				else {
					set[c] = answers[num + qSize*3];
				}
			}
			for (int i = 0; i < 4; i++){
				usedAns[i] = false;
			}
			return set;
		}
		else {
			getQA();
		}
		return null;
	}
	
	
	/*
	 * Generatres a random number,
	 * checks to see if an answer
	 * is already stored in that
	 * position of the array
	 */
	private int generateAns(){
		int i;
		i = rand.generateInt(0, 4);
		if (usedAns[i] == false){
			usedAns[i] = true;
			return i;
		}
		return generateAns();
	}
	
	
	public boolean checkAns(int k){
		return (k == correct);
	}
	
	public int getAns(){
		return correct;
	}
	
	/*
	 * Reads in csv file using a Scanner
	 * and stores the data in an array. 
	 */
	public void readFile(){
		int i = 0;
		String fileName = "data.csv";
		File file = new File(fileName);
		try{
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()){
				String data = inputStream.nextLine();
				String[] values = data.split(",");
				//System.out.println(values[0]);
				questions[i] = values[0];
				answers[i] = values[1];
				answers[i+ qSize] = values[2];
				answers[i+ qSize*2] = values[3];
				answers[i+ qSize*3] = values[4];
				i++;
			}
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Content c = new Content();
		System.out.println(c.getQA());
	}
	
}
