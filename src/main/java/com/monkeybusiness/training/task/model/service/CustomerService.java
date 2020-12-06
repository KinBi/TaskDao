package com.monkeybusiness.training.task.model.service;

import com.monkeybusiness.training.task.exception.DaoException;
import com.monkeybusiness.training.task.model.entity.Customer;

import java.util.Comparator;
import java.util.List;

public interface CustomerService {
  boolean add(Customer customer);

  boolean addAll(List<Customer> customerList) throws DaoException;

  boolean remove(Customer customer) throws DaoException;

  boolean removeAll() throws DaoException;

  void updateCustomerName(long id, String name);

  boolean updateAll(List<Customer> customerList) throws DaoException;

  Customer findById(long id);

  List<Customer> findAll();

  List<Customer> findByName(String name);

  List<Customer> findBySurname(String surname);

  List<Customer> findByPatronymic(String patronymic);

  boolean sort(Comparator comparator);

  boolean sortById();

  boolean sortByName();
}
