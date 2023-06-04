import java.util.Scanner;

class Substitution
{
    public static void main(String[] args)
    {
        String keyString;

        keyString = getString("Enter key: ");
        keyString = keyString.toUpperCase();
        
        if(keyString.length() != 26)
        {
            System.out.println("Enter valid Key.");
        }
        else
        {
            char keyArray[] = keyString.toCharArray();

            String plainText = getString("Plain text: ");
            int plainTextLength = plainText.length();
            char plainTextArray[] = plainText.toCharArray();
            int plainTextInt = 0;

            int cypherTextInt = 0;
            char cypherTextArray[] = new char[plainTextLength];

            for(int i = 0; i < plainTextLength; i++)
            {
                // Assign character's int value of user input text to plainTextInt
                plainTextInt = plainTextArray[i];

                // Check for Uppercase letters
                if(plainTextInt >= 65 && plainTextInt <= 90)
                {
                    plainTextInt = plainTextArray[i] - 65; // substracted 65 to match location with keyArray
                    cypherTextArray[i] = keyArray[plainTextInt];
                }
                // Check for Lowecase letters
                else if(plainTextInt >= 97 && plainTextInt <= 122)
                {
                    plainTextInt = plainTextArray[i] - 97;
                    cypherTextInt = keyArray[plainTextInt] + 32; // +32 to re-assign LowerCase
                    cypherTextArray[i] = (char)cypherTextInt;
                }
                // Other characters
                else
                {
                    cypherTextArray[i] = plainTextArray[i];
                }

                System.out.print(cypherTextArray[i]);

            }
            
        }
        
    }

    // Create getString
    static String getString(String message)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String returnString = sc.nextLine();

        //sc.close();
        return returnString;
    }
}