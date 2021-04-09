package eg.gov.iti.jets;


import eg.gov.iti.jets.Account;
import eg.gov.iti.jets.AccountResource;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;


public class AccountDaoImplTest {
    private static AccountResource accountResource;

    @BeforeAll
    static void initAll() {
        System.out.println("before all");
    }

    @BeforeEach
    void init() {
        System.out.println("before each test");

    }

    @AfterEach
    void tearDown() {
        System.out.println("after each test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("after all");
    }


    @Test
    public void testGetAccount() {

        Client client = ClientBuilder.newClient();
        Account account = client.target("http://localhost:9191/rest-response/api/accounts")
                                .path("{id}").resolveTemplate("id",5)
                                .request(MediaType.APPLICATION_XML).get(Account.class);

        System.out.println(account);
    }

    @Test
    public void testGetAllAccounts() {

        Client client = ClientBuilder.newClient();
        Account account = client.target("http://localhost:9191/rest-response/api/accounts")
                                .request(MediaType.APPLICATION_XML).get(Account.class);

        System.out.println(account);
    }

    @Test
    public void testUpdateAccount() {

        Client client = ClientBuilder.newClient();
        Account account = new Account("ahmed", "ahmed galal", "123", "01234561237", "cairo");

        Account myAccount = client.target("http://localhost:9191/rest-response/api/accounts")
                            .request().put(Entity.entity(account, MediaType.APPLICATION_XML), Account.class);

        System.out.println(myAccount + ", " + account);

    }

    @Test
    public void testDeleteAccount() {
 
        Client client = ClientBuilder.newClient();
        client.target("http://localhost:9191/rest-response/api/accounts").path("{id}")
                .resolveTemplate("{id}", 2).request().delete();
    }

}
