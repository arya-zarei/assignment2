public class PowerSet<T> //class PowerSet with type T
{
	private Set<T>[] set; //private linked list stores the sets generated
	
	public PowerSet(T[] elements) 
	/** creates power set of base 2 to the power of the number of items in the set for example if the set is {"C","6","D","4","S","5","C","J","C","3"}
	 it is 6C,4D,5S,JC,3C which is 5 cards. 2 ** 5 = 32. In the PowerSet all 32 lists are generated to calculate points from. **/
	{
		Set<T> inputSet = new Set<T>(); //inputSet instance variable 
	    
		for (T element : elements) // T element goes through all of elements
	    {
	        inputSet.add(element); //adds T element to inputSet
	    }
		
	    int inputSetSize = inputSet.getLength(); //inputSetSize with length of inputSet
	    int powerSetSize = (int) Math.pow(2, inputSetSize); //power set generation 2 ** number of items = number of sets gets all possible lists 
	    
	    set = new Set[powerSetSize]; //set array variable 

	    for (int i = 0; i < powerSetSize; i++) //for loop to go through every set
	    {
	        set[i] = new Set<T>(); //set index i equals set<T>
	        
	        for (int j = 0; j < inputSetSize; j++)  //goes through element of set
	        {
	        	if ((i & (1<<j)) > 0) //checks the j bit of i
	            {
	        		set[i].add(inputSet.getElement(j)); //adds elements to each set
	            }
	        }
	    }
	}
	
	public int getLength()
	{
		return set.length; //returns number of items in array (number of sets in powerSet)
	}
	
	public Set<T> getSet(int i)
	{
		return set[i]; //returns set array at index i
	}
}