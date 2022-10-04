package hashmap;

import java.util.HashMap;

public class SumWithDifferenceK {
	public static int difference(int[] arr,int k)
	{
		int count=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int val:arr)
		{
			boolean flag=false;
			int p1=val+k;
			if(p1==val)
				flag=true;
			if(map.containsKey(p1))
				count+=map.get(p1);
			int p2=val-k;
			if(map.containsKey(p2) && !flag)
				count+=map.get(p2);
			map.put(val, map.getOrDefault(val,0)+1);
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=0;
		int[] arr= {4 ,4 ,4 ,4};
		System.out.println(difference(arr,k));
	}

}
