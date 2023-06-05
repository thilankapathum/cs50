import java.util.Scanner;

class Wordle
{
    public static void main(String[] args)
    {
        int wordleLength = 0;
        int noOfTrys = 6;

        // Get user input for word length
        do
        {
            wordleLength = getInt("Word Size (4-6 letters): ");
        }
        while(wordleLength < 4 || wordleLength > 6);

        // Set random word as the wordle word
        String wordle = randomWord(wordleLength);

        // Assign wordle in char array
        char wordleArray[] = wordle.toCharArray();

        // Create array of Strings with each user input word
        String guessStringArray[] = new String[noOfTrys];

        // Allow user to try for noOfTrys
        for(int k = 0; k < noOfTrys; k++)
        {
            // Get user input word
            do
            {
                guessStringArray[k] = getString("Enter wordle: ").toUpperCase();
            }
            while (guessStringArray[k].length() != wordleLength);

            System.out.println("Guess " + (k+1) + ": " + guessStringArray[k]);
            System.out.print("Score " + (k+1) + ": ");

            // parse current user's word into a char array
            char guessArray[] = guessStringArray[k].toCharArray();

            int resultArray[] = new int[wordleLength];

            // To check all letters are matching
            boolean matched = true;

            // Check each letter of guessArray
            for(int i = 0; i < wordleLength; i++)
            {
                // Check whether same location has same letter
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
                // Print result for the letter (2 for match position, 1 for letter available, 0 not available)
                System.out.print(resultArray[i]);
            } 

            System.out.println();

            if(matched)
            {
                System.out.println("You Won!");
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

    // Generate random wordleLength letter word
    static String randomWord(int i)
    {
        String wordle5[] = {"SINCE", "OCCUR", "FAINT", "WASTE", "EMPTY", "BLAME", "CREEP", "SHIFT", "ABUSE","THROW"};
        String wordle4[] = {"AUTO", "BUMP", "CROW", "GOLD", "JAZZ", "LIFT", "PASS", "SICK", "SHOT", "TRAY"};
        String wordle6[] = {"PUZZLE", "QUIRKY", "CASUAL", "CHURCH", "DANGER","BEAUTY", "ENGINE", "PEOPLE", "FATHER", "HEALTH"};

        int randomInt = (int)Math.floor(Math.random()*10);
        System.out.println(randomInt);
        String returnString = "";

        switch(i)
        {
            case 4:
                returnString = wordle4[randomInt];
                break;
            case 5:
                returnString = wordle5[randomInt];
                break;
            case 6:
                returnString = wordle6[randomInt];
                break;
            default:
                System.out.println("Default Error in Case!");
                break;

        }
        return returnString;
    }
}