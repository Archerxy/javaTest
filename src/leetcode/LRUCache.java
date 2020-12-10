package leetcode;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer,Integer> map;
    private int capacity;
    private LRU head;
    private LRU tail;
    
    private class LRU{
    	int key;
    	public LRU next;
    	public LRU last;
    	public LRU(int key) {
    		this.key = key;
    	}
    	public int getKey() {
    		return key;
    	}
    }
    
    public LRUCache(int capacity) {
    	map = new HashMap<>();
    	this.capacity = capacity;
    }
    
    public int get(int key) {
    	if(map.containsKey(key)) {
    		if(head.getKey() == tail.getKey()) return map.get(head.getKey());
    		LRU node = head;
    		while(node.getKey() != key&&node != null) {
    			node = node.next;
    		}
    		if(node == null) return -1;
    		if(node.getKey() == tail.getKey()) {
    			node.last.next = null;
    			tail = node.last;
    		}else {
        		node.last.next = node.next;
        		node.next.last = node.last;
    		}
    		node.last = null;
    		node.next = head;
    		head.last = node;
    		head = node;
    		return map.get(key);
    	}else return -1;
    }
    
    public void put(int key, int value) {
    	if(head == null) {
    		if(map.size() >= capacity) return;
    		head = new LRU(key);
    		tail = head;
    	}else {
    		head.last = new LRU(key);
    		head.last.next = head;
    		head = head.last;
    		if(map.size() >= capacity) {
                if(tail != null) map.remove(tail.getKey());
				tail.last.next = null;
				tail = tail.last;
    		}
    	}
		map.put(key,value);
    }
}