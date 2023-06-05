

class Wordle
{
    public static void main(String[] args)
    {
        String wordle = "SINCE";

        System.out.println(wordle);

        char wordleArray[] = wordle.toCharArray();
        int wordleLength = 5;

        String guess = "ABDFG";
        System.out.println(guess);
        char guessArray[] = guess.toCharArray();
        int resultArray[] = new int[wordleLength];

        // Check each letter of guessArray
        for(int i = 0; i < wordleLength; i++)
        {
            if(guessArray[i] == wordleArray[i])
            {
                resultArray[i] = 2;
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
            }
            System.out.print(resultArray[i]);
        }

    }
}