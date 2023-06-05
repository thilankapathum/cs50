import java.util.Scanner;

class Wordle
{
    public static void main(String[] args)
    {
        String wordle = "SINCE";
        //System.out.println(wordle);

        char wordleArray[] = wordle.toCharArray();
        int wordleLength = 0;
        int noOfTrys = 6;

        do
        {
            wordleLength = getInt("Word Size (4-6 letters): ");
        }
        while(wordleLength <= 4 || wordleLength >= 6);

        //String guess = "ABDFG";
        String guessStringArray[] = new String[noOfTrys];

        // Allow user to try for noOfTrys
        for(int k = 0; k < noOfTrys; k++)
        {
            do
            {
                guessStringArray[k] = getString("Enter wordle: ");
            }
            while (guessStringArray[k].length() != wordleLength);

            System.out.println("Guess " + (k+1) + ": " + guessStringArray[k]);
            System.out.print("Marks " + (k+1) + ": ");

            char guessArray[] = guessStringArray[k].toCharArray();
            int resultArray[] = new int[wordleLength];
            boolean matched = true;

            // Check each letter of guessArray
            for(int i = 0; i < wordleLength; i++)
            {
                if(guessArray[i] == wordleArray[i])
                {
                    resultArray[i] = 2;
                    matched = matched && true;
                }
                else
                {
                    // Check current letter at guessArray matching any letter in wordleArray
                    for(int j = 0; j < wordleLength; j++)
                    {

                        if(guessArray[i] == wordleArray[j])
                        {
                            resultArray[i] = 1;
                        }
                    }
                    matched = false;
                }
                System.out.print(resultArray[i]);
            } 

            System.out.println();
            if(matched)
            {
                break;
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