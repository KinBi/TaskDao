package com.monkeybusiness.training.task.model.service.impl;

import com.monkeybusiness.training.task.exception.DaoException;
import com.monkeybusiness.training.task.model.comparator.CustomerComparator;
import com.monkeybusiness.training.task.model.entity.Customer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CustomerServiceImplTest {
  CustomerServiceImpl customerService;
  List<Customer> customerList;
  List<Customer> sortedList;
  Customer customer1;
  Customer customer1updated;
  Customer customer2;
  Customer customer3;

  @BeforeClass
  public void setUp() {
    customerService = new CustomerServiceImpl();
    customer1 = new Customer("Vasua", "Pupkin", "Longin", "tam", 132451, 15345);
    customer1updated = new Customer("NotVasua", "Pupkin", "Longin", "tam", 132451, 15345);
    customer2 = new Customer("Test", "Test", "Test", "aaa", 1, 1);
    customer3 = new Customer("B", "H", "O", "S", 4, 34);
    customerList = new ArrayList<>();
    customerList.add(customer1);
    customerList.add(customer2);
    customerList.add(customer3);
    sortedList = customerList.subList(0, customerList.size());
    sortedList.sort(CustomerComparator.ID);
  }

  @Test
  public void testFindById() {
    customerService.add(customer1);
    Customer expected = customer1;
    Customer actual = customerService.findById(customer1.getCustomerId()).orElse(null);
    assertEquals(expected, actual);
  }

  @Test
  public void testAdd() {
    customerService.add(customer1);

    assertNotNull(customerService.findById(customer1.getCustomerId()));
  }

  @Test
  public void testRemove() {
    customerService.add(customer1);
    customerService.remove(customer1);
    assertNull(customerService.findById(customer1.getCustomerId()).orElse(null));
  }

  @Test
  public void testUpdateCustomerName() {
    customerService.add(customer1);
    customerService.updateCustomerName(customer1.getCustomerId(), customer1updated.getName());
    Customer actual = customerService.findById(customer1.getCustomerId()).orElse(null);
    assertNull(actual);
  }

  @Test
  public void testSortById() throws DaoException {
    List<Customer> expected = sortedList;
    customerService.addAll(customerList);
    List<Customer> actual = customerService.findAll();
    assertEquals(actual, expected);
  }
}