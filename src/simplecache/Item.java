package simplecache;

public class Item<K> {

	private K value;
	private long timeout;
	
	public Item(K value, long timeout) {
		super();
		this.value = value;
		this.timeout = timeout;
	}
	public long getTimeout() {
		return timeout;
	}
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	public K getValue() {
		return value;
	}
	public void setValue(K value) {
		this.value = value;
	}
	

}
