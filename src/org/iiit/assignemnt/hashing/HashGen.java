/**
 * 
 */
package org.iiit.assignemnt.hashing;

/**
 * @author ramakrishna.k
 *
 */
public class HashGen implements IHashGen{

	/**
	 * 
	 */
	public HashGen() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double hash(String data) {
		int hashcode = 0;
		hashcode = data.hashCode();
		hashcode = (hashcode < 0 ? -hashcode : hashcode);
		String sHash = "0."+hashcode;
		Double dHash = Double.valueOf(sHash);
		return dHash;
	}

}
