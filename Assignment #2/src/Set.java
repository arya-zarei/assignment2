public class Set<T> //class set with type T
{
	
	private LinearNode<T> setStart; //LinearNode type T variable setStart
	
    public Set() 
    {
        setStart = null; //Initialize setStart to null
    }
    
    public void add(T element) //updates link list / card hand
    {
        LinearNode<T> newNode = new LinearNode<>(element); //Creates newNode containing element
        
       if (setStart == null) // if setStart node is null setStart equals newNode 
       {
            setStart = newNode;
       }
       
       if (!contains(element)) //checks if node does not contain element 
       {
            newNode.setNext(setStart); //goes to the next element  
            setStart = newNode; //add newNode to the linked list
       }
    }
	
	public int getLength() //returns the number of items/cards in the linked list
	{
		int count = 0; //count variable to count length
	    LinearNode<T> temp = setStart; //temporary linked list of setStart
	    
	    while (temp != null) //while list is not empty
	    { 
	    	temp = temp.getNext(); // temporary list goes to next item
	        count++; //go through every item and add one to count for length
	    }
	    return count; //return length
	}
	
	public T getElement(int i) //returns the element stored in the node at index i
	{
		LinearNode<T> temp = setStart; //temporary link list for setStart
	    int index = 0; //index variable 
	   
	    while (temp != null) //goes through list until empty/tail ends
	    {
	        if (index == i) //finds index i
	        {
	            return temp.getElement(); //returns element of index i
	        }
	        temp = temp.getNext(); //goes to next element
	        index++; //goes to next index until index equals i
	    }
	    return null; // when/if index out of bounds returns null
	}
	
	public boolean contains(T element) //finds element in linked list 
	{
		LinearNode<T> temp = setStart; //temporary node equals setStart
		
	    while (temp != null)  //goes through head to tail of temporary list
	    {
	        if (temp.getElement().equals(element))  //if element is found in linked list return true
	        {
	            return true;
	        }
	        temp = temp.getNext(); //next element in temporary
	    }
	    return false; //if element is not found return false
	}
	
	public String toString() //returns string of each element in set
	{
		LinearNode<T> temp = setStart; 
		String cards;
		cards = " "; //empty string
	    
	    while (temp != null) 
	    {
	    	cards += temp.getElement(); //gets element in set and adds it to string
	    	cards += " "; //adds space behind element
	        temp = temp.getNext(); //goes to next element
	    }
	    return cards; //returns string of elements
	 }
}