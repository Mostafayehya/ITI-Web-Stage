package eg.gov.iti.jets;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;


@Path("accounts")
@Consumes({"application/xml", "application/json"})
@Produces({"application/xml; qs=0.5", "application/json; qs=1"}) //  qs : arrange Priority ratio
public class AccountResource {

    private static final AccountRepository repository = AccountRepository.getInstance();

    @GET
    public List<Account> getAllAccounts() {

        return repository.getAllAccounts();
    }

    @GET
    @Path("{id}")
    public Account getAccountById(@PathParam("id") int id) {

        return repository.getAccountById(id);
    }

    @POST
    public Account createAccount(Account account) {

        return repository.addNewAccount(account);
    }

    @PUT
    @Path("{id}")
    public Account updAccount(@PathParam("id") int id, Account newAccount) {

        return repository.updateAccount(id, newAccount);
    }

    @DELETE
    @Path("{id}")
    public Account deleteAccountById(@PathParam("id") int id) {
        return repository.deleteAccountById(id);
    }

    @DELETE
    public List<Account> deleteAllAccounts() {
        return repository.deleteAllAccounts();
    }
}
