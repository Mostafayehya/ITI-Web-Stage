package eg.gov.iti.jets;

import eg.gov.iti.jets.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Context;


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
    public Response getAccountById(@PathParam("id") int id, @Context UriInfo uriInfo) {

        Account account = repository.getAccountById(id);

        if(account == null){
            throw new ResourceNotFoundException("Account with ID:" + id + " Not Found");
        }

        return Response.ok(account).build();
    }

    @POST
    public Response createAccount(Account account, @Context UriInfo uriInfo) {

        Account acc = repository.addNewAccount(account);

        if(account == null){
            throw new ResourceNotFoundException("Can't add new account");
        }

        return Response.ok(acc).build();
    }

    @PUT
    @Path("{id}")
    public Account updAccount(@PathParam("id") int id, Account newAccount, @Context UriInfo uriInfo) {


        Account acc = repository.updateAccount(newAccount);

        if(newAccount == null){
            throw new ResourceNotFoundException("Can't add new account");
        }

        return Response.ok(acc).build();
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
