package hashmap;

import java.util.HashMap;

public class LongestSubsetZeroSum {
	public static void sumZero(int[] arr)
	{
		HashMap<Integer,Integer> map=new HashMap<>();
		int sum=0;
		int i=0;
		map.put(0, -1);
		int maxlen=0;
		for(;i<arr.length;i++)
		{
			sum+=arr[i];
			if(map.containsKey(sum))
			{
				int count=i-map.get(sum);
				if(maxlen<count)
					maxlen=count;
			}
				map.put(sum,i);
		}
		System.out.println(maxlen);
	}
	public static void main(String[] args) {
		int[] arr= { 1 ,2 ,3 ,4 ,-10 ,10};
		sumZero(arr);
	}

}
