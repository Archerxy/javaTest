package leetCodeMiddle;

public class MaxQueue {
    private int maxValue;
    private Queue firstValueIndex;
    private Queue self;

    private class Queue{
    	private int val;
    	private boolean isHead;
        public Queue next;
        
    	public Queue(int val,boolean isHead) {
    		this.val = val;
    		this.isHead = isHead;
    	}
    	public int getVal() {
    		return this.val;
    	}
    	public boolean isHead() {
    		return this.isHead;
    	}
    	public void setHead() {
    		this.isHead = true;
    	}
    }

    public MaxQueue() {
    }
    
    
    public int max_value() {
        if(self == null) return -1;
        return maxValue;
    }
    
    public void push_back(int value) {
        if(maxValue < value){
            maxValue = value;
        }
        if(firstValueIndex == null){
            firstValueIndex = new Queue(value,true);
            self = firstValueIndex;
        }else {
        	self.next = new Queue(value,false);
        	self = self.next;
        }
    }
    
    public int pop_front() {
        if(self == null) return -1;
        int val = firstValueIndex.getVal();
        
        if(self.isHead()) {
        	self = null;
        	firstValueIndex = null;
        	maxValue = 0;
        	return val;
        }
        
        firstValueIndex = firstValueIndex.next;
        firstValueIndex.setHead();
        if(maxValue == val) {
        	maxValue = 0;
        	Queue next = firstValueIndex;
        	while(next != null) {
        		if(next.getVal() > maxValue) {
        			maxValue = next.getVal();
        		}
        		next = next.next;
        	}
        }
        return val;
    }
}