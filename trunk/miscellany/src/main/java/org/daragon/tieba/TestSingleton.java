package org.daragon.tieba;

public class TestSingleton {
    public static void main(String args[]) {
      Database database;

      database = Database.getInstance("products");

      System.out.println("This is the " + database.getName() + " database.");

      database = Database.getInstance("employees");

      System.out.println("This is the " + database.getName() + " database.");
    }
  }

  class Database {
    private static Database singleObject;

    private int record;

    private String name;

    private Database(String n) {
      name = n;
      record = 0;
    }

    public static synchronized Database getInstance(String n) {
      if (singleObject == null) {
        singleObject = new Database(n);
      }

      return singleObject;
    }

    public void editRecord(String operation) {
      System.out.println("Performing a " + operation + " operation on record " + record
          + " in database " + name);
    }

    public String getName() {
      return name;
    }
  }