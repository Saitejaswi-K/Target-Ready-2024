package com.targetindia.miniproject.ui;

import com.targetindia.miniproject.model.Customer;
import com.targetindia.miniproject.service.CustomerManager;
import com.targetindia.miniproject.service.ServiceException;
import com.targetindia.miniproject.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.InputMismatchException;

@Slf4j
public class Main {
    CustomerManager cm = new CustomerManager();
    int menu() {
        System.out.println("=====Main Menu=====");
        System.out.println("0.Exit");
        System.out.println("1. List all Customers");
        System.out.println("2. Add a new Customer");
        System.out.println("3. Search customer by id");
        System.out.println("4. Search customer by city");
        System.out.println("5. Delete a customer by id");
        System.out.println("6. Search customers by Id and update details");
        try {
            return KeyboardUtil.getInt("Enter your Choice: ");
        }
        catch (InputMismatchException e){
            log.warn("There was an error while accepting menu choice", e);
            return -1;
        }
    }
    void start(){
        int choice;
        while((choice = menu()) != 0){
            log.trace("User made a choice {}", choice);
            switch (choice){
                case 1:
                    displayCustomerList();
                    break;
                case 2:
                    addNewCustomerData();
                    break;
                case 3:
                    searchByCustomerId();
                    break;
                case 4:
                    searchByCustomerCity();
                    break;
                case 5:
                    deleteCustomerbyId();
                    break;
                case 6:
                    updateByCustomerId();
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }

    void searchByCustomerCity() {
        System.out.println("Searching Customers by city");
        try{
            String city = KeyboardUtil.getString("Enter City of customers: ");
            var customers = cm.getCustomersByCity(city);
            System.out.printf("%4s %-20s %-15s %-25s %-15s\n", "ID", "Name", "City", "Email", "Phone");
            System.out.println("-----------------------------------------------------------------------------------");
            for(Customer c: customers){
                System.out.printf("%4s %-20s %-15s %-25s %-15s\n",
                        c.getId(),
                        c.getName(),
                        c.getCity(),
                        c.getEmail(),
                        c.getPhone());
            }

        }
        catch (ServiceException e){
            System.out.println("Something went wrong. Check logs or contact tech support");
            log.warn("There was an error while calling cm.getAll()", e);
        }
    }

    void deleteCustomerbyId() {
        System.out.println("Deleting Customers by Id");
        try {
            int id = KeyboardUtil.getInt("Enter id of customer to be deleted: ");
            System.out.printf("Customer with id %d has been deleted\n", id);
            Customer c = cm.deleteById(id);
            System.out.printf("%4s %-20s %-15s %-25s %-15s\n",
                    c.getId(),
                    c.getName(),
                    c.getCity(),
                    c.getEmail(),
                    c.getPhone());
        }
        catch (ServiceException e){
            System.out.println("Something went wrong. Check logs or contact tech support");
            log.warn("There was an error while calling cm.getAll()", e);
        }

    }

    void updateByCustomerId() {
        int id = KeyboardUtil.getInt("Enter Id of customer to be updated: ");
        System.out.println("1. Update Name");
        System.out.println("2. Update City");
        System.out.println("3. Update Email");
        System.out.println("4. Update Phone");
        int choice = KeyboardUtil.getInt("Enter choice of field to update in a customer: ");

        switch (choice){
            case 1:
                updateNameofCustomer(id);
                break;
            case 2:
                updateCityofCustomer(id);
                break;
            case 3:
                updateEmailofCustomer(id);
                break;
            case 4:
                updatePhoneofCustomer(id);
                break;
            default:
                System.out.println("Invalid choice. Try again");

        }
        System.out.println("Updating Customers by Id");

    }
    void updateNameofCustomer(int id){
        try {
            String name = KeyboardUtil.getString("Enter name: ");
            Customer c = cm.getById(id);
            c.setName(name);
        }
        catch (ServiceException e){
            System.out.println("Something went wrong. Check logs or contact tech support");
            log.warn("There was an error while calling cm.getAll()", e);
        }
    }
    void updateCityofCustomer(int id){
        try {
            String city = KeyboardUtil.getString("Enter City: ");
            Customer c = cm.getById(id);
            c.setCity(city);
        }
        catch (ServiceException e){
            System.out.println("Something went wrong. Check logs or contact tech support");
            log.warn("There was an error while calling cm.getAll()", e);
        }
    }
    void updateEmailofCustomer(int id){
        try {
            String email = KeyboardUtil.getString("Enter email: ");
            Customer c = cm.getById(id);
            c.setEmail(email);
        }

        catch (ServiceException e){
            System.out.println("Something went wrong. Check logs or contact tech support");
            log.warn("There was an error while calling cm.getAll()", e);
        }
    }
    void updatePhoneofCustomer(int id){
        try {
            String phone = KeyboardUtil.getString("Enter phone: ");
            Customer c = cm.getById(id);
            c.setPhone(phone);
        }
        catch (ServiceException e){
            System.out.println("Something went wrong. Check logs or contact tech support");
            log.warn("There was an error while calling cm.getAll()", e);
        }
    }
    void searchByCustomerId() {
        System.out.println("Searching Customers by Id");

        try {
            int id = KeyboardUtil.getInt("Enter id of customer to be searched: ");
            var c = cm.getById(id);
            System.out.printf("%4s %-20s %-15s %-25s %-15s\n",
                    c.getId(),
                    c.getName(),
                    c.getCity(),
                    c.getEmail(),
                    c.getPhone());
        }
        catch (ServiceException e){
            System.out.println("Something went wrong. Check logs or contact tech support");
            log.warn("There was an error while calling cm.getAll()", e);
        }
    }

    void addNewCustomerData() {
        System.out.println("Adding Customers data");
        try {
            System.out.println("Enter Customer details: ");
            int id = KeyboardUtil.getInt("Enter id: ");
            String name = KeyboardUtil.getString("Enter name: ");
            String city = KeyboardUtil.getString("Enter city: ");
            String email = KeyboardUtil.getString("Enter Email: ");
            String phone = KeyboardUtil.getString("Enter Phone number: ");
            Customer c = new Customer(id, name, city, email, phone);
            cm.addNewCustomer(c);
        }
        catch (ServiceException e){
            System.out.println("Something went wrong. Check logs or contact tech support");
            log.warn("There was an error while calling cm.getAll()", e);
        }
    }

    void displayCustomerList() {
        try {
            var customers = cm.getAll();
            System.out.printf("%4s %-20s %-15s %-25s %-15s\n", "ID", "Name", "City", "Email", "Phone");
            System.out.println("-----------------------------------------------------------------------------------");
            for (var c: customers){
                System.out.printf("%4s %-20s %-15s %-25s %-15s\n",
                        c.getId(),
                        c.getName(),
                        c.getCity(),
                        c.getEmail(),
                        c.getPhone());
            }

        } catch (ServiceException e) {
            System.out.println("Something went wrong. Check logs or contact tech support");
            log.warn("There was an error while calling cm.getAll()", e);
        }
    }

    public static void main(String[] args) {
        log.trace("Starting The App..");
        new Main().start();
        log.trace("Ending The App..");

    }
}
