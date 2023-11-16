import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class BookingSAXManager {
    private Vector<Booking> bookingsCollection;
    File bookingsFile;

    public BookingSAXManager(Vector<Booking> bookingsCollection) {
        this.bookingsCollection = bookingsCollection;
        loadBookingsFile();
    }

    public static void main(String[] args) {
        // Initialization of objects
        BookingSAXManager bm = new BookingSAXManager(new Vector<>());
        Scanner input = new Scanner(System.in);
        String option;

        // Main menu
        while (true) {
            System.out.println();
            System.out.println("===============================");
            System.out.println("1. Show existing booking");
            System.out.println("2. Exit");
            System.out.println("===============================");

            System.out.print("Enter an option please (1-2): ");
            option = input.nextLine();

            switch (option) {
                case "1":
                    bm.showBookingByID(input);
                    break;
                case "2":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please, try again.");
                    break;
            }
        }
    }

    public void showBookingByID(Scanner input) {
        Boolean bookingFound = false;
        String bID;

        while (!bookingFound) {
            System.out.print("Please, enter the booking ID: ");
            bID = input.nextLine();

            // Iterates over the bookings collection and if the user booking id equals the one is being checked info will be printed.
            for (Booking booking : bookingsCollection) {
                if (booking.getBookingID().equals(bID)) {
                    booking.printBooking();
                    return;
                }
            }

            if (!bookingFound) {
                System.out.println("ERROR - Booking with ID: '" + bID + "' has not been found.");
            }
        }
    }

    public void loadBookingsFile() {
        bookingsFile = new File("src/bookings.xml");
        parseBookingsFile();
    }

    public void parseBookingsFile() {
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLSaxHandler SAXHandler = new XMLSaxHandler()   ;
            parser.parse(bookingsFile, SAXHandler);

            this.bookingsCollection = SAXHandler.getBookingsCollection(); // The bookings collection is retrieved after being fully parsed
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
