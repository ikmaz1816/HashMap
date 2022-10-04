package hashmap;

import java.util.HashMap;

public class PairSumTo0 {
	public static void sum(int[] arr)
	{
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(-arr[i]))
			{
				System.out.println(arr[i]+" "+-arr[i]);
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
	}
	public static void main(String[] args) {
		int[] arr= {2 ,1 ,-2 ,2 ,3};
		sum(arr);
	}

}
