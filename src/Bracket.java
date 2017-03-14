import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Bracket {
	public ArrayList<Team> teams = new ArrayList<Team>();
	
	Bracket(String info) {
		try {
			Scanner scanner = new Scanner(new File(info));
			String line = scanner.next();
			
			while(scanner.hasNext()) {
				teams.add(new Team(line));
				line = scanner.next();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void predictMatch(Team a, Team b) {
		Random rand = new Random();
		double winchance = a.wpAB(b);
		int dicethrow = rand.nextInt(100) + 1;
		double dicethrow2 = ((double) dicethrow)/100;
		if(dicethrow2 < winchance) {
			//team a wins
		} else {
			//team b wins
		}
	}
	
	public void predictMatchThousand(Team a, Team b) {
		for(int i = 0; i < 100000; i ++) {
			predictMatch(a, b);
		}
	}
	
	public void predictTourney() {
		for(int i = 0; i < )
	}
}
