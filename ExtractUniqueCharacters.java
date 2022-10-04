package hashmap;

import java.util.HashMap;

public class ExtractUniqueCharacters {
	public static void unique(String s)
	{
		String str="";
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<s.length();i++)
		{
			map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
		}
		for(Character c :map.keySet())
		{
			str+=c;
		}
		System.out.println(str);
	}
	public static void main(String[] args) {
		String s="abaxbadbxsdef";
		unique(s);

	}

}
