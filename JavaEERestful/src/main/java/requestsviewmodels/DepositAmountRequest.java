package requestsviewmodels;

public class DepositAmountRequest {

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    private String accNo;
    private String amount;

    public DepositAmountRequest(){

    }
}
