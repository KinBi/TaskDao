package com.monkeybusiness.training.task.model.dao.impl;

import com.monkeybusiness.training.task.exception.DaoException;
import com.monkeybusiness.training.task.model.dao.CustomerDao;
import com.monkeybusiness.training.task.model.entity.Customer;
import com.monkeybusiness.training.task.model.storage.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {
  private static final CustomerDaoImpl instance = new CustomerDaoImpl();
  private final Bank bank;

  private CustomerDaoImpl() {
    bank = Bank.getInstance();
  }

  public static CustomerDaoImpl getInstance() {
    return instance;
  }

  @Override
  public void add(Customer customer) throws DaoException {
    if (bank.contains(customer)) {
      throw new DaoException("Customer already exists...");
    }

    bank.addCustomer(customer);
  }

  @Override
  public void addAll(List<Customer> customerList) throws DaoException {
    for (Customer customer : customerList) {
      add(customer);
    }
  }

  @Override
  public void remove(Customer customer) throws DaoException {
    if (!bank.contains(customer)) {
      throw new DaoException("Customer not exists...");
    }

    bank.remove(customer);
  }

  @Override
  public void removeAll() throws DaoException {
    Customer customer;

    for (int i = bank.customersSize() - 1; i > -1; i--) {
      customer = bank.getCustomer(i);
      remove(customer);
    }
  }

  @Override
  public void updateCustomerName(long id, String name) throws DaoException{
    Customer customer = findById(id).get();
    int index = bank.indexOf(customer);
    customer.setName(name);
    bank.setCustomer(index, customer);
  }

  @Override
  public void updateAll(List<Customer> customerList) throws DaoException {
    removeAll();
    addAll(customerList);
  }

  @Override
  public Optional<Customer> findById(long id) throws DaoException {
    if (bank.customersSize() < 1) {
      throw new DaoException("Cannot find customer...");
    }

    Customer customer;

    int i = 0;
    do {
      customer = bank.getCustomer(i);
      i++;

      if (i < bank.customersSize()) {
        throw new DaoException();
      }

    } while (customer.getCustomerId() != id);

    return Optional.of(customer);
  }

  @Override
  public List<Customer> findAll() {
    List<Customer> customerList = new ArrayList<>();
    Customer customer;

    for (int i = 0; i < bank.customersSize(); i++) {
      customer = bank.getCustomer(i);
      customerList.add(customer);
    }

    return customerList;
  }

  @Override
  public List<Customer> findByName(String name) throws DaoException {
    if (bank.customersSize() < 1) {
      throw new DaoException();
    }

    List<Customer> customerList = new ArrayList<>();
    Customer customer;

    for (int i = 0; i < bank.customersSize(); i++) {
      customer = bank.getCustomer(i);

      if (customer.getName().equals(name)) {
        customerList.add(customer);
      }
    }

    return customerList;
  }

  @Override
  public List<Customer> findBySurname(String surname) throws DaoException {
    if (bank.customersSize() < 1) {
      throw new DaoException();
    }

    List<Customer> customerList = new ArrayList<>();
    Customer customer;

    for (int i = 0; i < bank.customersSize(); i++) {
      customer = bank.getCustomer(i);

      if (customer.getSurname().equals(surname)) {
        customerList.add(customer);
      }
    }

    return customerList;
  }

  @Override
  public List<Customer> findByPatronymic(String patronymic) throws DaoException {
    if (bank.customersSize() < 1) {
      throw new DaoException();
    }

    List<Customer> customerList = new ArrayList<>();
    Customer customer;

    for (int i = 0; i < bank.customersSize(); i++) {
      customer = bank.getCustomer(i);

      if (customer.getPatronymic().equals(patronymic)) {
        customerList.add(customer);
      }
    }

    return customerList;
  }
}
