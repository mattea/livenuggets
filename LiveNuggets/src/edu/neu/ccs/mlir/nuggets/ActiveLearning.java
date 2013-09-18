/**
 * 
 */
package edu.neu.ccs.mlir.nuggets;

/**
 * @author mattea
 *
 */
public class ActiveLearning {
	String queryid, querytext, queryclass;
	
	ActiveLearning(String queryid, String querytext, String queryclass) {
		this.queryid = queryid;
		this.querytext = querytext;
		this.queryclass = queryclass;
	}
	
	public void run() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String queryid = args[0];
		String querytext = args[1];
		String queryclass = args[2];
		ActiveLearning al = new ActiveLearning(queryid, querytext, queryclass);
		al.run();
	}

}
