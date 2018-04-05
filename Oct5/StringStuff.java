public class StringStuff {

    public static void main(String [] args) {
        String nameForwards = "Froto Baqgins";
        String nameFlipped = nameForwards.substring(nameForwards.indexOf(" ")) + ", "
            + nameForwards.substring(0, nameForwards.indexOf(" "));
        
        System.out.println(nameFlipped);

    }
}