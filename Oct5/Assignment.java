public class Assignment {

    public static void main(String [] args) {
        String string = "1234";
        String string2 = "0123";
        if (string.equals(string2))
            System.out.println("Strings have equal values!");

        if (string == string2)
            System.out.println("Strings have equal objects!");
    }
}