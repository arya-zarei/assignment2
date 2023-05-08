public class LinearNode<T> 
{
	/**LinearNode represents a node in a linked list.**/
	private LinearNode<T> next; //LinearNode variable next
	private T element; //current element variable 
	
	public LinearNode () //Creates an empty node.
	{
		next = null;
		element = null;
	}

	//Creates a node storing the specified element.
	//the element to be stored within the new node
	
	public LinearNode (T elem) 
	{
		next = null;
		element = elem;
	}
	
	public LinearNode<T> getNext () 
	{
		return next; //Returns the node that follows the current one.
	}
	    
	public void setNext (LinearNode<T> node)//Sets the node that follows this one.
	{
		next = node;
	}
	    
	public T getElement () 
	{
		return element; //Returns the element stored in this node.
	}
	    
	public void setElement (T elem) 
	{
		element = elem; //Sets the element stored in this node.
	}
}