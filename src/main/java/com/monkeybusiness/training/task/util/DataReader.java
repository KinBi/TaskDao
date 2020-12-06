package com.monkeybusiness.training.task.util;

import com.monkeybusiness.training.task.model.entity.Customer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {
  private static final Logger logger = LogManager.getLogger();

  private static final String DEFAULT_FILE_PATH = "res/data/customers.txt";
  private static final String FIELD_SEPARATOR = " ";
  private static final String DELIMITER = ";";
  private static final int CUSTOMER_NAME_FIELD_NUM = 0;
  private static final int CUSTOMER_SURNAME_FIELD_NUM = 1;
  private static final int CUSTOMER_PATRONYMIC_FIELD_NUM = 2;
  private static final int CUSTOMER_ADDRESS_FIELD_NUM = 3;
  private static final int CUSTOMER_CREDIT_CARD_FIELD_NUM = 4;
  private static final int CUSTOMER_BANK_ACCOUNT_FIELD_NUM = 5;

  public List<Customer> readCustomerFromFile(String path) {
    Path pathToFile = Paths.get(path);
    List<Customer> customerList = new ArrayList<>();

    try {
      String data = Files.lines(pathToFile).collect(Collectors.joining());
      String[] lines = data.split(DELIMITER);
      for (String line : lines) {
        Customer customer;
        customer = parseCustomer(line);
        customerList.add(customer);
      }
    } catch (IOException e) {
      logger.error(Level.ERROR, e);
    }

    return customerList;
  }

  public List<Customer> readCustomerFromFile() {
    return readCustomerFromFile(DEFAULT_FILE_PATH);
  }

  public Customer parseCustomer(String data) {
    Customer customer;

    String[] fields = data.split(FIELD_SEPARATOR);

    String name = fields[CUSTOMER_NAME_FIELD_NUM].trim();
    String surname = fields[CUSTOMER_SURNAME_FIELD_NUM].trim();
    String patronymic = fields[CUSTOMER_PATRONYMIC_FIELD_NUM].trim();
    String address = fields[CUSTOMER_ADDRESS_FIELD_NUM].trim();
    int creditCard = Integer.parseInt(fields[CUSTOMER_CREDIT_CARD_FIELD_NUM].trim());
    int bankAccount = Integer.parseInt(fields[CUSTOMER_BANK_ACCOUNT_FIELD_NUM].trim());

    customer = new Customer(name, surname, patronymic, address, creditCard, bankAccount);
    return customer;
  }
}
