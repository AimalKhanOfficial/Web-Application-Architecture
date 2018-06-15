package requestsviewmodels;

import java.io.Serializable;

public class CreateAccountRequest implements Serializable {
    private String customerName;

    public CreateAccountRequest() {

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
