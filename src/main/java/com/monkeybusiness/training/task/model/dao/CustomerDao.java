package com.monkeybusiness.training.task.model.dao;

import com.monkeybusiness.training.task.exception.DaoException;
import com.monkeybusiness.training.task.model.entity.Customer;

import java.util.List;

public interface CustomerDao {
  void add(Customer customer) throws DaoException;

  void addAll(List<Customer> customerList) throws DaoException;

  void remove(Customer customer) throws DaoException;

  void removeAll() throws DaoException;

  void updateCustomerName(long id, String name);

  void updateAll(List<Customer> customerList) throws DaoException;

  Customer findById(long id);

  List<Customer> findAll();

  List<Customer> findByName(String name);

  List<Customer> findBySurname(String surname);

  List<Customer> findByPatronymic(String patronymic);
}
