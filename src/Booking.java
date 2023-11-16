import java.awt.print.Book;
import java.util.Scanner;

public class Booking {
    private String bookingID, clientID, agencyID, price, roomID, hotelID, clientName, agencyName, hotelName, checkIn, roomNights;

    public Booking(String bookingID, String clientID, String agencyID, String price, String roomID, String hotelID, String clientName, String agencyName, String hotelName, String checkIn, String roomNights) {
        this.bookingID = bookingID;
        this.clientID = clientID;
        this.agencyID = agencyID;
        this.price = price;
        this.roomID = roomID;
        this.hotelID = hotelID;
        this.clientName = clientName;
        this.agencyName = agencyName;
        this.hotelName = hotelName;
        this.checkIn = checkIn;
        this.roomNights = roomNights;
    }

    public Booking()  {
        // Null constructor
    }

    public void printBooking() {
        System.out.println();
        System.out.println("============= Booking " + bookingID + " ==============");
        System.out.println("Client (" + clientID + "): " + clientName);
        System.out.println("Agency (" + agencyID + "): " + agencyName);
        System.out.println("Price: " + price);
        System.out.println("Room: " + getRoomType());
        System.out.println("Hotel (" + hotelID + "): " + hotelName);
        System.out.println("Check-in: " + checkIn);
        System.out.println("Nights: " + roomNights);
        System.out.println();
    }

    public String getRoomType() {
        if (roomID.equals("1")) {
            return "Double";
        } else if (roomID.equals("2")) {
            return "Apartament";
        } else if (roomID.equals("3")) {
            return "Individual";
        } else if (roomID.equals("4")) {
            return "Suite";
        }

        return "";
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(String agencyID) {
        this.agencyID = agencyID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getRoomNights() {
        return roomNights;
    }

    public void setRoomNights(String roomNights) {
        this.roomNights = roomNights;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
