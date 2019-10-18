import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class V
{

  int e;
  boolean visited;
  List<V> parents = new ArrayList<V>();


 public V(int n)
 {
    e = n;
 }

 public void makeParent(V p)
 {
	 this.parents.add(p);
 }
}

public class LCAgraph
{

  	List<List<V>> tree = new ArrayList<List<V>>();
	static V root;

	   public static List<V> LCA(V x, V y)
		{
		  List<V> lca 	= new ArrayList<V>();
		  if(x == null)
		  {
			 lca.add(root); 
			 return lca;
		  }
		  V t = x;
		  int i = 0;
			while(true)
			{
				x.visited = true;
				if(x.equals(root) || x.parents.size() == 0) break;
				if(x.parents.size() > 1)
				{
					x = x.parents.get(i);
				    i++;
				}
				
				else x = x.parents.get(0);
			}
			while(true)
			{
				if(y == null)
				{
					lca.add(root);
					return lca;
				}
				if(y.visited == true && y != t)
				{
					lca.add(y); break;
				}
				
				if(y.parents.size() > 1)
				{
					y = y.parents.get(i);
				    i++;
				}
				if(y.parents.size() == 0 && y != root)
				{
					lca.add(y); return lca;
				}

			   	y = y.parents.get(0);
			}
        return lca;
		}

		static void printLCA(List<V> l)
		{
			for(int i = 0; i<l.size(); i++)
			{
				System.out.println(l.get(i).e);
			}
		}

			public static void main(String[] args)
			{



			}

	}
