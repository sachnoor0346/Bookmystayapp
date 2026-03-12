import java.util.*;

/* Reservation class */
class Reservation {

    private String reservationId;
    private String guestName;
    private String roomType;

    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayReservation() {
        System.out.println("Reservation ID: " + reservationId +
                " | Guest: " + guestName +
                " | Room Type: " + roomType);
    }
}


/* BookingHistory stores confirmed reservations */
class BookingHistory {

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }

    // Retrieve stored reservations
    public List<Reservation> getReservations() {
        return history;
    }

    // Display full history
    public void displayHistory() {

        System.out.println("\nBooking History:");

        for (Reservation r : history) {
            r.displayReservation();
        }
    }
}


/* BookingReportService generates reports */
class BookingReportService {

    public void generateSummary(List<Reservation> reservations) {

        System.out.println("\nBooking Summary Report");

        Map<String, Integer> roomTypeCount = new HashMap<>();

        for (Reservation r : reservations) {

            String roomType = r.getRoomType();

            roomTypeCount.put(
                    roomType,
                    roomTypeCount.getOrDefault(roomType, 0) + 1
            );
        }

        for (Map.Entry<String, Integer> entry : roomTypeCount.entrySet()) {
            System.out.println(entry.getKey() + " Bookings: " + entry.getValue());
        }

        System.out.println("Total Reservations: " + reservations.size());
    }
}


/* Main Application */
class HotelBookingApplication {

    public static void main(String[] args) {

        System.out.println("Hotel Booking System - Booking History\n");

        // Initialize history
        BookingHistory history = new BookingHistory();

        // Simulate confirmed bookings
        Reservation r1 = new Reservation("R101", "Sachnoor", "Single Room");
        Reservation r2 = new Reservation("R102", "Aman", "Double Room");
        Reservation r3 = new Reservation("R103", "Riya", "Suite Room");

        // Add bookings to history
        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);

        // Admin views booking history
        history.displayHistory();

        // Generate report
        BookingReportService reportService = new BookingReportService();
        reportService.generateSummary(history.getReservations());
    }
}