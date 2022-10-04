package hashmap;

import java.util.HashMap;

public class PrintIntersection {
	public static void intersection(int[] arr,int[] arr1)
	{
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		for(int i=0;i<arr1.length;i++)
		{
			if(map.containsKey(arr1[i]) && map.get(arr1[i])>0)
			{
				map.put(arr[i], map.get(arr[i])-1);
				System.out.println(arr[i]);
			}
		}
	}
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		int[] arr1= {1,2,3,4,5,6};
		intersection(arr,arr1);
	}

}
