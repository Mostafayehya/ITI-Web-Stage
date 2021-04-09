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
    public Response getAllAccounts() {

        List<Account> accounts = repository.getAllAccounts();

        if(accounts == null){
            throw new ResourceNotFoundException("Sad .. no Account exists! ");
        }

        return Response.ok(accounts).build();
    }

    @GET
    @Path("{id}")
    public Response getAccountById(@PathParam("id") int id, @Context UriInfo uriInfo) {

        Account account = repository.getAccountById(id);

        if(account == null){
            throw new ResourceNotFoundException("Account with ID:" + id + " Not Found");
        }

        // Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        // account.setLinks(Arrays.asList(self));

        return Response.ok(account).build();
        
        // return Response.ok().entity(account).build();

    }

    @POST
    public Response createAccount(Account account, @Context UriInfo uriInfo) {

        Account acc = repository.addNewAccount(account);

        if(account == null){
            throw new ResourceNotFoundException("Can't add new account");
        }

        // Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        // acc.setLinks(Arrays.asList(self));

        return Response.ok(acc).build();

        // return repository.addNewAccount(account);
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
