/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Customer Class- Aids with orders
 * Due: 12/04/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
class Customer {
    private String name;
    private int age;

    //Constructors
    public Customer(String n, int a) {
        name = n;
        age = a;
    }
    public Customer(Customer c) {
        name = c.getName();
        age = c.getAge();
    }

   //Utility
    public String toString() {
        return name +", " +age +"y/o";
    }

    //Getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    //Setters
    public void setName(String n) {
        name = n;
    }
    public void setAge(int a) {
        age = a;
    }
}