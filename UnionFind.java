package Workout2;

public interface UnionFind {

	// replace sets containing p & q with their union
	public void union(int p, int q);
	
	// are p & q in the same set?
	public boolean find(int p, int q);
	
	// number of connected components (disjoint sets)
	public int getCount();
	
}
