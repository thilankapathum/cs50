import java.util.Scanner;
class Llama{
    public static void main(String[] args) 
    {

        // Create Scanner object to get user input
        Scanner sc = new Scanner(System.in);
        String userInputString;

        // Initialize variables
        int startSize = 0;
        int endSize = 0;
        int i = 0;

        do
        {
            System.out.println("Enter Start Size: ");
            userInputString = sc.nextLine();

            // Parse user input from String to int
            startSize = Integer.parseInt(userInputString);

        } while(startSize < 9);

        do
        {
            System.out.println("Enter End Size: ");
            userInputString = sc.nextLine();

            // Parse user input from String to int
            endSize = Integer.parseInt(userInputString);

        } while(endSize < startSize);
        
        sc.close();

        for(i = 0; startSize <= endSize; i++)
        {
            startSize = startSize + startSize/3 - startSize/4 - startSize%3 + startSize%4;
        }
        
        System.out.println("Years: " + i);
    
    }
}