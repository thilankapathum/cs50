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
            
            int charInt = (int) plainText[i];
            int ascii = 0;
            int modulo = 1;
            int n;
            char convertedChar;

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
            int convertedInt = ((charInt + key - ascii) % modulo) + ascii*n;
            convertedChar = (char)convertedInt;
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
            returnInt = scInt.nextInt();

        } catch (Exception e) {
            returnInt = getInt(message);
        }

        //scInt.close();
        return returnInt;
    }
}