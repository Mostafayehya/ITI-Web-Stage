package eg.gov.iti.jets;

import java.util.ArrayList;
import java.util.List;

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

        Account existingAccount = getAccountById(id);
        existingAccount.setUserName(newAccount.getUserName());
        existingAccount.setFullName(newAccount.getFullName());
        existingAccount.setPassword(newAccount.getPassword());
        existingAccount.setAddress(newAccount.getAddress());
        existingAccount.setPhone(newAccount.getPhone());
        existingAccount.setFullName(newAccount.getFullName());
        return existingAccount;
    }


    public Account deleteAccountById(int id){

        Account existingAccount = accounts.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
        accounts.removeIf(b -> b.getId() == id);
        return existingAccount;

    }

    public List<Account> deleteAllAccounts(){

        List<Account> oldAccounts = new ArrayList<>(accounts);
        accounts.clear();
        return oldAccounts;
    }


}
