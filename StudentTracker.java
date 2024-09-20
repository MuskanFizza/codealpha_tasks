package tasks;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTracker {

	Scanner sc = new Scanner(System.in);
	ArrayList<Double> score = new ArrayList<Double>();
	

	public void menu() {
		System.out.println("\n\t ----STUDENT GRADE TRACKER----");
		System.out.println("\nChoose an option");
		System.out.println("1. Enter score. ");
		System.out.println("2. Compute result. ");
		System.out.println("3. Exit Program");
		System.out.print("Enter your choice: ");

	}

	public void run() {
		int op;
		do {
			menu();
			op = sc.nextInt();

			if (op == 1)
				score();
			if (op == 2)
				result();
			if (op == 3)
				System.out.println("\n\t\tExiting Program... \n\tThankyou for using this service! :) ");
		} while (op != 3);
	}

	public void score() {
		double marks;
		do {
			System.out.println("\nEnter negative digit to exit. ");

		System.out.println("Enter your score: ");
		marks = sc.nextDouble();
		if (marks<0)
			return;
		if (marks >=0 && marks <=100)
		score.add(marks);
		else if (marks>100) 
			System.out.println("Invalid Marks! Score cannot exceed 100. ");
		
		
		 if (marks >= 95 && marks <= 100)
			System.out.println("Grade A+ ");
		else if (marks < 95 && marks >= 90)
			System.out.println("Grade A ");
		else if (marks < 90 && marks >= 85)
			System.out.println("Grade A- ");
		else if (marks < 85 && marks >= 80)
			System.out.println("Grade B+ ");
		else if (marks < 80 && marks >= 75)
			System.out.println("Grade B ");
		else if (marks < 75 && marks >= 70)
			System.out.println("Grade B- ");
		else if (marks < 70 && marks >= 65)
			System.out.println("Grade C+ ");
		else if (marks < 65 && marks >= 60)
			System.out.println("Grade C ");
		else if (marks < 60 && marks >= 55)
			System.out.println("Grade C- ");
		else if (marks < 55 && marks >= 50)
			System.out.println("Grade D+ ");
		else if (marks < 50 && marks >= 45)
			System.out.println("Grade D ");
		else if (marks < 45 && marks >= 40)
			System.out.println("Grade D- ");
		else if (marks < 40)
			System.out.println("Garde F ");
		
		}while(marks<101);
		
}
	
	public void result() {
		System.out.println();
		if (score.isEmpty()) {
			System.out.println("No scores have been entered yet. ");
			return;
		}
		double sum = 0;
		double lowest = score.get(0);
		double highest = score.get(0);
		System.out.println("Marks entered: ");

		for (double marks : score) {
			sum += marks;
			System.out.println(marks);
			if (marks > highest)
				highest = marks;
			if (marks < lowest)
				lowest = marks;

		}

		double average = sum / score.size();

		System.out.println("Average score: " + average);
		System.out.println("Highest score: " + highest);
		System.out.println("Lowest score: " + lowest);

	}

	public static void main(String args[]) {
		
		StudentTracker st = new StudentTracker();
		st.run();

	}

}
