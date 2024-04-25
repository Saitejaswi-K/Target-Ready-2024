package com.targetindia.miniproject.dao;

import com.targetindia.miniproject.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCustomerDao implements CustomerDao{

    private List<Customer> customers = new ArrayList<>();

    public ArrayListCustomerDao() {
        customers.add(new Customer(1, "Vinod Kumar", "Banglore", "vinod@vinod.co", "9731454784"));
        customers.add(new Customer(2, "John Doe", "Dallas", "jd@example.com", "5567454784"));
    }

    @Override

    public Customer save(Customer customer) throws DaoException {
//        int maxId = 0;
//        for (Customer c: customers){
//            if (c.getId() > maxId){
//                maxId = c.getId();
//            }
//        }
//        maxId++;
        int maxId = customers.stream()
                        .map(c -> c.getId())
                .max(Integer::compareTo)
                .get() + 1;
        customer.setId(maxId);
        customers.add(customer);
        return customer;
    }

    @Override
    public Customer getById(int id) throws DaoException {
//        for (Customer c: customers){
//            if(c.getId() == id){
//                return c;
//            }
//        }
        return customers.stream()
                .filter(c-> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Customer customer) throws DaoException {
//        boolean found = false;
//        for (int i=0, j=customers.size(); i<j; i++){
//            Customer c = customers.get(i);
//            if(c.getId() == customer.getId()){
//                customers.set(i, customer);
//                found = true;
//                break;
//            }
//        }
//        if(!found){
//            throw new DaoException("Customer data not found for id: " + customer.getId());
//        }
        customers.set(customers.indexOf(
                customers.stream()
                        .filter(c-> c.getId() == customer.getId())
                        .findFirst()
                        .orElse(null)
                ), customer);

    }

    @Override
    public Customer deleteById(int id) throws DaoException {
        Customer c = this.getById(id);
        if(c == null){
            throw new DaoException("No customer found for this id " + id);
        }
        this.customers = this.customers.stream()
                .filter(cust -> cust.getId() != id)
                .toList();
        return c;

    }

    @Override
    public List<Customer> getAll() throws DaoException {
        return this.customers;
    }

    @Override
    public Customer getByEmail(String email) throws DaoException {
//        for (Customer c: customers){
//            if(c.getEmail().equals(email)){
//                return c;
//            }
//        }
//        return null;
        return customers.stream()
                .filter(c-> c.getEmail() == email)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer getByPhone(String phone) throws DaoException {
//        for (Customer c: customers){
//            if(c.getPhone().equals(phone)){
//                return c;
//            }
//        }
//        return null;
        return customers.stream()
                .filter(c-> c.getPhone() == phone)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> getByCity(String city) throws DaoException {
//        List<Customer> customersByCity = new ArrayList<>();
//        for (Customer c: customers){
//            if(c.getCity().equals(city)){
//                customersByCity.add(c);
//            }
//        }
//        return customersByCity;
        return customers.stream()
                .filter(c-> c.getCity() == city)
                .toList();
    }
}
