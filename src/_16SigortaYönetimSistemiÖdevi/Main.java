package _16SigortaYönetimSistemiÖdevi;


import _16SigortaYönetimSistemiÖdevi.Account.Account;
import _16SigortaYönetimSistemiÖdevi.Insurances.CarInsurance;
import _16SigortaYönetimSistemiÖdevi.Insurances.HealthInsurance;
import _16SigortaYönetimSistemiÖdevi.Insurances.ResidenceInsurance;
import _16SigortaYönetimSistemiÖdevi.Insurances.TravelInsurance;
import _16SigortaYönetimSistemiÖdevi.Management.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Management management = new Management();
        Scanner sc = new Scanner(System.in);

        int choice = -1;
        while (choice != 0){
            management.displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter user type (Individual or Enterprise) (I/E): ");
                    sc.nextLine(); // Clear the buffer
                    String userType = sc.nextLine();
                    System.out.print("Enter user name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter user surname: ");
                    String surname = sc.nextLine();
                    System.out.print("Enter user email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter user password: ");
                    String password = sc.nextLine();
                    System.out.print("Enter user job: ");
                    String job = sc.nextLine();
                    System.out.print("Enter user age: ");
                    int age = sc.nextInt();
                    String companyName = null;

                    if (userType.equalsIgnoreCase("E")) {
                        System.out.println("Enter your company name : ");
                        sc.nextLine();
                        companyName = sc.nextLine();
                    }

                    management.addUser(userType, name, surname, email, password, job, age, companyName);
                    break;
                case 2:
                    if (management.isHaveAccount()){
                        System.out.println("No accounts found in the system");
                        System.out.println("Please add a user first");
                        break;
                    }
                    System.out.print("Enter user email: ");
                    sc.nextLine(); // Clear the buffer
                    String userEmail = sc.nextLine();
                    System.out.print("Enter user password: ");
                    String userPassword = sc.nextLine();
                    Account account = management.login(userEmail, userPassword);
                    if (account == null) {
                        System.out.println();
                    }else {
                        System.out.println("Login successfull!");
                        int option = -1;
                        while (option != 0){
                            management.afterLoginMenu();
                            option = sc.nextInt();
                            switch (option){
                                case 1:
                                    System.out.println("1. Home Address");
                                    System.out.println("2. Business Address");
                                    System.out.print("Enter your choice: ");
                                    int addressChoice = sc.nextInt();
                                    sc.nextLine(); // Clear the buffer
                                    System.out.print("Enter your street address: ");
                                    String streetAddress = sc.nextLine();
                                    System.out.print("Enter your city: ");
                                    String city = sc.nextLine();
                                    System.out.print("Enter your state: ");
                                    String state = sc.nextLine();
                                    System.out.print("Enter your zip code: ");
                                    String zipCode = sc.nextLine();
                                    if (addressChoice == 1){
                                        management.addHomeAddress(
                                                account.getUser(),
                                                streetAddress,city,
                                                state,zipCode
                                        );
                                    }else if(addressChoice == 2) {
                                        System.out.println("Enter your company name : ");
                                        sc.nextLine();
                                        companyName = sc.nextLine();
                                        management.addBusinessAdress(
                                                account.getUser(),
                                                companyName,
                                                streetAddress,
                                                city, state, zipCode
                                        );
                                    }else {
                                        System.out.println("Incalid choice, Please try again");
                                    }
                                break;
                                case 2:
                                    System.out.println("1. Car Insurance");
                                    System.out.println("2. Health Insurance");
                                    System.out.println("3. Residence Insurance");
                                    System.out.println("4. Travel Insurance");
                                    System.out.print("Enter your choice: ");
                                    int insuranceChoice = sc.nextInt();
                                    sc.nextLine(); // Clear the buffer
                                    if (insuranceChoice == 1){
                                        System.out.print("Enter car name: ");
                                        String carMake = sc.nextLine();
                                        System.out.print("Enter car model: ");
                                        String carModel = sc.nextLine();
                                        System.out.print("Enter car age: ");
                                        int carAge = sc.nextInt();
                                        System.out.print(
                                                "Enter true or false that if coverage for drivers (T/F): ");
                                        sc.nextLine(); // Clear the buffer
                                        String answer = sc.nextLine();
                                        boolean coverageForDrivers;
                                        if (answer.equalsIgnoreCase("t")){
                                            coverageForDrivers = true;
                                        }else if(answer.equalsIgnoreCase("f")){
                                            coverageForDrivers = false;
                                        }else {
                                            System.out.println("Invalid choice. Please try again");
                                            break;
                                        }
                                        System.out.println("Enter true or false that if coverage for passengers (T/F):" );
                                        sc.nextLine();
                                        answer = sc.nextLine();
                                        boolean coverageForPassengers = false;
                                        if (answer.equalsIgnoreCase("t")){
                                            coverageForDrivers = true;
                                        }else if(answer.equalsIgnoreCase("f")){
                                            coverageForDrivers = false;
                                        }else{
                                            System.out.println("Invalid choice. Please try again.");
                                            break;
                                        }
                                        account.addInsurance(
                                                new CarInsurance(
                                                        carMake,
                                                        carModel,
                                                        carAge,
                                                        coverageForDrivers,
                                                        coverageForPassengers
                                                ));

                                    }else if(insuranceChoice == 2){
                                        System.out.print(
                                                "Enter health condition: ");
                                        String healthCondition = sc.nextLine();
                                        System.out.print(
                                                "Enter coverage limit: ");
                                        double coverageLimit = sc.nextDouble();
                                        System.out.print(
                                                "Enter true or false that if coverage for pre existing condition (T/F): ");
                                        sc.nextLine(); // Clear the buffer
                                        String answer = sc.nextLine();
                                        boolean coverageForPreExistingCondition;
                                        if (answer.equalsIgnoreCase("t")) {
                                            coverageForPreExistingCondition = true;
                                        } else if (answer.equalsIgnoreCase(
                                                "f")) {
                                            coverageForPreExistingCondition = false;
                                        } else {
                                            System.out.println(
                                                    "Invalid choice. Please try again.");
                                            break;
                                        }
                                        account.addInsurance(new HealthInsurance(
                                                healthCondition,
                                                coverageForPreExistingCondition,
                                                coverageLimit
                                        ));
                                    }else if(insuranceChoice == 3){
                                        System.out.print(
                                                "Enter building value: ");
                                        double buildingValue = sc.nextDouble();
                                        System.out.print(
                                                "Enter content value: ");
                                        double contentValue = sc.nextDouble();
                                        account.addInsurance(new ResidenceInsurance(
                                                buildingValue,
                                                contentValue
                                        ));
                                    }else  if (insuranceChoice == 4){
                                        List<String> coveredCountries = new ArrayList<>();
                                        System.out.println("Enter countries : " );
                                        while (sc.hasNextLine()){
                                            String item = sc.nextLine();
                                            if(item.isEmpty()){
                                                break;
                                            }
                                            coveredCountries.add(item);
                                        }
                                        System.out.println("Enter duration : ");
                                        int duration = sc.nextInt();
                                        account.addInsurance(new TravelInsurance(
                                                coveredCountries,
                                                duration
                                        ));
                                    }else {
                                        System.out.println("Invalid choice. Please try again");
                                    }

                                    break;

                                case 3:
                                    management.showuserInfo(account);
                                    break;
                                case 0:
                                    account = null;
                                    System.out.println("You're exiting!!");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again!");
                                    break;
                            }
                        }
                    }
                break;

                case 3:
                    management.listAccounts();
                    break;
                case 0:
                    System.out.println("Exiting the system...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
                    break;
            }
        }
        sc.close();
    }
}