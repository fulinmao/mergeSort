public class MergeSort<T extends Comparable<T>>
{
	private T[ ] objects;

	public MergeSort( T[ ] objects )
	{
		this.setObjects( objects );
	}

	public Queue<T> sort( int lowIndex, int highIndex)
	{
		Queue<T> left, right;
		Queue<T> toReturn = new Queue<T>();
		int i;
		int arrLen = highIndex - lowIndex + 1;
		if( arrLen == 1 )
		{// BASE CASE
			toReturn.push( objects[lowIndex] );
			return toReturn;
		}
		int pivot = ((highIndex - lowIndex)/2  + lowIndex);
		left = this.sort(lowIndex, pivot );
		right = this.sort( pivot + 1, highIndex);
		int comparisonResult;
		T tempL = left.pop();
		T tempR = right.pop();
		for(i = 0; i < arrLen; i++)
		{
			if(tempL == null)
			{
				while(tempR != null)
				{
					toReturn.push( tempR );
					tempR = right.pop();
				}
				return toReturn;
			}
			else if(tempR == null )
			{
				while(tempL != null)
				{
					toReturn.push( tempL );
					tempL = left.pop();
				}
				return toReturn;
			}
			comparisonResult = tempL.compareTo( tempR ); 
			if( comparisonResult >= 0)
			{
				toReturn.push(tempL);
				tempL = left.pop();
			}
			else if( comparisonResult < 0)
			{
				toReturn.push(tempR);
				tempR = right.pop();
			}
		}
		return toReturn;
	}

	public T[ ] getObjects()
	{
		return objects;
	}

	public void setObjects( T[ ] objects )
	{
		this.objects = objects;
	}
}
