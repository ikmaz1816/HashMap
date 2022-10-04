package hashmap;

import java.util.HashMap;

public class MaximumFrequencyNumber {
	public static void max(int[] arr)
	{
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		int max=0;
		int max_length=0;
		for(Integer j : map.keySet())
		{
			if(map.get(j)>max_length)
			{
				max_length=map.get(j);
				max=j;
			}
		}
		System.out.println(max);
	}
	public static void main(String[] args) {
		int[] arr= {1,2,9,2,9,2,3,1,1,1};
		max(arr);
	}

}
