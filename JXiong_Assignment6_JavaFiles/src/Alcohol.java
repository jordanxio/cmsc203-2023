/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Alcohol Class- subclass of Beverage
 * Due: 12/04/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
class Alcohol extends Beverage{
    private boolean isWeekend;
    private static final double  WEEKEND_FEE = .6;

    //Constructors
    public Alcohol(String n, Size s, boolean isWeekend) {
        super(n, Type.ALCOHOL, s);
        this.isWeekend = isWeekend;

    }


    public String toString() {
        String s = getBevName() +", " +getSize();

        if (isWeekend) {
            s += " Weekend";
        }
        s += ", $" +calcPrice();
        return s;
    }
    public boolean equals(Alcohol a) {
        if (super.equals(a) && isWeekend == a.getIsWeekend()) {
            return true;
        }
        else {
            return false;
        }
    }
    public double calcPrice() {
        double price = super.getBasePrice();

        if (super.getSize() == Size.MEDIUM) {
            price += super.getSizePrice();
        }
        else if (super.getSize() == Size.LARGE) {
            price += 2 * super.getSizePrice();
        }

        if (isWeekend) {
            price += WEEKEND_FEE;
        }

        return price;
    }
    public boolean getIsWeekend() {
        return isWeekend;
    }
    public double getWeekendFee() {
        return WEEKEND_FEE;
    }

    /** Mutators */
    public void setIsWeekend(boolean is) {
        isWeekend = is;
    }
}