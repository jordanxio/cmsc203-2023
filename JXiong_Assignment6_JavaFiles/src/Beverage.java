/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Beverage Class - manages drinks
 * Due: 12/04/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
public abstract class Beverage {
    private String name;
    private Type Type;
    private Size Size;
    private static final double BASE_PRICE = 2.0;
    private static final double Size_PRICE = 1.0;

    public Beverage(String n, Type t, Size s) {
        name = n;
        Type = t;
        Size = s;
    }


    public abstract double calcPrice();
    public String toString() {
        return name +", " +Size;
    }
    public boolean equals(Beverage bev) {
        if (name.equals(bev.getBevName()) && Type==bev.getType() && Size==bev.getSize()) {
            return true;
        }
        else {
            return false;
        }
    }

    //Getters
    public String getBevName() {
        return name;
    }
    public Type getType() {
        return Type;
    }
    public Size getSize() {
        return Size;
    }
    public double getBasePrice() {
        return BASE_PRICE;
    }
    public double getSizePrice() {
        return Size_PRICE;
    }

//Setters
    public void setName(String n) {
        name = n;
    }
    public void setType(Type t) {
        Type = t;
    }
    public void setSize(Size s) {
        Size = s;
    }
}