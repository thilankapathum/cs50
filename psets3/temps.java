

class Temps
{
    public static void main(String[] args) 
    {
        int NUM_CITIES = 10;

        avgTemp[] temps = new avgTemp[NUM_CITIES];

        for(int i = 0; i < NUM_CITIES; i++)
        {
            temps[i] = new avgTemp();
        }


        temps[0].city = "Austin";
        temps[0].temp = 97;

        temps[1].city = "Boston";
        temps[1].temp = 82;

        temps[2].city = "Chicago";
        temps[2].temp = 85;

        temps[3].city = "Denver";
        temps[3].temp = 90;

        temps[4].city = "Las Vegas";
        temps[4].temp = 105;

        temps[5].city = "Los Angeles";
        temps[5].temp = 82;

        temps[6].city = "Miami";
        temps[6].temp = 97;

        temps[7].city = "New York";
        temps[7].temp = 85;

        temps[8].city = "Phoenix";
        temps[8].temp = 107;

        temps[9].city = "San Francisco";
        temps[9].temp = 66;

        System.out.println("UNSORTED LIST:");
        for(int i = 0; i < NUM_CITIES; i++)
        {
            System.out.println(temps[i].city + ": " + temps[i].temp);
        }

        // Sort using Selection Sort
        sortCitiesSelection(temps);

        // Sort using Bubble Sort
        //sortCitiesBubble(temps);
    }


    static void sortCitiesSelection(avgTemp[] temps)
    {
        int loops = 0;
        int avgTempLength = temps.length;

        int temporaryLocation = 0;
        avgTemp tempsHolder = new avgTemp();

        // Using temps object array
        // Select for every location in temps array
        for(int i = 0; i < avgTempLength; i++)
        {
            tempsHolder = temps[i];
            temporaryLocation = i;

            // Scan through array for the least number
            for(int j = i; j < avgTempLength; j++)
            {
                if(temps[j].temp < tempsHolder.temp)
                {
                    tempsHolder = temps[j];
                    temporaryLocation = j;

                    // Swap temperature values
                    temps[temporaryLocation] = temps[i];
                    temps[i] = tempsHolder;
                }
                loops++;
            }
        }

        // Print sorted array
        System.out.println("\nSorted List (Selection): ");
        for(int i = avgTempLength; i > 0; i--)
        {
            System.out.println(temps[i-1].city + ": " + temps[i-1].temp);
        }

        System.out.println(loops);

    }


    static void sortCitiesBubble(avgTemp[] temps)
    {
        int tempsLength = temps.length;
        avgTemp tempsPlaceholder = new avgTemp();
        int swapCounter = 0;
        int loops = 0;

        do{
            swapCounter = 0;
            for(int i = 0; i < tempsLength-1; i++)
            {

                // Check next temperature smaller than current
                if(temps[i].temp > temps[i+1].temp)
                {
                    // Swap current and next temperatures
                    tempsPlaceholder = temps[i+1];
                    temps[i+1] = temps[i];
                    temps[i] = tempsPlaceholder;
                    swapCounter++;
                }
                loops++;
            }
        }
        while(swapCounter > 0); // Do until no swaps occur
        

        // Print sorted array
        System.out.println("\nSorted List (Bubble): ");
        for(int i = tempsLength; i > 0; i--)
        {
            System.out.println(temps[i-1].city + ": " + temps[i-1].temp);
        }

        System.out.println(loops);
    }   
}


class avgTemp
{
    
    String city;
    int temp;
    
}