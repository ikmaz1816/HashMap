package hashmap;

public class HashSet {
	private int[] arr;
	private int index;
	public HashSet()
	{
		arr=new int[5];
		this.index=0;
	}
	public int size()
	{
		return index;
	}
	public boolean isEmpty()
	{
		return this.index==0;
	}
	private void doubleArray()
	{
		int[] arr1=arr;
		arr=new int[arr1.length * 2];
		for(int i=0;i<arr1.length;i++)
		{
			arr[i]=arr1[i];
		}
	}
	public void set(int value,int index)
	{
		if(index>=arr.length)
			return;
		arr[index]=value;
	}
	public boolean add(int value,int index)
	{
		if(index>=arr.length || index+1==arr.length)
			doubleArray();
		boolean isDuplicate=false;
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==value)
			{
				isDuplicate=true;
				break;
			}
		}
		if(isDuplicate)
		{
			return false;
		}
		
		for(int i=index;i<=this.index;i++)
		{
			arr[i+1]=arr[i];
		}
		arr[index]=value;
		return true;
	}
	public boolean add(int value)
	{
		if(index==arr.length)
		{
			doubleArray();
		}
		boolean isDuplicate=false;
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==value)
			{
				isDuplicate=true;
				break;
			}
		}
		if(isDuplicate)
		{
			return false;
		}
		else
		{
			arr[index]=value;
			index++;
			return true;
		}
	}
	public int remove()
	{
		int value=arr[index];
		arr[index]=0;
		index--;
		return value;
	}
	public void display()
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
}
