import java.util.Scanner;

class Bulbs
{
    public static void main(String[] args)
    {
        String userInput = getString();
        printBulb(userInput);
        
    }

    // Create getString
    static String getString()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Message: ");
        String returnString = sc.nextLine();

        sc.close();
        return returnString;
    }

    // Create printBulb to print the output
    static void printBulb(String s)
    {
        int stringLength = s.length();
        char charArray[] = s.toCharArray();

        for(int j = 0; j < stringLength; j++)
        {
            int inte = (int) charArray[j];

            double div = 0;
            double rem = 0;
            
            // Print bits of single character
            for(int i = 7; i >= 0; i--)
            {
                div = inte / Math.pow(2, i);
                rem = inte % Math.pow(2, i);
                inte = (int)rem;
                System.out.print((int)div);
            }
            System.out.println();
        }
    }
}