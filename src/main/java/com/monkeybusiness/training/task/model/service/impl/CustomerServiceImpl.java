package com.monkeybusiness.training.task.model.service.impl;

import com.monkeybusiness.training.task.exception.DaoException;
import com.monkeybusiness.training.task.model.comparator.CustomerComparatorById;
import com.monkeybusiness.training.task.model.comparator.CustomerComparatorByName;
import com.monkeybusiness.training.task.model.dao.impl.CustomerDaoImpl;
import com.monkeybusiness.training.task.model.entity.Customer;
import com.monkeybusiness.training.task.model.service.CustomerService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
  private static final Logger logger = LogManager.getLogger();
  private static final CustomerDaoImpl customerDao = CustomerDaoImpl.getInstance();

  @Override
  public boolean add(Customer customer) {
    boolean result = true;

    try {
      customerDao.add(customer);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
      result = false;
    }

    return result;
  }

  @Override
  public boolean addAll(List<Customer> customerList) {
    boolean result = true;

    try {
      customerDao.addAll(customerList);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
      result = false;
    }

    return result;
  }

  @Override
  public boolean remove(Customer customer) {
    boolean result = true;

    try {
      customerDao.remove(customer);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
      result = false;
    }

    return result;
  }

  @Override
  public boolean removeAll() {
    boolean result = true;

    try {
      customerDao.removeAll();
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
      result = false;
    }

    return result;
  }

  @Override
  public void updateCustomerName(long id, String name) {
    customerDao.updateCustomerName(id, name);
  }

  @Override
  public boolean updateAll(List<Customer> customerList) {
    boolean result = true;

    try {
      customerDao.updateAll(customerList);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
      result = false;
    }

    return result;
  }

  @Override
  public Customer findById(long id) {
    Customer customer = customerDao.findById(id);

    return customer;
  }

  @Override
  public List<Customer> findAll() {
    List<Customer> customerList = customerDao.findAll();

    return customerList;
  }

  @Override
  public List<Customer> findByName(String name) {
    List<Customer> customerList = customerDao.findByName(name);

    return customerList;
  }

  @Override
  public List<Customer> findBySurname(String surname) {
    List<Customer> customerList = customerDao.findBySurname(surname);

    return customerList;
  }

  @Override
  public List<Customer> findByPatronymic(String patronymic) {
    List<Customer> customerList = customerDao.findByPatronymic(patronymic);

    return customerList;
  }

  @Override
  public boolean sort(Comparator comparator) {
    List<Customer> customerList = customerDao.findAll();
    boolean sorted = false;

    while (!sorted) {
      sorted = true;

      for (int i = 0; i < customerList.size() - 1; i++) {
        Customer customer1 = customerList.get(i);
        Customer customer2 = customerList.get(i + 1);
        int compareResult = comparator.compare(customer1, customer2);

        if (compareResult > 0) {
          int customer2Index = customerList.indexOf(customer2);
          int customer1Index = customerList.indexOf(customer1);
          customerList.set(customer2Index, customer1);
          customerList.set(customer1Index, customer2);
          sorted = false;
        }
      }
    }

    try {
      customerDao.updateAll(customerList);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
      sorted = false;
    }

    return sorted;
  }

  @Override
  public boolean sortById() {
    Comparator<Customer> customerComparator = new CustomerComparatorById();
    boolean sorted = sort(customerComparator);
    return sorted;
  }

  @Override
  public boolean sortByName() {
    Comparator<Customer> customerComparator = new CustomerComparatorByName();
    boolean sorted = sort(customerComparator);
    return sorted;
  }
}
