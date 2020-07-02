package Workout2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Connection implements Comparable<Connection>{
	
	private LocalDate date;
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("M/dd/yy");
	private int p1;
	private int p2;
	
	// Constructor
	public Connection(String str) {
		String[] splitStr = str.split(" ");
		if(splitStr.length != 3) {
			System.out.println("Connection ["+str+"] not read.");
		}
		else {
			String dateStr = splitStr[0].replace(".","/");
			try{
				date = LocalDate.parse(dateStr, format);
				p1 = Integer.parseInt(splitStr[1]);
				p2 = Integer.parseInt(splitStr[2]);
			}
			catch(Exception x){
				x.printStackTrace();
			}
		}
		
	}
	
	// Comparable
	@Override
	public int compareTo(Connection o) {
		if(this.date.isAfter(o.getDate()))
			return 1;
		if(this.date.isBefore(o.getDate()))
			return -1;
		return 0;
	}
	
	// Getters
	public LocalDate getDate() {
		return date;
	}

	public int getP1() {
		return p1;
	}
	
	public int getP2() {
		return p2;
	}
}
