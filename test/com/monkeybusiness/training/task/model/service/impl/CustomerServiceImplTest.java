package com.monkeybusiness.training.task.model.service.impl;

import com.monkeybusiness.training.task.exception.DaoException;
import com.monkeybusiness.training.task.model.comparator.CustomerComparatorById;
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
  Customer customer2;
  Customer customer3;

  @BeforeClass
  public void setUp() {
    customerService = new CustomerServiceImpl();
    customer1 = new Customer("Vasua", "Pupkin", "Longin", "tam", 132451, 15345);
    customer2 = new Customer("Test", "Test", "Test", "aaa", 1, 1);
    customer3 = new Customer("B", "H", "O", "S", 4, 34);
    customerList = new ArrayList<>();
    customerList.add(customer1);
    customerList.add(customer2);
    customerList.add(customer3);
    sortedList = customerList.subList(0, customerList.size());
    sortedList.sort(new CustomerComparatorById());
  }

  @Test
  public void testSortById() throws DaoException {
    List<Customer> expected = sortedList;
    boolean result = customerService.addAll(customerList);
    result = customerService.sortById();
    List<Customer> actual = customerService.findAll();
    assertEquals(actual, expected);
  }
}