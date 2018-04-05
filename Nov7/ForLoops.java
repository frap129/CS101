public class ForLoops {
    public static void main(String [] args) {
        String s = "gimme a sodie pop yo";
        System.out.print(reversed(s));
    }
    
    public static String reversed(String s){
        String reverse = "";
        for (int i = s.length(); i >= 0; i--) {
            reverse += s.charAt(i - 1);
        }
        
        return reverse;
    }
}