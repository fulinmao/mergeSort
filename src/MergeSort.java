public class MergeSort<T extends Comparable<T>>
{
	private T[ ] objects;

	public MergeSort( T[ ] objects )
	{
		this.setObjects( objects );
	}

	public Stack<T> sort( T[ ] arr )
	{
		Stack<T> toReturn = new Stack<T>();
		int i;
		T temp = arr[0];
		int arrLen = arr.length;
		if( arrLen == 1 )
		{// BASE CASE
			toReturn = new Stack<T>();
			toReturn.push( temp );
			return toReturn;
		}
		// else, meaning there are more than one element
		// so call sort(T[] arr) on both the left and the right half of the
		// array
		int halfsize = ( arrLen / 2 );
		T[ ] left = arr.clone();
		
		T[ ] right = left.clone();
		
		for( i = 0; i < arrLen; i++ )
		{
			if( i < halfsize )
			{
				left[i] = arr[i];
			}
			right[i] = arr[i];
		}
		Stack<T> leftResults = sort( left );
		Stack<T> rightResults = sort( right );
		T poppedLeft = leftResults.pop();
		T poppedRight = leftResults.pop();
		for( i = 0; i < arrLen; i++ )
		{
			if( ( poppedLeft == null ) || ( poppedRight == null ) )
			{
				if( poppedLeft == null )
				{
					toReturn.push( poppedRight );
					poppedRight = rightResults.pop();
				}
				else if( poppedRight == null )
				{
					toReturn.push( poppedLeft );
					poppedLeft = leftResults.pop();
				}
			}
			else if( poppedLeft.compareTo( poppedRight ) > 0 )
			{
				toReturn.push( poppedRight );
				poppedRight = rightResults.pop();
			}
			else
			{
				toReturn.push( poppedLeft );
				poppedLeft = leftResults.pop();
			}
		}
		return toReturn;
	}

	void swap( int index1, int index2 )
	{
		T temp = objects[index1];
		objects[index1] = objects[index2];
		objects[index2] = temp;
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
