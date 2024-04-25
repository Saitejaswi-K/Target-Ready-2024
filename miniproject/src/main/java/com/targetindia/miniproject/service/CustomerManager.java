package com.targetindia.miniproject.service;

import com.targetindia.miniproject.dao.ArrayListCustomerDao;
import com.targetindia.miniproject.dao.CustomerDao;
import com.targetindia.miniproject.dao.DaoException;
import com.targetindia.miniproject.model.Customer;

import java.util.List;

public class CustomerManager {
    private CustomerDao dao;
    public CustomerManager(){
        // Tight coupling of dependency
        //Must be converted to lose coupling
        this.dao = new ArrayListCustomerDao();

    }
    public Customer addNewCustomer(Customer customer) throws ServiceException{
        try {
            return dao.save(customer);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public Customer getById(int id) throws ServiceException{
        try {
            return dao.getById(id);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }
    public void update(Customer customer) throws ServiceException{
        try {
            dao.update(customer);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }
    public Customer deleteById(int id) throws ServiceException{
        try {
            return dao.deleteById(id);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    //Queries
    public Customer getByEmail(String email) throws ServiceException{
        try {
            return dao.getByEmail(email);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }
    public Customer getByPhone(String phone) throws ServiceException{
        try {
            return dao.getByPhone(phone);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }
    public List<Customer> getCustomersByCity(String city) throws ServiceException{
        try {
            return dao.getByCity(city);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public List<Customer> getAll() throws ServiceException{
        try {
            return dao.getAll();
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }
}
