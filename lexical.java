import java.util.*;

public class Main {
    
    // Function to check if a character is a delimiter
    static boolean isDelimiter(char ch) 
	{
        return " +-*/,;><=()[]{}".indexOf(ch) != -1;
    }

    // Function to check if a character is an operator
    static boolean isOperator(char ch) 
	{
        return "+-*/><=".indexOf(ch) != -1;
    }

    // Function to check if a string is a keyword
    static boolean isKeyword(String str) 
	{
        String[] keywords = {"if", "else", "while", "do", "break", "continue", "int",
                            "double", "float", "return", "char", "case", "sizeof", "long",
                            "short", "typedef", "switch", "unsigned", "void", "static",
                            "struct", "goto"};
        return Arrays.asList(keywords).contains(str);
    }

    // Function to check if a string is a valid identifier
    static boolean isValidIdentifier(String str) 
	{
        return !Character.isDigit(str.charAt(0)) && !isDelimiter(str.charAt(0));
    }

    // Function to check if a string is an integer
    static boolean isInteger(String str) 
	{
        return str.matches("-?\\d+");
    }

    // Function to check if a string is a real number
    static boolean isRealNumber(String str) 
	{
        return str.matches("\\d+\\.\\d+");
    }

    // Function to parse and classify tokens
    static void parse(String str) 
	{
        int left = 0, right = 0;
        int len = str.length();
        
        while (right <= len) 
		{
            if (right == len || isDelimiter(str.charAt(right))) 
			{
                if (left != right) 
				{
                    String subStr = str.substring(left, right);

                    if (isKeyword(subStr))
                        System.out.println("'" + subStr + "' IS A KEYWORD");
                    else if (isInteger(subStr))
                        System.out.println("'" + subStr + "' IS AN INTEGER");
                    else if (isRealNumber(subStr))
                        System.out.println("'" + subStr + "' IS A REAL NUMBER");
                    else if (isValidIdentifier(subStr))
                        System.out.println("'" + subStr + "' IS A VALID IDENTIFIER");
                    else
                        System.out.println("'" + subStr + "' IS NOT A VALID IDENTIFIER");
                }

                if (right < len && isOperator(str.charAt(right)))
                    System.out.println("'" + str.charAt(right) + "' IS AN OPERATOR");
                
                left = right + 1;
            }
            right++;
        }
    }

    // Main function
    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String str = scanner.nextLine();
        scanner.close();
        
        parse(str);
    }
}
