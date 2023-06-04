import java.util.Scanner;

class Caesar
{
    public static void main(String[] args) 
    {        
        int key = getInt("Enter key: ");
        String userWord = getString("Enter plain text: ");

        char plainText[] = userWord.toCharArray();
        int strLength = userWord.length();
        char cipherText[] = new char[strLength];

        for(int i = 0; i < strLength; i++)
        {
            
            // parse char value as an int
            int charInt = (int) plainText[i];

            // variables
            int ascii = 0;
            int modulo = 1;
            int n;
            char convertedChar;

            // Checking for Uppercase or Lowercase or other
            if(charInt >= 65 && charInt <= 90)
            {
                ascii = 65;
                modulo = 26;
                n = 1;
            }
            else if(charInt >= 97 && charInt <= 122)
            {
                ascii = 97;
                modulo = 26;
                n = 1;
            }
            else
            {
                ascii = key;
                modulo = 128;
                n = 0;
            }

            // Encrypting using parsed int value of the char
            int convertedInt = ((charInt + key - ascii) % modulo) + ascii*n;

            // parse converted int value to a char
            convertedChar = (char)convertedInt;

            // Assign encrypted character to cypherText array
            cipherText[i] = convertedChar;
            System.out.print(cipherText[i]);
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

    // Create getInt
    static int getInt(String message)
    {
        int returnInt = 0;
        try {
            Scanner scInt = new Scanner(System.in);
            System.out.print(message);

            while(!scInt.hasNext())
            {
                System.out.print(message);
                scInt.next();

            }

            returnInt = scInt.nextInt();

        } catch (NumberFormatException e) {
            returnInt = getInt(message);
        }

        //scInt.close();
        return returnInt;
    }
}