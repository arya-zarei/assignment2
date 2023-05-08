public class Counter //public counter class
{	
	private PowerSet<Card> cardps; // PowerSet variable cardps
    private Card starter; // Card class starter variable 

    public Counter(Card[] hand, Card starter) 
    {
        this.starter = starter; //update starter
        Card[] allCards = new Card[hand.length + 1]; //allCards temporary array = length of Card hand + 1
        
        for (int i = 0; i < hand.length; i++)  //for loop of hand 
        {
            allCards[i] = hand[i]; //allCards at index i = hand at index i
        }
        
        allCards[hand.length] = starter; //allCards hand length = starter
        this.cardps = new PowerSet<>(allCards);// Cardps equals allCards PowerSet
    }
    
    public  int countPoints() //count total points for the game
    {
        int points = 0; //Points calculator variable
        int knob = 0; //HisKnobs points storage
        int isFlush = 0; //isFlush points storage
        int sumsToFifteen = 0; //sumsToFifteen points storage
        int isPair = 0; //isPair points storage
        int isRun3 = 0; //run 3 points storage
        int isRun4 = 0; //run 4 points storage
        int isRun5 = 0; //run 5 points storage
        
        for (int i = 0; i < cardps.getLength(); i++) //goes through length of card sets to calculate points of all cards and sets
        {
            Set<Card> set = cardps.getSet(i); //card set at i
            
            //checks if private helpers below return true, if so adds points accordingly
            
            if (isFlush(set)) //if flush is true
            {
            	if (set.getLength() == 4)
            	{
            		isFlush += 4; //checks if flush length is 4 and adds 4 points
            	}
            	
            	if (set.getLength() == 5)
            	{
            		isFlush = 5;  //checks if flush length is 5 and adds 5 points
            	}
            }
            
            if (sumsToFifteen(set)) //from sumsToFifteen private helper below
            {
            	sumsToFifteen += 2; //if set sums to fifteen adds 2 points to sumsToFifteen storage
            }
                
            if (isPair(set)) //from isPair private helper below
            {
            	isPair += 2; //add two points if set returns true for a pair
            }
                
            if (HisKnobs(set)) //if HisKnobs helper returns true
            {
            	knob = 1; //HisKnobs adds 1 point to total
            } 
                
            if (isRun(set)) //isRun calculator
            {
            	if (set.getLength() == 5) //if isRun returns true and length of set is 3,4, or 5
            	{
            		isRun5 += 5; // if set length is 5 add 5 points to isRun5
            	}
            	
            	if (set.getLength() == 4)
            	{
            		isRun4 += 4; // if set length is 4 add 4 points to isRun5
            	}
            	
            	if (set.getLength() == 3)
            	{
            		isRun3 += 3; // if set length is 3 add 3 points to isRun5
            	}
            }
        }
        
        if (isRun5 >= 5) //if isRun length 5 collects points only add isRun5 points
        {
        	points += isRun5;
        }
        
        if (isRun4 >= 4 && isRun5 == 0) //if isRun highest length is 4 only add isRun4 points
        {
        	points += isRun4;
        }
        
        if (isRun3 >= 3 && (isRun4 == 0 && isRun5 == 0)) //if isRun has points of 3 but not points of 4 or 5 add isRun3 points
        {
        	points += isRun3;
        }
        
        // adds points of all other private helpers to the main points calculator after for loop of points addition
        points += knob;
        points += isFlush;
        points += sumsToFifteen;
        points += isPair;
        
        return points; //return total points of each hand
    }
    
    private boolean isRun (Set<Card> set) //isRun private helper
    {
		int n = set.getLength();
		
		if (n <= 2) 
		{
			return false; // Run must be at least 3 in length.
		}
		
		int[] rankArr = new int[13];
		
		for (int i = 0; i < 13; i++) 
		{
			rankArr[i] = 0; // Ensure the default values are all 0.
		}
		
		for (int i = 0; i < n; i++) 
		{
			rankArr[set.getElement(i).getRunRank()-1] += 1;
		}

		// Now search in the array for a sequence of n consecutive 1's.
		int streak = 0;
		int maxStreak = 0;
		
		for (int i = 0; i < 13; i++) 
		{
			if (rankArr[i] == 1) 
			{
				streak++;
				
				if (streak > maxStreak) 
				{
					maxStreak = streak;
				}
			} 
			
			else 
			{
				streak = 0;
			}
		}
		
		if (maxStreak == n) 
		{ // Check if this is the maximum streak.
			return true;
		} 
		
		else 
		{
			return false;
		}
	}

    private boolean sumsToFifteen(Set<Card> set) //if set label adds to 15
    {
        int sum = 0;
        int n = set.getLength();
        
        for (int i = 0; i < n; i++) //goes through set length
        {
        	sum += set.getElement(i).getFifteenRank(); //adds points to sum based on getFifteenRank method in given Card class
        }
        
        return sum == 15; //returns true if sum value equals 15
    }
    

    // Private helper method to check if a given Set contains a pair
    private boolean isPair(Set<Card> set) 
    {
        int n = set.getLength(); // n is set length to check for pair
        
        if (n != 2) 
        {
            return false; // Pair must have exactly 2 cards.
        }
        
        Card card1 = set.getElement(0);
        Card card2 = set.getElement(1);
        return card1.getLabel().equals(card2.getLabel()); //compares the labels of card 1 and 2 in the set which have index 0 and 1
        //returns true if two card labels equals
    }

    // Private helper method to check if a given Set is a flush
    private boolean isFlush(Set<Card> set) 
    {
        int n = set.getLength(); // n is length of set
        
        if (n != 4 && n != 5) 
        {
            return false; // Flush must have exactly 4 or 5 cards.
        }
        
        String suit = set.getElement(0).getSuit(); //suit of starter card
        
        for (int i = 1; i < n; i++) //goes through all cards in set
        {
            if (!set.getElement(i).getSuit().equals(suit)) //if element in set does not have same suit as starter return false
            {
                return false;
            }
        }
        return true; //if so return true
    }
    
    private boolean HisKnobs(Set<Card> set) //checks if set has His Knobs
    {
    	/** checks if there is a jack (label equals J) in the set if so then it checks if the starter card in the set has the same suit as the jack
    	 if so then true is returned, if not false is returned **/
    	int x = set.getLength();
    	
    	for (int i = 1; i < x; i++)
		{
			if ((set.getElement(i).getLabel().equals("J")) && (set.getElement(i).getSuit().equals(starter.getSuit())))
			{
				return true;
			}
		}
		return false;
	}
}