/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Smoothie Class- subclass of Beverage
 * Due: 12/04/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
class Smoothie extends Beverage{
    private int numOfFruits;
    private boolean addProtein;
    private final double FRUIT_COST = .5;
    private final double PROTEIN_COST = 1.5;

  //Constructors
    public Smoothie(String n, Size s, int nof, boolean ap) {
        super(n, Type.SMOOTHIE, s);
        numOfFruits = nof;
        addProtein = ap;
    }

   //Utility
    public String toString() {
        String s = getBevName() +", " +getSize() +" " +numOfFruits +" Fruits";

        if (addProtein) {
            s += " Protein powder";
        }

        s += ", $" +calcPrice();

        return s;
    }
    public boolean equals(Smoothie s) {
        if (super.equals(s) && numOfFruits==s.getNumOfFruits() && addProtein==s.getAddProtien()) {
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

        price += numOfFruits * FRUIT_COST;
        if (addProtein) {
            price += PROTEIN_COST;
        }

        return price;
    }

    //Getters
    public int getNumOfFruits() {
        return numOfFruits;
    }
    public boolean getAddProtien() {
        return addProtein;
    }
    public double getFruitCost() {
        return FRUIT_COST;
    }
    public double getProteinCost() {
        return PROTEIN_COST;
    }

    //Setters
    public void setNumOfFruits(int nof) {
        numOfFruits = nof;
    }
    public void setProteinPowder(boolean ap) {
        addProtein = ap;
    }
}