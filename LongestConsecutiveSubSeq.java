package hashmap;

import java.util.HashMap;

public class LongestConsecutiveSubSeq {
	public static void longest(int[] arr)
	{
		HashMap<Integer,Boolean> map=new HashMap<>(); 
		for(int val : arr)
		{
			map.put(val, true);
		}
		//Put the value in the hashmap as true
		for(int val:arr)
		{
			if(map.containsKey(val-1))
				map.put(val, false);
		}
		//Check if there id any value less than -1 than that number then mark it false
		int maxStartingPoint=0;
		int maxlength=0;
		//Iterate only through elements with true in the value and calculate the length
		for(int i=0;i<arr.length;i++)
		{
			if(map.get(arr[i])==true)
			{
				int t1=1;
				int tsp=arr[i];
				while(map.containsKey(tsp+t1))
				{
					t1++;
				}
				if(t1>maxlength)
				{
					maxStartingPoint=tsp;
					maxlength=t1;
				}
			}
		}
		System.out.println(maxStartingPoint);
		System.out.println(maxStartingPoint + maxlength-1);
	}
	public static void main(String[] args) {
		int[] arr= {3 ,7 ,2 ,1 ,9 ,8 ,41};
		longest(arr);
	}

}
