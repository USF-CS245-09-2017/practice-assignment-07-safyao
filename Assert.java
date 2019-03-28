//Assert class for error checking
public class Assert 
{
	public static void not_false(boolean expr) 
	{
		if (!expr)
		{
			throw new IllegalArgumentException();
		}
	}
}