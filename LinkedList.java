public class LinkedList<T> implements List<T>
{
	private int size;
	private Node<T> head;

	//Constructor
	public LinkedList()
	{
		head = new Node<T>(null);	//Dummy head
		size = 0;
	}

	//Inserts element into end of linked list.
	public void add(T item)
	{
		if (size == 0)
		{
			Node<T> newNode = new Node<T>(item);	//Creates a new node for head to point to.
			head = newNode;
			size++;
		}
		else
		{
			Node<T> previous = head;			//Creates a previous node that points to last item in linked list.
			for (int i = 0; i < size - 1; i++)
			{
				previous = previous.get_next();
			}
			Node<T> newNode = new Node<T>(item);	//Creates a new node with the item.
			previous.set_next(newNode);				//Connects previous to the new node we're adding.
			size++;
		}
	}

	//Inserts an element into a certain position.
	public void add(int pos, T item)
	{
		Assert.not_false (pos >= 0 && pos < size + 1);		//Checks to see if the position is valid.
		size++;
		if (pos == 0)							//If inserting to the head, we create a new node before head.
		{
			Node<T> node = new Node<T>(item);
			node.set_next(head);
			head = node;						//The head is now the new inserted node.
		}
		else
		{
			Node<T> previous = head;				//Otherwise, we create previous, which traverses through the list, until it finds the spot before the insertion position.
			for (int i = 0; i < pos - 1; i++)
			{
				previous = previous.get_next();
			}
			Node<T> node = new Node<T>(item);		//New node is placed between previous and the item after previous.
			node.set_next(previous.get_next());	
			previous.set_next(node);				
		}
	}

	//Retrieves an element at a given position.
	public T get(int pos)
	{
		Assert.not_false (pos >= 0 && pos < size);		//Checks to see if given position is valid.
		Node<T> current = head;				//Creates a current node which keeps track of our place in the list; current starts at head.				
		for (int i = 0; i < pos; i++)		//Current traverses through the list until it reaches the position.
		{
			current = current.get_next();
		}
		return current.get_data();			//Current's data is returned.
	}

	//Removes an element at a given position.
	public T remove(int pos)
	{
		Assert.not_false(pos >= 0 && pos < size);	//Checks to see if given position is valid.
		if (pos == 0)						//If removing head, a current node is created and points to the value after head, which becomes the new head.
		{
			Node<T> current = head;
			head = current.get_next();
			size--;
			return current.get_data();
		}
		else									//Otherwise, previous node traverses the list until it reaches the place before the given position.
		{
			Node<T> previous = head;			
			for (int i = 0; i < pos - 1; i++)
			{
				previous = previous.get_next();
			}
			Node<T> current = previous.get_next();		//Current node points to the node at the given position.
			previous.set_next(current.get_next());		//Previous is then connected to the element after current (previous.next.next) (this deletes current).
			size--;
			return current.get_data();
		}
	}

	//Returns the number of elements in the linked list.
	public int size()
	{
		return size;
	}

	//Inner class Node constructs elements of LinkedList.
	public class Node<T>
	{
		public T data;
		public Node<T> next;

		public Node (T data)
		{
			this.data = data;
			next = null;
		}

		public void set_next (Node<T> next)
		{
			this.next = next;
		}

		public void set_data (T data)
		{
			this.data = data;
		}

		public Node<T> get_next()
		{
			return next;
		}

		public T get_data()
		{
			return data;
		}
	}
}