import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of Productions: ");
        int num = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter the grammar as A -> Aa / b:");
        while (num-- > 0) eliminateLeftRecursion(scanner.nextLine().trim());
        
        scanner.close();
    }

    public static void eliminateLeftRecursion(String production) {
        String[] parts = production.split("->");
        char nonTerminal = parts[0].charAt(0);
        String[] choices = parts[1].split("/");

        System.out.println("GRAMMAR: " + production);
        if (choices[0].startsWith("" + nonTerminal)) {
            System.out.println(nonTerminal + " is left recursive.");
            System.out.println(nonTerminal + " -> " + choices[1].trim() + nonTerminal + "'");
            System.out.println(nonTerminal + "' -> " + choices[0].substring(1) + nonTerminal + "' / epsilon");
        } else {
            System.out.println(nonTerminal + " is not left recursive.");
        }
    }
}
