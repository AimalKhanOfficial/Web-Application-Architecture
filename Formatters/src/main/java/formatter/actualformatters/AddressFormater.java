package formatter.actualformatters;

import formatter.entities.Address;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class AddressFormater implements Formatter<Address> {
    @Override
    public Address parse(String s, Locale locale) throws ParseException {
        String[] parts = s.split(",");
        Address address = new Address();
        address.setStreet(parts[0].trim());
        address.setCity(parts[1].trim());
        address.setZipCode(parts[2].trim());
        address.setCounty(parts[3].trim());
        return address;
    }

    @Override
    public String print(Address address, Locale locale) {
        return address.getCity() + ", " + address.getCounty() + ", " + address.getStreet() + ", " + address.getZipCode();
    }
}
