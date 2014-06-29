/**
 * 
 */
package org.iiit.assignemnt.hashing;

import java.text.DecimalFormat;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author ramakrishna.k
 *
 */
public class CircularHash {
	private final IHashGen hashFunction;
	 private final int numberOfReplicas;
	 private int machines;
	 private SortedMap<Double, Node> circle = new TreeMap<Double, Node>();

	 public CircularHash(IHashGen hashFunction, int numberOfReplicas,SortedMap<Double, Node> circle) {
	   this.hashFunction = hashFunction;
	   this.numberOfReplicas = numberOfReplicas;
	   this.circle = circle;
	 }
	 public CircularHash(IHashGen hashFunction, int numberOfReplicas, int machines) {
		   this.hashFunction = hashFunction;
		   this.numberOfReplicas = numberOfReplicas;
		   this.machines = machines;
		   createNodes(machines);
		   
		   
		 }
	 public void createNodes(int machines){
		 
		 double base = 0.1534;
		   double area = 1.0/(machines+1);
		   DecimalFormat df = new DecimalFormat("#.####");
		   area  = Double.parseDouble(df.format(area));
		   System.out.println("area :"+area);
		   for(int i =1;i<=machines;i++){
			   String s = "Server "+i;
			   circle.put(Double.parseDouble(df.format(base+area)), new Node(s));
			   base =  base+area;
		   }
	 }
	 public void addNodes(int m){
		 this.machines = this.machines +m;
		 circle.clear();
		 createNodes(this.machines);
		 
	 }

	/* public void add(Node node) {
	   for (int i = 0; i < numberOfReplicas; i++) {
	     circle.put(hashFunction.hash(node.toString() + i), node);
	   }
	 }

	 public void remove(Node node) {
	   for (int i = 0; i < numberOfReplicas; i++) {
	     circle.remove(hashFunction.hash(node.toString() + i));
	   }
	 }*/

	 public Node get(String key) {
	   if (circle.isEmpty()) {
	     return null;
	   }
	   Double hash = hashFunction.hash(key);
	   System.out.println("Key Hash :"+hash.doubleValue());
	   if (!circle.containsKey(hash)) {
	     SortedMap<Double, Node> tailMap = circle.tailMap(hash);
	     hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
	   }
	   return circle.get(hash);
	 }
	 
	 public SortedMap<Double, Node> getAllNodes(){
		 return circle;
	 }
}
