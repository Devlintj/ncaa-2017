import java.io.File;
import java.util.Scanner;


public class Team {
	private String name;
	private double adjEm, adjT;
	private int seed;
	private int matchesWon = 0;
	
	Team(String line) {
		String info[] = line.split(",");
		seed = Integer.parseInt(info[0]);
		name = info[1];
		adjEm = Double.parseDouble(info[2]);
		adjT = Double.parseDouble(info[3]);
	}
	
	public void matchWon() {
		matchesWon += 1;
	}
	
	public int matchesWon() {
		return matchesWon;
	}
	
	public void setMatchWonToZero() {
		matchesWon = 0;
	}
	
	private double adjEm() {
		return adjEm;
	}
	
	private double adjT() {
		return adjT;
	}
	
	public String name() {
		return name;
	}
	
	public int seed() {
		return seed;
	}
	
	private double pdAB(Team opp) {
		double avgAdjEm = this.adjEm() - opp.adjEm();
		double avgAdjT = this.adjT() + opp.adjT();
		return (avgAdjEm * avgAdjT) / 200;
	}
	
	public double wpAB(Team opp) {
		return (1 + erf(-1 * pdAB(opp)))/(22 * Math.sqrt(2));
	}
	
	private double erf(double z) {
		double t = 1.0 / (1.0 + 0.5 * Math.abs(z));
		
		double ans = 1 - t * Math.exp(-z * z - 1.26551223 +
										t * (1.00002368 +
										t * (0.37409196 +
										t * (0.09678418 +
										t * (-0.18628806 +
										t * (0.27886807 + 
										t * (-1.13520398 +
										t * (1.48851587 + 
										t * (-0.82215223 +
										t * (0.17087277))))))))));
		if (z >= 0) return ans;
		else return -ans;
	}
}
