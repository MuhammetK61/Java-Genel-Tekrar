package _16SigortaYönetimSistemiÖdevi.Management;


import _16SigortaYönetimSistemiÖdevi.Account.*;
import _16SigortaYönetimSistemiÖdevi.Adress.Adress;
import _16SigortaYönetimSistemiÖdevi.Adress.AdressManager;
import _16SigortaYönetimSistemiÖdevi.Adress.BusinessAdress;
import _16SigortaYönetimSistemiÖdevi.Adress.HomeAdress;

import java.util.TreeSet;

public class Management {

  private AccountManager accountManager;

  public Management(){
      accountManager = new AccountManager();
  }

  public void displayMenu() {
      System.out.println("#################################################");
      System.out.println("Policy Management Panel!");
      System.out.println("1. Add user (Individual or Enterprise)");
      System.out.println("2. Login");
      System.out.println("3. Show List Accounts");
      System.out.println("0. Exit");
      System.out.println("#################################################");
      System.out.print("Enter your choice: ");
  }

  //Bu bölümde sigorta şirketinin, Bireysel mi (Individual) yoksa Kurumsal(Enterprise) mı müşteri profili eklemesi yapacağını seçiyoruz
  public void addUser(String userType, String name, String surname, String email, String password, String job,
                      int age, String companyName){
      User user = new User(name, surname, email, password, job, age);
      //Burada "equalsIgnorCase karşılaştırılan metni küçük harfe çevirir
      //Böylelikle büyük küçük harf karışıklığının önüne geçer
      if (userType.equalsIgnoreCase("I")){
          Account account = new Individual(user);
          accountManager.addAccount(account);
          System.out.println("User added succesfully!");
      }else if (userType.equalsIgnoreCase("E")){
          Account account = new Enterprise(user, companyName);
          accountManager.addAccount(account);
          System.out.println("User added successfully!");
      }else {
          System.out.println("Invalid user type, Please try again!");
      }
  }

  public Account login(String userEmail, String userPassword){
      Account account = accountManager.login(userEmail, userPassword);
      if (account != null)
          account.showUserInfo();
      return account;
  }

  public void afterLoginMenu(){
      System.out.println("#################################################");
      System.out.println("1. Add address");
      System.out.println("2. Add insurance");
      System.out.println("3. Show user info");
      System.out.println("0. Logout");
      System.out.println("#################################################");
      System.out.print("Enter your choice: ");
  }

  public void addHomeAddress(User user, String streetAddress, String city, String state, String zipCode){
      Adress homeAdress = new HomeAdress(streetAddress, city, zipCode,state);
      AdressManager.addAdress(user, homeAdress);
      System.out.println("Successfully added home adress!!");
  }

  public void addBusinessAdress(User user, String companyName, String streetAdress, String city, String state, String zipCode){
      Adress businessAdress = new BusinessAdress(streetAdress, city, zipCode, state, companyName);
      AdressManager.addAdress(user, businessAdress);
      System.out.println("Successfully added business adress!!");
  }

  public void showuserInfo(Account account){
      account.showUserInfo();
  }

  public void listAccounts(){
      TreeSet<Account> accountList = accountManager.getAccountList();
      if (accountList.isEmpty()){
          System.out.println("No accounts found in the system");
          return;
      }
      String format = "| %-15s | %-15s | %-25s |%-15s | %-20s | %-8s | %-25s | %-15s |\n";
      System.out.format(format, "Name", "Surname", "Email", "Password", "Profession", "Age", "Last login date",
              "Type");
      for (Account a : accountList) {
          System.out.format(format, a.getUser().getName(), a.getUser().getSurname(), a.getUser().getEmail(),
                  a.getUser().getPassword(), a.getUser().getJob(), a.getUser().getAge(),
                  a.getUser().getLastLoginDate(), a.getClass().getSimpleName());
      }
  }

  public boolean isHaveAccount(){
      return  accountManager.getAccountList().isEmpty();
  }



}
