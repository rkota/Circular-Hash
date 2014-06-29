/**
 * 
 */
package org.iiit.assignemnt.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ramakrishna.k
 *
 */
public class Main {
	public static void main(String args[]){
		try{
			HashGen hashfun = new HashGen();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter number of Nodes :");
			int m = Integer.parseInt(br.readLine());
			
			//System.out.println("Enter number of Repilcas :");
			//int r = Integer.parseInt(br.readLine());
			CircularHash circular = new CircularHash(hashfun, 1,m);
			displayNodes(circular);
			addKey(circular);
			System.out.println("Enter number of nodes to add :");
			int am = Integer.parseInt(br.readLine());
			circular.addNodes(am);
			displayNodes(circular);
			addKey(circular);
			
			System.out.println("Thank You!");
		}
        catch (Exception e) {
        	e.printStackTrace();
		}
	}

	private static void displayNodes(CircularHash circular) {
		System.out.println("Available Nodes :");
		System.out.println("Nodes		Key");
		for(Double key : circular.getAllNodes().keySet()){
			System.out.println(key.doubleValue()+"		"+circular.getAllNodes().get(key).getName());
		}
		
	}

	private static void addKey(CircularHash circular) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
	        System.out.print("Enter Key (or) type q to exit :");
	        String s;
			try {
				s = br.readLine();
			
	        if(s.equalsIgnoreCase("q"))
	        	break;
	        System.out.println("key goes to node :"+circular.get(s).getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
