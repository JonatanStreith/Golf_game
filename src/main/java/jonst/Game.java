package jonst;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private double courseLength;
    private double distanceRemaining;
    private int numberOfSwings;
    private boolean reachedHole = false;
    private double tolerance = 0.1;

    private double[] golfLog;

    public Game() {

        courseLength = randomCourseLength();
        distanceRemaining = courseLength;
        numberOfSwings = 0;

        golfLog = new double[0];


        System.out.println("Today's course is " + MessageFormat.format("{0,number,#.##}", courseLength) + " meters!");

        while (!reachedHole) {

            distanceRemaining -= swing(); //Take a swing, move along
            if (distanceRemaining < 0)  //If you overshoot, you have to go back - negative distance becomes positive
                distanceRemaining *= -1;

            numberOfSwings++;

            if (distanceRemaining <= tolerance) {
                reachedHole = true;

                if (numberOfSwings == 1)
                    System.out.println("Hole in one!");
                else
                    System.out.println("The ball is in the hole!");
            } else {
                System.out.println("Distance remaining: " + MessageFormat.format("{0,number,#.##}", distanceRemaining) + " meters.");
            }
            System.out.println("\n");

        }

    }


    public double randomCourseLength() {
        //5000 - 7200 meters
        return 5000 + (Math.random() * 2200);

    }

    public double swing() {
        System.out.println("Choose angle and force of swing.");
        double angle = Double.parseDouble(App.askUserFor("Angle?")); //Check for wrong input handling
        double power = Double.parseDouble(App.askUserFor("Power?"));

        final double ballWeight = 0.04593;
        double angleInRadians = (Math.PI / 180) * (angle);
        double velocity = Math.sqrt(power * 2 / ballWeight);

        double distance = Math.pow(velocity, 2) / 9.8 * Math.sin(2 * angleInRadians);

        System.out.println("You send the ball flying " + MessageFormat.format("{0,number,#.##}", distance) + " meters towards the hole!");


        logDistance(distance);


        return distance;
    }

    public void logDistance(double distance){
        golfLog = Arrays.copyOf(golfLog, golfLog.length +1);

        golfLog[golfLog.length-1] = distance;
    }


    public double getCourseLength() {
        return courseLength;
    }

    public int getNumberOfSwings() {
        return numberOfSwings;
    }

    public double[] getGolfLog() {
        return golfLog;
    }
}
