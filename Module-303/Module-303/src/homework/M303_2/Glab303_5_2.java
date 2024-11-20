package homework.M303_2;

import java.util.Scanner;

public class Glab303_5_2 {
    public static void main(String[] args) {
        int num = (int)(Math.random()*101);
        int guess = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess a number between 0 and 100");
        while(num!= guess){
            System.out.println("Enter your guess");
            guess = scanner.nextInt();
            if(guess == num){
                System.out.println("Congratulations! You guessed it!");
            }
            else if (guess > num) {
                System.out.println("Your number is too big");
            }
            else{
                System.out.println("Your guess is too small");
            }
        }
        System.out.println("================================================================");
        final int NUMBER_OF_QUESTIONS = 5;
        int count = 0;
        int correctCount = 0;
        String output = "";
        boolean nextRound = false;
        String answer = "";
        while(!nextRound) {
            while (count < NUMBER_OF_QUESTIONS) {
                int num1 = (int) (Math.random() * 10);
                int num2 = (int) (Math.random() * 10);
                if (num1 < num2) {
                    int temp = num1;
                    num1 = num2;
                    num2 = temp;
                }
                System.out.println("What is " + num1 + " - " + num2);
                int ans = scanner.nextInt();
                if (num1 - num2 == ans) {
                    System.out.println("You are correct");
                    correctCount++;
                } else {
                    System.out.println("You are not correct." + num1 + " - " + num2 + " = " + (num1 - num2));
                }
                count++;

            }
            System.out.println(correctCount + " out of 5 answers are correct");
            System.out.println("Do you want to play the game again(Yes/No)");
            answer = scanner.next();
            if (answer.equalsIgnoreCase("Yes")) {
                count = 0;
                correctCount = 0;
            }
            if (answer.equalsIgnoreCase("no")) {
                nextRound = true;
            }


        }

        System.out.println("================================================================");
        int sum=0;
        System.out.println("Enter an int value(The program exits if the input is zero)");
        int data = scanner.nextInt();
        while(data != 0){
            sum += data;
            System.out.print("Enter an int value(The program exits if the input is zero)");
            data = scanner.nextInt();
        }
        System.out.println("The sum is: "+sum);
    }
}
