package Project;
import java.time.LocalDate;
import java.util.Scanner;
public class hotel_proj {

    Room[] rooms;
    Booking[] bookings;
    private int roomCount;
    private int bookingCount;

    // Constructor to initialize arrays with fixed size for room and booking management
    public hotel_proj(int totalRooms, int maxBookings) {
        rooms = new Room[totalRooms];
        bookings = new Booking[maxBookings];
        roomCount = 0;
        bookingCount = 0;
    }

    // Room class
    private abstract class Room {
        protected int roomNo;
        protected boolean booked;

        public Room(int roomNo) {
            this.roomNo = roomNo;
            this.booked = false;
        }

        // Display room details
        public abstract void displayDetails();
    }

    // Room Subclass
    private class SingleRoom extends Room {
        public SingleRoom(int roomNo) {
            super(roomNo);
        }

        @Override
        public void displayDetails() {
            System.out.println("Single Room " + roomNo + " - " + (booked ? "Booked" : "Available"));
        }
    }

    // Double Room Subclass
    private class DoubleRoom extends Room {
        public DoubleRoom(int roomNo) {
            super(roomNo);
        }

        @Override
        public void displayDetails() {
            System.out.println("Double Room " + roomNo + " - " + (booked ? "Booked" : "Available"));
        }
    }

    // Suite Room Subclass
    private class SuiteRoom extends Room {
        public SuiteRoom(int roomNo) {
            super(roomNo);
        }

        @Override
        public void displayDetails() {
            System.out.println("Suite Room " + roomNo + " - " + (booked ? "Booked" : "Available"));
        }
    }

    // Booking Inner Class
    private class Booking {
        private Room room;
        private String guestName;
        private LocalDate checkInDate;
        private LocalDate checkOutDate;

        public Booking(Room room, String guestName, LocalDate checkInDate, LocalDate checkOutDate) {
            this.room = room;
            this.guestName = guestName;
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
        }

        public void displayInfo() {
            System.out.println("Booking: " + guestName + " - Room " + room.roomNo + " from " + checkInDate + " to " + checkOutDate);
        }
    }

    // Method to add a room
    public void addRoom(int roomNo, String roomType) {
        Room room;
        switch (roomType.toLowerCase()) {
            case "single":
                room = new SingleRoom(roomNo);
                break;
            case "double":
                room = new DoubleRoom(roomNo);
                break;
            case "suite":
                room = new SuiteRoom(roomNo);
                break;
            default:
                System.out.println("Invalid room type. Room not added.");
                return;
        }

        if (roomCount < rooms.length) {
            rooms[roomCount++] = room;
            System.out.println(roomType + " Room " + roomNo + " added successfully.");
        } else {
            System.out.println("No more rooms can be added.");
        }
    }

    // Method to check availability of rooms
    public void checkAvailability() {
        System.out.println("Available Rooms:");
        for (int i = 0; i < roomCount; i++) {
            if (!rooms[i].booked) {
                rooms[i].displayDetails();
            }
        }
    }

    // Method to book a room
    public void bookRoom(String guestName, int roomNo, LocalDate checkInDate, LocalDate checkOutDate) throws Exception {
        Room room = findRoom(roomNo);
        if (room == null) {
            throw new Exception("Room " + roomNo + " does not exist.");
        }
        if (room.booked) {
            throw new Exception("Room " + roomNo + " is already booked.");
        }
        if (checkInDate.isAfter(checkOutDate)) {
            throw new Exception("Check-out date must be after check-in date.");
        }

        room.booked = true; // Mark the room as booked
        bookings[bookingCount++] = new Booking(room, guestName, checkInDate, checkOutDate);
        System.out.println("Room " + roomNo + " successfully booked for " + guestName + " from " + checkInDate + " to " + checkOutDate + ".");
    }

    // Method to find a room by number
    private Room findRoom(int roomNo) {
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].roomNo == roomNo) {
                return rooms[i];
            }
        }
        return null; // Room not found
    }

    // Method to display all bookings
    public void displayAllBookings() {
        System.out.println("All Bookings:");
        for (int i = 0; i < bookingCount; i++) {
            bookings[i].displayInfo();
        }
    }

    public static void main(String[] args) {
        hotel_proj hotel = new hotel_proj(10, 10); // Initialize with capacity for 10 rooms and 10 bookings
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nHotel Management System");
            System.out.println("1. Add Room");
            System.out.println("2. Check Room Availability");
            System.out.println("3. Book Room");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room number: ");
                    int roomNo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String roomType = scanner.nextLine();
                    hotel.addRoom(roomNo, roomType);
                    break;
                case 2:
                    hotel.checkAvailability();
                    break;
                case 3:
                    System.out.print("Enter guest name: ");
                    scanner.nextLine(); // Consume newline
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number to book: ");
                    int roomToBook = scanner.nextInt();
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    String checkInDateString = scanner.next();
                    LocalDate checkInDate = LocalDate.parse(checkInDateString);
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    String checkOutDateString = scanner.next();
                    LocalDate checkOutDate = LocalDate.parse(checkOutDateString);

                    try {
                        hotel.bookRoom(guestName, roomToBook, checkInDate, checkOutDate);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    hotel.displayAllBookings();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
        System.out.println("Thank you for using the Hotel Management System.");
    }
}
