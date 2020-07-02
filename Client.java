package Workout2;

import java.util.*;

import edu.princeton.cs.algs4.In;

public class Client {

	public static void main(String[] args) {
		
		In file = new In("workout2.txt");
		int nMembers = Integer.parseInt(file.readLine());
		WeightedQuickUnion wqf = new WeightedQuickUnion(nMembers);
		int[] id = new int[nMembers];
		for(int i=0; i<nMembers; i++) {
			id[i] = i;
		}
		System.out.println("Initial ID array:\n"+Arrays.toString(id)+"\n");
		
		ArrayList<Connection> conns = new ArrayList<Connection>();
		while(!file.isEmpty()) {
			Connection connection = new Connection(file.readLine());
			conns.add(connection);
		}
		
		Collections.sort(conns);

		for(Connection conn:conns) {
			System.out.print(conn.getDate());
			System.out.println("\tp"+conn.getP1()+" connected to p"+conn.getP2());
			
			if(wqf.find(conn.getP1(), conn.getP2()))
				continue;
			wqf.union(conn.getP1(), conn.getP2());
			
			if(wqf.getCount() == 1) {
				System.out.println("\n\t***ALL MEMBERS HAVE BEEN (MUTUALLY) CONNECTED***\n");
			}
			
		}
		
	}
	
}
