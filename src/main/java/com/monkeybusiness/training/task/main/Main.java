package com.monkeybusiness.training.task.main;

import com.monkeybusiness.training.task.model.entity.Customer;
import com.monkeybusiness.training.task.model.service.impl.CustomerServiceImpl;
import com.monkeybusiness.training.task.util.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
  private static final Logger logger = LogManager.getLogger();

  public static void main(String[] args) {
    logger.info("Program started");
    DataReader reader = new DataReader();
    List<Customer> customerList = reader.readCustomerFromFile();

    CustomerServiceImpl customerService = new CustomerServiceImpl();
    customerService.addAll(customerList);
  }
}
