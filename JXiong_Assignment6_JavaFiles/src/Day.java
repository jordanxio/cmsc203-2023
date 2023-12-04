
/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: Day enum - manages days
 * Due: 12/04/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/public enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static Day valueOfIgnoreCase(String name) {
        for (Day Day : Day.values()) {
            if (Day.name().equalsIgnoreCase(name)) {
                return Day;
            }
        }
        throw new IllegalArgumentException("No enum constant " + Day.class.getName() + "." + name);
    }



}

