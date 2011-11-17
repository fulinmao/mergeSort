
public class MergeSort<T extends Comparable<T>>
{
	private T[] objects;
	
	public MergeSort(T[] objects)
	{
		this.setObjects( objects );
	}
	
	public void sort(int low, int high)
	{
		if(high - low == 1 )
		{
			return;
		}
		else
		{
			int p = Math.floor( (high - low )/(2.0)) + low;
			sort(low, p);
			sort(p+1, high );
			int comparisonResult;
			for(int i = 0; i < high; i++)
			{	
				comparisonResult = objects[low].compareTo( objects[p+1] );
				if(comparisonResult > 0)
				{//objects[low] is bigger
					comparisonResult = objects[low].compareTo( objects[i] );
					if(comparisonResult > 0)
					{//objects[low] was bigger
						
					}
					else if(comparisonResult < 0)
					{//objects[i] was bigger
						
					}
					else
					{//they were equal
						
					}
				}
				else if(comparisonResult < 0)
				{//objects[p+1] is bigger
					comparisonResult = objects[p+1].compareTo( objects[i] );
					if(comparisonResult > 0)
					{//objects[p+1] was bigger
						swap(p+1, i);
						
						
						
					}
					else if(comparisonResult < 0)
					{//objects[i] was bigger
						
					}
					else
					{//they were equal
						
					}
				}
				else
				{//they are the same
					
				}
				low++;
			}
		}
		
	}
	
	void swap( int index1, int index2 )
	{
		T temp = objects[index1];
		objects[index1] = objects[index2];
		objects[index2] = temp;
	}

	public T[] getObjects()
	{
		return objects;
	}

	public void setObjects( T[] objects )
	{
		this.objects = objects;
	}
	
	
	
}
