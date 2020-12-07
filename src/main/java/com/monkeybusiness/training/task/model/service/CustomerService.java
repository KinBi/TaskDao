package com.monkeybusiness.training.task.model.service;

import com.monkeybusiness.training.task.exception.DaoException;
import com.monkeybusiness.training.task.model.entity.Customer;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
  void add(Customer customer);

  void addAll(List<Customer> customerList) throws DaoException;

  void remove(Customer customer) throws DaoException;

  void removeAll() throws DaoException;

  void updateCustomerName(long id, String name);

  void updateAll(List<Customer> customerList) throws DaoException;

  Optional<Customer> findById(long id);

  List<Customer> findAll();

  List<Customer> findByName(String name);

  List<Customer> findBySurname(String surname);

  List<Customer> findByPatronymic(String patronymic);

  void sort(Comparator comparator);

  void sortById();

  void sortByName();
}
