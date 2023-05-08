public class Card //card helper class
{
	private String suit; // S (spade), H (heart), D (diamond), or C (club)
	private String label; // A (ace), 2, 3, ..., 10, J (jack), Q (queen), or K (king)

	public Card (String suit, String label) 
	{
		this.suit = suit; 
		this.label = label;
	}

	public String getSuit () 
	{
		return suit; //return suit variable 
	}
		
	public String getLabel () 
	{
		return label; //return label variable 
	}

	public void setSuit (String suit) 
	{
		this.suit = suit; //gets/update suit
	}
		
	public void setLabel (String label) 
	{
		this.label = label; //gets/update label
	}

	public String toString () 
	{
		return label + " of " + suit; //returns string of card
	}
		
	public int getRunRank () // Get the rank value when it comes to runs (J, Q, and K are distinct!)
	{
		if (label.equals("A")) 
		{
			return 1;
		} 
		
		else if (label.equals("J")) 
		{
			return 11;
		} 
		
		else if (label.equals("Q")) 
		{
			return 12;
		} 
		
		else if (label.equals("K")) 
		{
			return 13;
		} 
		
		else 
		{
			return Integer.parseInt(label);
		}
	}
		
	public int getFifteenRank () // Get the rank value when it comes to fifteens (J, Q, and K are all worth 10!)
	{
		if (label.equals("A")) 
		{
			return 1;
		} 
			
		else if (label.equals("J") || label.equals("Q") || label.equals("K")) 
		{
			return 10;
		} 
			
		else 
		{
			return Integer.parseInt(label);
		}
	}
}