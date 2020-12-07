package com.monkeybusiness.training.task.model.dao;

import com.monkeybusiness.training.task.exception.DaoException;
import com.monkeybusiness.training.task.model.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
  void add(Customer customer) throws DaoException;

  void addAll(List<Customer> customerList) throws DaoException;

  void remove(Customer customer) throws DaoException;

  void removeAll() throws DaoException;

  void updateCustomerName(long id, String name) throws DaoException;

  void updateAll(List<Customer> customerList) throws DaoException;

  Optional<Customer> findById(long id) throws DaoException;

  List<Customer> findAll();

  List<Customer> findByName(String name) throws DaoException;

  List<Customer> findBySurname(String surname) throws DaoException;

  List<Customer> findByPatronymic(String patronymic) throws DaoException;
}
