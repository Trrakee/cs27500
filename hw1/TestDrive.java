/*****************************************************************************
 * The <CODE>TestDrive</CODE> Java application simulates a car being driven
 * depending on its provided fuel efficiency and fuel amount.
 *
 * @author Adam Joseph Cook
 *     <A HREF="mailto:cook5@purduecal.edu"> (cook5@purduecal.edu) </A>
 *****************************************************************************/

import java.util.Scanner;

public class TestDrive
{
    public static void main( String[] args ) {

        Scanner sc = new Scanner(System.in);
        Car car;

        boolean mainDone = false;
        while (!mainDone) {
            System.out.println("Please enter the fuel efficiency rating of the " +
                    "car (in miles/gallon). To exit the application, " +
                    "please enter zero.");
            System.out.print("Fuel efficiency: ");
            double fuelEfficiency = sc.nextDouble();
            car = new Car(fuelEfficiency);

            if (fuelEfficiency == 0) {
                // The user entered a fuel efficiency of zero, so terminate the
                // program.
                System.exit(0);
            }

            boolean outerDone = false;
            while (!outerDone) {
                System.out.println("Please enter the amount of fuel to add " +
                        "(in gallons). To re-enter the fuel efficiency of the " +
                        "car, please enter zero.");
                System.out.print("Fuel amount to add: ");
                double fuelAmountToAdd = sc.nextDouble();

                if (fuelAmountToAdd == 0) {
                    // The user entered a zero value for the fuel to add, so
                    // terminate this outer loop.
                    outerDone = true;
                } else {
                    // Add provided fuel to the car.
                    car.addFuel(fuelAmountToAdd);

                    boolean innerDone = false;
                    while (!innerDone) {
                        System.out.println("Please enter the travel distance to " +
                                "simulate (in miles). To add some fuel to " +
                                "the car, please enter zero.");
                        System.out.print("Distance to travel: ");
                        double distanceToTravel = sc.nextDouble();

                        if (distanceToTravel == 0) {
                            // The user entered a zero distance to travel, so
                            // terminate this inner loop.
                            innerDone = true;
                        } else {
                            // Attempt to travel the distance provided with the
                            // car.
                            double distanceTraveled = car.drive(distanceToTravel);
                            System.out.println();
                            System.out.println("Distance traveled: " +
                                    distanceTraveled);
                            System.out.println("Current fuel level: " +
                                    car.getFuelLevel());
                            System.out.println("Current odometer reading: " +
                                    car.getOdometer());
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}