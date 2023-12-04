/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Coffee Class- subclass of Beverage
 * Due: 12/04/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
class Coffee extends Beverage{
    private boolean extraShot;
    private boolean extraSyrup;
    private final double SHOT_COST = .5;
    private final double SYRUP_COST = .5;

    //Constructor
    public Coffee(String n, Size s, boolean shot, boolean syrup) {
        super(n, Type.COFFEE, s);
        extraShot = shot;
        extraSyrup = syrup;
    }

    //Utility
    public String toString() {
        String s = getBevName() +", " +getSize();

        if (extraShot) {
            s += " Extra shot";
        }
        if (extraSyrup) {
            s += " Extra syrup";
        }

        s += ", $" +calcPrice();

        return s;
    }
    public double calcPrice() {
        double price = super.getBasePrice();

        if (super.getSize() == Size.MEDIUM) {
            price += super.getSizePrice();
        }
        else if (super.getSize() == Size.LARGE) {
            price += 2 * super.getSizePrice();
        }

        if (extraShot) {
            price += SHOT_COST;
        }
        if (extraSyrup) {
            price += SYRUP_COST;
        }

        return price;
    }
    public boolean equals(Coffee c) {
        if (super.equals(c) && extraShot==c.getExtraShot() && extraSyrup==c.getExtraSyrup()) {
            return true;
        }
        else {
            return false;
        }
    }

//Getters
    public boolean getExtraShot() {
        return extraShot;
    }
    public boolean getExtraSyrup() {
        return extraSyrup;
    }
    public double getShotCost() {
        return SHOT_COST;
    }
    public double getSyrupCost() {
        return SYRUP_COST;
    }

    //Setters
    public void setExtraShot(boolean shot) {
        extraShot = shot;
    }
    public void setExtraSyrup(boolean syrup) {
        extraSyrup = syrup;
    }
}