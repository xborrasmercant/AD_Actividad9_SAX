import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;
import java.util.Vector;

public class XMLSaxHandler extends DefaultHandler {
    private Booking newBooking = new Booking();
    private Vector<Booking> bookingsCollection = new Vector<>();
    private String currentElement;
    private StringBuilder currentValue = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        String idValue = attributes.getValue(0);
        currentElement = qName;
        currentValue.setLength(0);

        // Element type is checked and id is set.
        switch (currentElement) {
            case "booking":
                newBooking.setBookingID(idValue);
                break;
            case "client":
                newBooking.setClientID(idValue);
                break;
            case "agency":
                newBooking.setAgencyID(idValue);
                break;
            case "room":
                newBooking.setRoomID(idValue);
                break;
            case "hotel":
                newBooking.setHotelID(idValue);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // If the end element is booking means the completed booking is added to the Vector and then the newBooking is reset.
        if (qName.equals("booking")) {
            bookingsCollection.add(newBooking);

            newBooking = new Booking();
            currentElement = "";
        }
        // If not, the current element is checked and its value is set.
        else {
            String elementValue = currentValue.toString().trim();

            switch (currentElement) {
                case "client":
                    newBooking.setClientName(elementValue);
                    break;
                case "agency":
                    newBooking.setAgencyName(elementValue);
                    break;
                case "price":
                    newBooking.setPrice(elementValue);
                    break;
                case "hotel":
                    newBooking.setHotelName(elementValue);
                    break;
                case "check_in":
                    newBooking.setCheckIn(elementValue);
                    break;
                case "room_nights":
                    newBooking.setRoomNights(elementValue);
                    break;
            }

            currentValue.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // The buffer appends the characters into the currentValue StringBuilder, which will be converted to string when an end element is encountered.
        currentValue.append(ch, start, length);
    }

    public Vector<Booking> getBookingsCollection() {
        return bookingsCollection;
    }

    public void setBookingsCollection(Vector<Booking> bookingsCollection) {
        this.bookingsCollection = bookingsCollection;
    }
}
