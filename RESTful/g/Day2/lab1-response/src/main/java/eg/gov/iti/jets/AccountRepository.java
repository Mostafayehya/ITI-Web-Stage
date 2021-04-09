package eg.gov.iti.jets;

import java.util.ArrayList;
import java.util.List;
import jakarta.ws.rs.core.Response;

public class AccountRepository {

    private static final AccountRepository repository = new AccountRepository();
    private static final List<Account> accounts = new ArrayList<>();

    private AccountRepository(){

    }

    public static AccountRepository getInstance(){
        return repository;
    }

    public List<Account> getAllAccounts(){
        return accounts;
    }

    public Account getAccountById(int id){

        return accounts.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }


    public Account addNewAccount (Account account){

        accounts.add(account);
        return account;
    }

    public Account updateAccount (int id, Account newAccount){

        Account myAccount = getAccountById(id);
        myAccount.setUserName(newAccount.getUserName());
        myAccount.setFullName(newAccount.getFullName());
        myAccount.setPassword(newAccount.getPassword());
        myAccount.setAddress(newAccount.getAddress());
        myAccount.setPhone(newAccount.getPhone());
        myAccount.setFullName(newAccount.getFullName());
        return myAccount;
    }


    public Account deleteAccountById(int id){

        Account myAccount = accounts.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
        accounts.removeIf(b -> b.getId() == id);
        return myAccount;

    }

    public List<Account> deleteAllAccounts(){

        List<Account> myAccounts = new ArrayList<>(accounts);
        accounts.clear();
        return myAccounts;
    }


}
