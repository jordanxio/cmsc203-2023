/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Order Class- helps with actual orders
 * Due: 12/04/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
import java.util.ArrayList;
import java.util.Random;

class Order implements OrderInterface, Comparable<Order> {
    private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    //Constructors
    public Order(int ot, Day od, Customer c) {
        orderNo = genOrderNum();
        orderTime = ot;
        orderDay = od;
        customer = c;
        beverages = new ArrayList<>();
    }
    public int genOrderNum() {
        Random rand = new Random();
// [10_000, 90_000)
        int randInt = rand.nextInt(90_000-10_000)+10_000;
        return randInt;
    }
    public String toString() {
        String s = "____________"
                +orderDay.toString() +", " +orderTime
                +"\n" +customer.toString() +" Order Num: " +orderNo;

        for (Beverage b : beverages) {
            s += "\n" +b.toString();
        }
        s += "\n Order Total: " +calcOrderTotal();

        return s;
    }
    public boolean isWeekend() {
        if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
            return true;
        }
        return false;
    }
    public Beverage getBeverage(int itemNum) {
        return beverages.get(itemNum);
    }
    public int compareTo1(Order o) {
        if (orderNo == o.getOrderNo()) {
            return 0;
        }
        else if (orderNo > o.getOrderNo()) {
            return 1;
        }
        else {
            return -1;
        }
    }
    public double calcOrderTotal() {
        double orderTotal = 0;

        for (Beverage b : beverages) {
            orderTotal += b.calcPrice();
        }

        return orderTotal;
    }
    public int findNumOfBeveType(Type type) {
        int count = 0;

        for (Beverage b : beverages) {
            if (b.getType() == type) {
                count++;
            }
        }

        return count;
    }
    public int getTotalItems() {
        return beverages.size();
    }

    //Add Beverages/Drinks
    public void addNewBeverage(String name, Size size, boolean extraShot, boolean extraSyrup) {
        Coffee c = new Coffee(name, size, extraShot, extraSyrup);
        beverages.add(c);
    }
    public void addNewBeverage(String name, Size size, int numOfFruits, boolean proteinPowder) {
        Smoothie s = new Smoothie(name, size, numOfFruits, proteinPowder);
        beverages.add(s);
    }
    public void addNewBeverage(String name, Size size) {
        Alcohol a = new Alcohol(name, size, isWeekend()); // Pass the isWeekend information to Alcohol
        beverages.add(a);
    }


    //getters
    public int getOrderNo() {
        return orderNo;
    }
    public int getOrderTime() {
        return orderTime;
    }
    public Day getOrderDay() {
        return orderDay;
    }
    public Customer getCustomer() {
        return new Customer(customer);
    }
    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    //Setters
    public void setOrderNum(int on) {
        orderNo = on;
    }
    public void setOrderTime(int ot) {
        orderTime = ot;
    }
    public void setOrderDay(Day od) {
        orderDay = od;
    }
    public void setCustomer(Customer c) {
        customer = c;
    }
    @Override
    public int compareTo(Order arg0) {
// TODO Auto-generated method stub
        return 0;
    }
}