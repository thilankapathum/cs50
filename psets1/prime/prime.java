import java.util.Scanner;

class Prime
{
    public static void main(String[] args)
    {

        // Create Scanner object to get user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int userInput = sc.nextInt();

        sc.close();

        // Initialize Boolean catch modulo (divisibility)
        boolean checkPrime = false;

        // Checking each number from 1 to userInput
        for(int j = 1; j < userInput; j++)
        {
            // Initialize Boolean for each loop
            checkPrime = false;

            // Check whether the number is divisible by its predecessors
            for(int k = 2; k < j; k++)
            {

                // Checking modulo for divisibility
                if(j%k == 0)
                {
                    checkPrime = true;

                    // breaking 'for' loop to prevent unnecessary repetitions
                    break;
                }
            }

            // Print number as a prime if modulo were not zero
            if(!checkPrime)
            {
                System.out.println(j);
            }
        }
    }
}