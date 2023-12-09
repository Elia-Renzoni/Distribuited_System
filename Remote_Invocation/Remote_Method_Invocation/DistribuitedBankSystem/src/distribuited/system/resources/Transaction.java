package distribuited.system.resources;

import java.util.HashSet;
import java.util.Set;

public class Transaction {
	private Set<String> db;
	
	public Transaction() {
		this.db = new HashSet<>();
	}
	
	public Set<String> getSet() {
		return this.db;
	}
	
	public void addTransaction(String tr) {
		this.db.add(tr);
	}
}
