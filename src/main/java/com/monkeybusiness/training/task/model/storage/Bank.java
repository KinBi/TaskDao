package com.monkeybusiness.training.task.model.storage;

import com.monkeybusiness.training.task.model.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class Bank {
  private static final Bank instance = new Bank();
  private List<Customer> customersList;

  private Bank() {
    this.customersList = new ArrayList<>();
  }

  public static Bank getInstance() {
    return instance;
  }

  public Customer getCustomer(int index) {
    return customersList.get(index);
  }

  public int indexOf(Customer customer) {
    return customersList.indexOf(customer);
  }

  public void setCustomer(int index, Customer customer) {
    customersList.set(index, customer);
  }

  public void addCustomer(Customer customer) {
    customersList.add(customer);
  }

  public void remove(Customer customer) {
    customersList.remove(customer);
  }

  public int customersSize() {
    return customersList.size();
  }

  public boolean contains(Customer customer) {
    return customersList.contains(customer);
  }
}
