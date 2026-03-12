import java.util.*;

/**
 * Abstract Room class representing common room properties
 */
abstract class Room {

    protected String roomType;
    protected double price;
    protected String amenities;

    public Room(String roomType, double price, String amenities) {
        this.roomType = roomType;
        this.price = price;
        this.amenities = amenities;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Price: ₹" + price);
        System.out.println("Amenities: " + amenities);
    }
}


/* Concrete Room Types */

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 2500, "1 Bed, WiFi, TV");
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 4000, "2 Beds, WiFi, TV, Mini Fridge");
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 8000, "3 Beds, WiFi, TV, Living Area");
    }
}


/**
 * Centralized inventory manager using HashMap
 */
class RoomInventory {

    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);   // intentionally unavailable
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public Set<String> getRoomTypes() {
        return inventory.keySet();
    }
}


/**
 * SearchService – Handles read-only search operations
 */
class SearchService {

    private RoomInventory inventory;
    private Map<String, Room> roomCatalog;

    public SearchService(RoomInventory inventory) {

        this.inventory = inventory;

        // Domain model for room information
        roomCatalog = new HashMap<>();
        roomCatalog.put("Single Room", new SingleRoom());
        roomCatalog.put("Double Room", new DoubleRoom());
        roomCatalog.put("Suite Room", new SuiteRoom());
    }

    public void searchAvailableRooms() {

        System.out.println("Available Rooms:\n");

        for (String type : inventory.getRoomTypes()) {

            int available = inventory.getAvailability(type);

            // Validation: show only rooms with availability > 0
            if (available > 0) {

                Room room = roomCatalog.get(type);

                room.displayDetails();
                System.out.println("Available: " + available);
                System.out.println("-------------------------");
            }
        }
    }
}


/**
 * Application Entry Point
 */
class HotelBookingApplication {

    public static void main(String[] args) {

        System.out.println("Hotel Booking System - Room Search\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Initialize search service
        SearchService searchService = new SearchService(inventory);

        // Guest searches for available rooms
        searchService.searchAvailableRooms();

        System.out.println("Search completed. System state unchanged.");
    }
}