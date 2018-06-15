package restFul;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Account;
import requestsviewmodels.CreateAccountRequest;
import requestsviewmodels.DepositAmountRequest;
import service.AccountService;
import service.IAccountService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

@Path("/BankRest")
public class BankRestFul {

    AccountService service = new AccountService();
    ObjectMapper mapper = new ObjectMapper();

    @Path("/createaccount")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createAccount(CreateAccountRequest request){
        try {
            return mapper.writeValueAsString(service.createAccount(request.getCustomerName()));
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    @Path("/depositamount")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String depositaccount(DepositAmountRequest request){
        try {
            return mapper.writeValueAsString(service.depositAmount(request.getAccNo(), request.getAmount()));
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    @Path("/displayaccounts")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String displayaccounts() {
        try {
            return mapper.writeValueAsString(service.returnFinalListOfAccounts());
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }
}