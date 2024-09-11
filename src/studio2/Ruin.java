package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("How much do you start with");
		double startAmount = in.nextDouble();
		System.out.println("What is your chance of winning? Give as decimal");
		double winChance = in.nextDouble();
		System.out.println("How much counts as success");
		double winLimit = in.nextDouble();
		System.out.println("How many days?");
		int totalSimulations = in.nextInt();
		
		if ((winChance == 0.5)) {
			double expectedRuinRate = 1 - ((startAmount) / winLimit);
			System.out.println("Ruin rate " + expectedRuinRate);
		} else {
			double poop = (1-winChance)/(winChance);
			double expectedRuinRate = (Math.pow(poop, startAmount) - Math.pow(poop, winLimit))/(1 - Math.pow(poop, winLimit));
			System.out.println("Ruin rate " + expectedRuinRate);
			
			
		}
		
		double ruin = 0;
		
		for (int i = 1; (i <= totalSimulations); i++) {
			double greeb = startAmount;
			System.out.println("Day " + i);
			int play = 0;
			while (greeb < winLimit) {
				double money = Math.random();
				
				if ((money < winChance) && (greeb >= 0)) {
					greeb++;
					play++;
					if (greeb == winLimit) {
						System.out.println("SUCCESS!");
						System.out.println(play + " plays");
					}
					
				} else if ((money >= winChance) && (greeb >= 0)) {
					greeb--;
					play++;
				} else {
					System.out.println("RUIN!");
					ruin++;
					System.out.println(play + " plays");
					greeb = winLimit + 1;
				}
			
			}
		}
		System.out.println(" Actual ruin rate " + (ruin/totalSimulations));
		

	}

}
