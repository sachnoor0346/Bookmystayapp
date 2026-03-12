
import java.util.HashMap;
import java.util.Map;

/**
 * RoomInventory
 *
 * Manages centralized inventory of room availability using a HashMap.
 * This replaces scattered variables with a single source of truth.
 *
 * @author Sachnoor
 * @version 1.0
 */
class RoomInventory {

    // HashMap to store room type and available count
    private Map<String, Integer> inventory;

    /**
     * Constructor initializes room availability.
     */
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    /**
     * Returns the availability of a specific room type
     */
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    /**
     * Updates availability of a specific room type
     */
    public void updateAvailability(String roomType, int newCount) {
        inventory.put(roomType, newCount);
    }

    /**
     * Displays complete inventory state
     */
    public void displayInventory() {
        System.out.println("\nCurrent Room Inventory:");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " available");
        }
    }
}

class HotelBookingApplication {

    public static void main(String[] args) {

                System.out.println("Hotel Booking System - Inventory Management\n");

                // Initialize inventory
                RoomInventory inventory = new RoomInventory();

                // Display inventory
                inventory.displayInventory();

                // Example: Update availability
                System.out.println("\nUpdating Single Room availability...");
                inventory.updateAvailability("Single Room", 4);

                // Retrieve specific availability
                int singleRooms = inventory.getAvailability("Single Room");
                System.out.println("Single Room Available: " + singleRooms);

                // Display updated inventory
                inventory.displayInventory();

                System.out.println("\nApplication terminated.");
            }
        }

