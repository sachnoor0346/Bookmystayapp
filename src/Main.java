/**
 * HotelBookingApplication
 *
 * Demonstrates object modeling using abstraction and inheritance.
 * Different room types are created and their availability is displayed.
 *
 * @author Sachnoor
 * @version 1.0
 */

// Abstract Room class
abstract class Room {

    protected String roomType;
    protected int beds;
    protected int size;
    protected double price;

    // Constructor
    Room(String roomType, int beds, int size, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    // Method to display room details
    public void displayDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sq ft");
        System.out.println("Price per night: ₹" + price);
    }
}

// Single Room class
class SingleRoom extends Room {

    SingleRoom() {
        super("Single Room", 1, 200, 2500);
    }
}

// Double Room class
class DoubleRoom extends Room {

    DoubleRoom() {
        super("Double Room", 2, 350, 4000);
    }
}

// Suite Room class
class SuiteRoom extends Room {

    SuiteRoom() {
        super("Suite Room", 3, 600, 8000);
    }
}

// Main application
class HotelBookingApplication {

    public static void main(String[] args) {

        System.out.println("Hotel Booking System - Room Availability\n");

        // Creating room objects (Polymorphism)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        // Display Single Room
        single.displayDetails();
        System.out.println("Available Rooms: " + singleAvailability);
        System.out.println("----------------------------");

        // Display Double Room
        doubleRoom.displayDetails();
        System.out.println("Available Rooms: " + doubleAvailability);
        System.out.println("----------------------------");

        // Display Suite Room
        suite.displayDetails();
        System.out.println("Available Rooms: " + suiteAvailability);
        System.out.println("----------------------------");

        System.out.println("Application terminated.");
    }
}