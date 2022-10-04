package hashmap;
import java.util.*;
public class HashMapImplementation<K,V> {
	class Node
	{
		K key;
		V value;
		public Node(K key,V value)
		{
			this.key=key;
			this.value=value;
		}
	}
	private int size;
	private LinkedList<Node>[] bucket;
	public HashMapImplementation()
	{
		init(4);
		this.size=0;
	}
	public void init(int value)
	{
		bucket=new LinkedList[value];
		for(int i=0;i<bucket.length;i++)
		{
			bucket[i]=new LinkedList<>();
		}
	}
	public int size()
	{
		return this.size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	public int hashfuntion(K key)
	{
		return Math.abs(key.hashCode())/bucket.length;
	}
	public int getbucketIndex(K key,int bucketIndex)
	{
		int index=0;
		for(Node node:bucket[bucketIndex])
		{
			if(node.key.equals(key))
				return index;
			index++;
		}
		return -1;
	}
	public void put(K key,V value)
	{
		int bucketindex=hashfuntion(key);
		int bucketLinkedIndex=getbucketIndex(key,bucketindex);
		if(bucketLinkedIndex!=-1)
		{
			Node node=bucket[bucketindex].get(bucketLinkedIndex);
			node.value=value;
		}
		else
		{
			Node node =new Node(key,value);
			bucket[bucketindex].add(node);
			size++;
		}
		double lambda=size * 1.0 /bucket.length;
		if(lambda>2.0)
		{
			rehash();
		}
	}
	private void rehash() {
		LinkedList<Node>[] bucket1=bucket;
		init(bucket1.length *2);
		for(int i=0;i<bucket.length;i++)
		{
			for(Node node : bucket1[i])
			{
				put(node.key,node.value);
			}
		}
		
	}
	public boolean containsKey(K key)
	{
		int bucketindex=hashfuntion(key);
		int bucketLinkedIndex=getbucketIndex(key,bucketindex);
		if(bucketLinkedIndex!=-1)
		{
			return true;
		}
		return false;
	}
	public V get(K key)
	{
		int bucketindex=hashfuntion(key);
		int bucketLinkedIndex=getbucketIndex(key,bucketindex);
		if(bucketLinkedIndex!=-1)
		{
			Node node=bucket[bucketindex].get(bucketLinkedIndex);
			return node.value;
		}
		return null;
	}
	public V remove(K key)
	{
		int bucketindex=hashfuntion(key);
		int bucketLinkedIndex=getbucketIndex(key,bucketindex);
		if(bucketLinkedIndex!=-1)
		{
			Node node=bucket[bucketindex].remove(bucketLinkedIndex);
			size--;
			return node.value;
		}
		return null;
	}
	public ArrayList<K> getKey()
	{
		ArrayList<K> arr=new ArrayList<>();
		for(int i=0;i<bucket.length;i++)
		{
			for(Node node:bucket[i])
			{
				arr.add(node.key);
			}
		}
		return arr;
	}
	public ArrayList<V> getValue()
	{
		ArrayList<V> arr=new ArrayList<>();
		for(int i=0;i<bucket.length;i++)
		{
			for(Node node:bucket[i])
			{
				arr.add(node.value);
			}
		}
		return arr;
	}
	public void display()
	{
		for(int i=0;i<bucket.length;i++)
		{
			for(Node node:bucket[i])
			{
				System.out.println(node.key +" "+node.value);
			}
		}
	}
}
