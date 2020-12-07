package com.monkeybusiness.training.task.model.service.impl;

import com.monkeybusiness.training.task.exception.DaoException;
import com.monkeybusiness.training.task.model.comparator.CustomerComparator;
import com.monkeybusiness.training.task.model.dao.impl.CustomerDaoImpl;
import com.monkeybusiness.training.task.model.entity.Customer;
import com.monkeybusiness.training.task.model.service.CustomerService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
  private static final Logger logger = LogManager.getLogger();
  private static final CustomerDaoImpl customerDao = CustomerDaoImpl.getInstance();

  @Override
  public void add(Customer customer) {
    try {
      customerDao.add(customer);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
    }
  }

  @Override
  public void addAll(List<Customer> customerList) {
    try {
      customerDao.addAll(customerList);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
    }
  }

  @Override
  public void remove(Customer customer) {
    try {
      customerDao.remove(customer);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
    }
  }

  @Override
  public void removeAll() {
    try {
      customerDao.removeAll();
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
    }
  }

  @Override
  public void updateCustomerName(long id, String name) {
    try {
      customerDao.updateCustomerName(id, name);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
    }
  }

  @Override
  public void updateAll(List<Customer> customerList) {
    try {
      customerDao.updateAll(customerList);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
    }
  }

  @Override
  public Optional<Customer> findById(long id) {
    Optional<Customer> optionalCustomer = Optional.empty();

    try {
      optionalCustomer = customerDao.findById(id);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
    }

    return optionalCustomer;
  }

  @Override
  public List<Customer> findAll() {
    List<Customer> customerList = customerDao.findAll();

    return customerList;
  }

  @Override
  public List<Customer> findByName(String name) {
    List<Customer> customerList = new ArrayList<>();

    try {
      customerList = customerDao.findByName(name);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
    }

    return customerList;
  }

  @Override
  public List<Customer> findBySurname(String surname) {
    List<Customer> customerList = new ArrayList<>();

    try {
      customerList = customerDao.findBySurname(surname);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
    }

    return customerList;
  }

  @Override
  public List<Customer> findByPatronymic(String patronymic) {
    List<Customer> customerList = new ArrayList<>();

    try {
      customerList = customerDao.findByPatronymic(patronymic);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
    }

    return customerList;
  }

  @Override
  public void sort(Comparator comparator) {
    List<Customer> customerList = customerDao.findAll();

    customerList.sort(comparator);

    try {
      customerDao.updateAll(customerList);
    } catch (DaoException e) {
      logger.error(Level.ERROR, e);
    }
  }

  @Override
  public void sortById() {
    sort(CustomerComparator.ID);
  }

  @Override
  public void sortByName() {
    sort(CustomerComparator.NAME);
  }
}
