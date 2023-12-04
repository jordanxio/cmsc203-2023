/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Type enum- helps distinct types
 * Due: 12/04/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
public enum Type {
    COFFEE,
    SMOOTHIE,
    ALCOHOL;

    public static Type valueOfIgnoreCase(String name) {
        for (Type Type : Type.values()) {
            if (Type.name().equalsIgnoreCase(name)) {
                return Type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + Type.class.getName() + "." + name);
    }
}
