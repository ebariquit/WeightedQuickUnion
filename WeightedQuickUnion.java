package Workout2;

public class WeightedQuickUnion extends QuickUnion {

	private int[] size;
	
	public WeightedQuickUnion(int n) {
		super(n);
		size = new int[n];
		initialize();
	}
	
	private void initialize() {
		for(int i=0; i <size.length; i++)
			size[i] = 1;
	}

	// Connect smaller component (set) to larger one
	@Override
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if(size[i] <= size[j]) {
			array[i] = j;
			size[j] += size[i];
		} else {
			array[j] = i;
			size[i] += size[j];
		}		
		disjointSets--;
	}
	
}
