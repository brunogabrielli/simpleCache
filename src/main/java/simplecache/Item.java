package simplecache;

public class Item<K> {

	private K value;
	private long time;
	
	public Item(K value, long time) {
		super();
		this.value = value;
		this.time = time;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public K getValue() {
		return value;
	}
	public void setValue(K value) {
		this.value = value;
	}
	

}
