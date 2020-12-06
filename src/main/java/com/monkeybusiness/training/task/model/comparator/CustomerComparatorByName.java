package com.monkeybusiness.training.task.model.comparator;

import com.monkeybusiness.training.task.model.entity.Customer;

import java.util.Comparator;

public class CustomerComparatorByName implements Comparator<Customer> {
  @Override
  public int compare(Customer o1, Customer o2) {
    String name1 = o1.getName();
    String name2 = o2.getName();

    return name1.compareTo(name2);
  }
}
