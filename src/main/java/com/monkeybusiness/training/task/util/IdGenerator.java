package com.monkeybusiness.training.task.util;

public class IdGenerator {
  private static long id = 1l;

  private IdGenerator() {
    
  }

  public static long getNewId() {
    return id++;
  }
}
