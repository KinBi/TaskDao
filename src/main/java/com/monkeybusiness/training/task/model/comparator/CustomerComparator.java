package com.monkeybusiness.training.task.model.comparator;

import com.monkeybusiness.training.task.model.entity.Customer;

import java.util.Comparator;

public enum CustomerComparator implements Comparator<Customer> {
  ID {
    @Override
    public int compare(Customer o1, Customer o2) {
      return Long.compare(o1.getCustomerId(), o2.getCustomerId());
    }
  },

  NAME {
    @Override
    public int compare(Customer o1, Customer o2) {
      return o1.getName().compareTo(o2.getName());
    }
  }
}
