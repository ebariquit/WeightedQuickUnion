package Workout2;

public class QuickUnion implements UnionFind {

	protected int[] array;
	protected int disjointSets;
	
	public QuickUnion(int n) {
		array = new int[n];
		disjointSets = n;
		initialize();
	}
	
	// Set values to index
	private void initialize() {
		for(int i=0; i<array.length; i++)
			array[i] = i;
	}
	
	// set root of p to root of q
	@Override
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if(i ==j)
			return;
		array[i] = j;
		disjointSets--;
	}

	// check if p and q have same root
	@Override
	public boolean find(int p, int q) {
		return root(p) == root(q);
	}
	
	// get the root of p
	protected int root(int p) {
		while(array[p] != p) {
			p = array[p];
		}
		return p;
	}

	// get disjoint sets
	@Override
	public int getCount() {
		return disjointSets;
	}
	

}
