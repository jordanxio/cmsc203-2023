/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Size enum- manges sizes for drinks
 * Due: 12/04/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
public enum Size {
    SMALL,
    MEDIUM,
    LARGE;

    public static Size valueOfIgnoreCase(String name) {
        for (Size Size : Size.values()) {
            if (Size.name().equalsIgnoreCase(name)) {
                return Size;
            }
        }
        throw new IllegalArgumentException("No enum constant " + Size.class.getName() + "." + name);
    }
}
