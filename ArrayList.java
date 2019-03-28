public class ArrayList<T> implements List<T>
{
	private Object[] tempArray = new Object[10];
	private T[] arr;
	private int size;

	//Constructor
	ArrayList()
	{
		arr = (T[]) tempArray;
		size = 0;
	}

	//Adds element to end of arraylist.
	public void add(T item)
	{
		try
		{
			Assert.not_false(size < arr.length);	//Checks to see if array is large enough.
		}
		catch (Exception e)
		{
			grow_list();			//Doubles the array's size if not.
		}

		arr[size] = item;
		size++;
	}

	//Inserts an element into a given position.
	public void add(int pos, T item)
	{
		Assert.not_false(pos >= 0 && pos < size + 1);		//Checks to see if given position is valid.
		try
		{
			Assert.not_false(pos != arr.length);		//Checks to see if array is large enough.
		}
		catch (Exception e)
		{
			grow_list();					//Doubles the array's size if not.
		}
		for (int i = size; i > pos; i--)	//Shifts all items down by 1 to make room for the new item.
		{
			arr[i] = arr[i-1];
		}
		arr[pos] = item;
		size++;
	}

	//Retrieves an element at a given position.
	public T get(int pos)
	{
		Assert.not_false(pos >= 0 && pos < size);	//Checks to see if given position is valid.
		return arr[pos];
	}

	//Removes an element at a given position.
	public T remove(int pos)
	{
		Assert.not_false(pos >= 0 && pos < size);	//Checks to see if given position is valid.
		T item = arr[pos];						//Stores the value of the item to be deleted (this is returned later).
		for (int i = pos + 1; i < size; i++)		//Shifts all the items after the given position up 1.
		{
			arr[i-1] = arr[i];
		}
		size--;
		return item;
	}

	public int size()
	{
		return size;
	}

	//Doubles the array's size.
	protected void grow_list()
	{
		Object[] tempObject = new Object[arr.length * 2];	//Creates a temporary array 2x the size.
		T[] temp = (T[]) tempObject;

		for (int i = 0; i < arr.length; i++)	//Iterates through every element in original array.
		{
			temp[i] = arr[i];		//Copies each element into new larger array.
		}

		arr = temp;		//Assigns the new array to the old one.
	}
}