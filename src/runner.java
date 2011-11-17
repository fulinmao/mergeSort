public class runner
{
	public static void main(String[] args)
	{
		Integer[] ints = {1,5,8,3,6,3,2,7,9345,2345,7,2345,7,7,23465,1,6,8,5,3,23,7,634,23,4};
		//String[] ints = {"robert", "lynn","Elizabeth", "Christine", "Bob"};
		MergeSort ms = new MergeSort(ints);
		Queue res = ms.sort(0 , ints.length - 1);
		System.out.println(res);
	}
}
