class Runoff{
    public static void main(String[] args){
        
        int candidateCount = 3;
        int voterCount = 5;

        // Sample candidates
        String[] candidatesStr = {"Alice", "Bob", "Charlie"};

        // Create Candidates Object
        Candidates[] candidates = new Candidates[candidateCount];

        // Initialize Candidates Object with Names
        for(int i = 0; i < candidateCount; i++){
            candidates[i] = new Candidates();
            candidates[i].name = candidatesStr[i];
            candidates[i].eliminated = false;
        }

        // Create Voter's Preferences
        //int preferences[][] = new int[voterCount][candidateCount];
        //int preferences[][] = {{0,1,2},{0,2,1},{1,2,0},{1,0,2},{2,0,1}};
        //int preferences[][] = {{0,1,2},{0,1,2},{0,2,1},{1,2,0},{1,2,0},{1,0,2},{2,0,1},{2,1,0}};
        int preferences[][] = {{0,1,2},{0,1,2},{1,0,2},{1,0,2},{1,0,2},{2,0,1},{2,0,1},{2,1,0},{2,1,0}};

        voterCount = preferences.length;

        System.out.println("Candidates count: " + candidateCount);
        System.out.println("Voters count: " + voterCount);

        // Vote
        vote(voterCount, preferences, candidates);

        // Check winner
        while(!printWinner(candidates, voterCount)){
            
            // find Minimum Vote
            int minVotes = findMin(candidates);

            if(isTie(candidateCount, candidates, minVotes)){
                System.out.println("Tie!");

                // Print tied Candidates
                for(int i = 0; i < candidateCount; i++){
                    if(!candidates[i].eliminated){
                        System.out.println(candidates[i].name);
                    }
                }
                break;
            }

            // Eliminate minimum voter
            eliminate(minVotes, candidates,preferences);
        }

        // Print all candidates votes (temp)
        /* for(int i = 0; i < candidateCount; i++){
            System.out.println(candidates[i].name + candidates[i].votes + candidates[i].eliminated);
        } */

    }

    // Cast Vote
    static void vote(int voterCount, int preferences[][], Candidates[] candidates){
        for(int i = 0; i < voterCount; i++){
            int votedTo = preferences[i][0];
            //System.out.println(preferences[i][0]);

            candidates[votedTo].votes++;
        }
    }

    static int findMin(Candidates[] candidates){
        int minVotes = 2147483647;
        int candidateCount = candidates.length;

        for(int i = 0; i < candidateCount; i++){
            if(candidates[i].votes < minVotes && candidates[i].eliminated == false){
                minVotes = candidates[i].votes;
            }
        }
        return minVotes;
    }

    // Eliminate least voted candidate
    static void eliminate(int minVotes, Candidates[] candidates, int[][] preferences){
        int candidateCount = candidates.length;
        int prefLength = preferences.length;

        // Checking for candidates with min Votes
        for(int i = 0; i < candidateCount; i++){
            if(candidates[i].votes == minVotes && !candidates[i].eliminated){

                // Increase Votes for the next prefered candidate of the voter
                for(int j = 0; j < prefLength; j++){
                    if(preferences[j][0] == i){
                        candidates[preferences[j][1]].votes++;
                    }
                }
                candidates[i].eliminated = true;
                //System.out.println(candidates[i].name + " is eliminated");

            }
        }
    }

    // Check for Winner
    static boolean printWinner(Candidates[] candidates, int voterCount){
        int maxVotes = 0;
        int candidateCount = candidates.length;
        boolean returnBoolean = false;

        // Find maximum votes
        for(int i = 0; i < candidateCount; i++){
            if(candidates[i].votes > maxVotes){
                maxVotes = candidates[i].votes;
            }
        }

        // Check for 50% and more dominance
        if((double)maxVotes/(double)voterCount > 0.5){
            for(int i = 0; i < candidateCount; i++){
                if(maxVotes == candidates[i].votes){
                    System.out.println("Winner: " + candidates[i].name);
                    break;
                }
            }
            returnBoolean = true;
        }else{
            //System.out.println("No 50% winner");
            returnBoolean = false;
        }

        return returnBoolean;
    }

    // Check for Tie in votes
    static boolean isTie(int candidateCount, Candidates[] candidates, int minVotes){
        
        boolean tieCheck = true;
        for(int i = 0; i < candidateCount; i++){

            // Considering non-eliminated candidates only
            if(!candidates[i].eliminated){
                if(candidates[i].votes == minVotes){
                    tieCheck = tieCheck && true;
                        
                }else{
                    tieCheck = false;
                }
            }
        }
        return tieCheck;
    }
}

class Candidates{
    String name;
    int votes;
    boolean eliminated;
}