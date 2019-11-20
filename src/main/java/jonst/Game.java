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
            adjustDistance();
            checkIfReachedHole();
        }

    }

    public void adjustDistance() {
        distanceRemaining -= swing(); //Take a swing, move along
        if (distanceRemaining < 0)  //If you overshoot, you have to go back - negative distance becomes positive
            distanceRemaining *= -1;
        numberOfSwings++;
    }

    public void checkIfReachedHole() {
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


    public double randomCourseLength() {
        //5000 - 7200 meters
        return 5000 + (Math.random() * 2200);

    }

    public double swing() {

        Input input = new Input();

        logDistance(input.getDistance());


        return input.getDistance();
    }

    public void logDistance(double distance) {
        golfLog = Arrays.copyOf(golfLog, golfLog.length + 1);

        golfLog[golfLog.length - 1] = distance;
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
