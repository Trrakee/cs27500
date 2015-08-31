/**
 * Course: CS 27500
 * Name: Adam Joseph Cook
 * Email: cook5@purduecal.edu
 * Assignment: 1
 *
 * The <CODE>Car</CODE> class is a representation of a Car object.
 * @author Adam Joseph Cook
 *  <A HREF="mailto:cook5@purduecal.edu"> (cook5@purduecal.edu) </A>
 */
public class Car {
    private double fuelEfficiency;
    private double fuelLevel;
    private double odometer;

    /**
     A constructor that sets the initial fuel level and odometer of the Car
     to zero and allows the setting of the Car's fuel efficiency.

     @param fuelEfficiency    the fuel efficiency for the Car (in miles/gallon)
     */
    public Car(double fuelEfficiency) {
        fuelLevel = 0.0;
        odometer = 0.0;
        this.fuelEfficiency = fuelEfficiency;
    }

    /**
     Retrieve the Car's fuel efficiency value.

     @return    the fuel efficiency for the Car (in miles/gallon)
     */
    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    /**
     Retrieve the Car's odometer reading value.

     @return    the odometer reading value for the Car (in miles)
     */
    public double getOdometer() {
        return odometer;
    }

    /**
     Retrieve the Car's fuel level value (in gallons).

     @return    the fuel level value for the Car (in gallons)
     */
    public double getFuelLevel() {
        return fuelLevel;
    }

    /**
     Add fuel to the Car's fuel tank.

     @param gallons    amount of fuel to add (in gallons)
     @return           adjusted fuel level
     */
    public double addFuel(double gallons) {
        fuelLevel += gallons;
        return fuelLevel;
    }

    /**
     Simulate driving the Car a specified number of miles. The distance the Car
     actually travels is based on the fuel level in the Car's fuel tank. If,
     for example, the fuel level of the Car is insufficient to travel the
     distance provided, the Car will only travel the distance until all the
     fuel is expended.

     @param miles    distance to drive the Car (in miles)
     @return         distance that the car actually travels (in miles).
     */
    public double drive(double miles) {
        // Adjust consumed fuel. Ensure that the fuel remaining will be a
        // positive number. If not, the car has run out of fuel prior to it
        // traveling all of the provided miles.
        double fuelExpended = miles / fuelEfficiency;
        double fuelLeft = fuelLevel - fuelExpended;
        double actualMilesTraveled;

        if (fuelLevel == 0.0) {
            // No fuel in the tank. Therefore, no miles are actually traveled.
            actualMilesTraveled = 0.0;
            return actualMilesTraveled;
        }

        if (fuelLeft >= 0.0) {
            // There is still some fuel left in the tank, so all of the miles
            // provided are, in fact, traveled and added to the car odometer.
            fuelLevel = fuelLeft;
            odometer += miles;
            return miles;
        } else {
            // The car ran out of fuel (fuelLeft is negative).
            actualMilesTraveled = miles + (fuelLeft * fuelEfficiency);
            // Round up to two decimal places.
            actualMilesTraveled = Math.round(actualMilesTraveled * 100)/100.0;
            fuelLevel = 0.0; // No fuel is left.
            odometer += actualMilesTraveled;
            return actualMilesTraveled;
        }
    }
}