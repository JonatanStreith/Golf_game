package jonst;

import java.text.MessageFormat;

public class Input {

    private double angle;
    private double power;
    private final double ballWeight = 0.04593;
    private double angleInRadians;
    private double velocity;
    private double distance;

    public Input() {

        System.out.println("Choose angle and force of swing.");
        angle = App.askUserForDouble("Angle? "); //Check for wrong input handling
        power = App.askUserForDouble("Power? ");

        calculateDistance();
        printOutcome();
    }


    public Input(double angle, double power){
        this.angle = angle;
        this.power = power;

        calculateDistance();
        printOutcome();
    }


    public void printOutcome(){
        System.out.println("You send the ball flying " + MessageFormat.format("{0,number,#.##}", distance) + " meters towards the hole!");
    }


    public void calculateDistance(){
        angleInRadians = (Math.PI / 180) * (angle);
        velocity = Math.sqrt(power * 2 / ballWeight);

        distance = Math.pow(velocity, 2) / 9.8 * Math.sin(2 * angleInRadians);
    }


    public double getAngle() {
        return angle;
    }

    public double getPower() {
        return power;
    }

    public double getBallWeight() {
        return ballWeight;
    }

    public double getAngleInRadians() {
        return angleInRadians;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getDistance() {
        return distance;
    }
}
