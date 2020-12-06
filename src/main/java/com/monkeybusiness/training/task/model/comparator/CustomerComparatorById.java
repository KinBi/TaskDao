package com.monkeybusiness.training.task.model.comparator;

import com.monkeybusiness.training.task.model.entity.Customer;

import java.util.Comparator;

public class CustomerComparatorById implements Comparator<Customer> {
  @Override
  public int compare(Customer o1, Customer o2) {
    long id1 = o1.getCustomerId();
    long id2 = o2.getCustomerId();

    return Long.compare(id1, id2);
  }
}
