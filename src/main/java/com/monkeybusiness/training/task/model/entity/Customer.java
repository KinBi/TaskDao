package com.monkeybusiness.training.task.model.entity;

import com.monkeybusiness.training.task.util.IdGenerator;

public class Customer {
  private long customerId;
  private String name;
  private String surname;
  private String patronymic;
  private String address;
  private int creditCardNumber;
  private int bankAccountNumber;

  public Customer() {
    this.customerId = IdGenerator.getNewId();
    this.surname = "";
    this.name = "";
    this.patronymic = "";
    this.address = "";
    this.creditCardNumber = -1;
    this.bankAccountNumber = -1;
  }

  public Customer(String surname, String name, String patronymic, String address, int creditCardNumber, int bankAccountNumber) {
    this.customerId = IdGenerator.getNewId();
    this.surname = surname;
    this.name = name;
    this.patronymic = patronymic;
    this.address = address;
    this.creditCardNumber = creditCardNumber;
    this.bankAccountNumber = bankAccountNumber;
  }

  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(int creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public int getBankAccountNumber() {
    return bankAccountNumber;
  }

  public void setBankAccountNumber(int bankAccountNumber) {
    this.bankAccountNumber = bankAccountNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Customer customer = (Customer) o;

    if (customerId != customer.customerId) return false;
    if (creditCardNumber != customer.creditCardNumber) return false;
    if (bankAccountNumber != customer.bankAccountNumber) return false;
    if (surname != null ? !surname.equals(customer.surname) : customer.surname != null) return false;
    if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
    if (patronymic != null ? !patronymic.equals(customer.patronymic) : customer.patronymic != null) return false;
    return address != null ? address.equals(customer.address) : customer.address == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (customerId ^ (customerId >>> 32));
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + creditCardNumber;
    result = 31 * result + bankAccountNumber;
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Customer{");
    sb.append("customerId=").append(customerId);
    sb.append(", surname='").append(surname).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", patronymic='").append(patronymic).append('\'');
    sb.append(", address='").append(address).append('\'');
    sb.append(", creditCardNumber=").append(creditCardNumber);
    sb.append(", bankAccountNumber=").append(bankAccountNumber);
    sb.append('}');
    return sb.toString();
  }
}
