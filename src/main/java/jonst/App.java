package jonst;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Scanner;


public class App {

    public static Scanner inputReader;

    public static void main(String[] args) {

        inputReader = new Scanner(System.in);
        boolean newGame = true;


        System.out.println("Welcome to 'Swing to Win'! \nThe game where you win... by swinging!");

        do {

            switch (askUserFor("Do you want to play? (y/n) [n] ").toLowerCase()) {
                case "y": {
                    newGame = true;
                    Game game = new Game();


                    System.out.println("You completed a " + MessageFormat.format("{0,number,#.##}", game.getCourseLength()) + " meter hole in " + game.getNumberOfSwings() + " swings!");

                    printLog(game.getGolfLog());

                    break;
                }
                default: {

                    newGame = false;
                    break;
                }


            }



        }while (newGame) ;


        System.out.println("Thanks for playing!");

        inputReader.close();
    }

    public static void printLog(double[] log){
        System.out.println("Each swing's distance: ");
        for (int i = 0; i < log.length; i++) {
            System.out.print("Swing " + (i+1) + ": ");
            System.out.println(MessageFormat.format("{0,number,#.##}", log[i]) + " meters.");
        }

    }


    static String askUserFor(String term) {     //Multi-use method for getting strings
        System.out.print(term);
        return inputReader.nextLine();
    }


    static double askUserForDouble(String term) {     //Multi-use method for getting strings

        double input = 0;
        boolean legitimateValue;

        do {
            System.out.print(term);
            legitimateValue = true;
            try {
                input = Double.parseDouble(inputReader.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Sorry, numbers only.");
                legitimateValue = false;
            }
        } while(!legitimateValue);

        return input;
    }



}


