package leetcode;

public class ContinuousMid {
    Node head;
    Node mid;
    int size;
    int midPlace;
    /** initialize your data structure here. */
    public ContinuousMid() {
        size = 0;
        midPlace = 0;
    }
    
    public void addNum(int num) {
        ++size;
        if(head == null){
            head = new Node(num);
            mid = head;
            midPlace = 1;
            return;
        }
        Node n;
        if(mid.val<num){
            Node tmp = head;
            n = tmp;
            while(tmp.next != null && tmp.val > num){
                n = tmp;
                tmp = tmp.next;
            }
            if(n == head){
                tmp = new Node(num);
                tmp.next = head;
                head = tmp;
            } else {
                tmp = new Node(num);
                tmp.next = n.next;
                n.next = tmp;
            }
            if(midPlace*2 < size){
                ++midPlace;
                mid = mid.next;
            }
        } else {
            Node tmp = mid;
            n = mid;
            while(tmp.next != null && tmp.val > num){
                n = tmp;
                tmp = tmp.next;
            }
            if(n == head){
                tmp = new Node(num);
                tmp.next = head.next;
                head.next = tmp;
            } else {
                tmp = new Node(num);
                tmp.next = n.next;
                n.next = tmp;
            }
            if(midPlace*2 < size){
                ++midPlace;
                mid = mid.next;
            }
        }
    }
    
    public double findMedian() {
        if(size == 0)
            return 0d;
        if(size%2 == 0){
            return ((double)(mid.val + mid.next.val))/2d;
        }
        return mid.val;
    }
    class Node {
        public int val;
        public Node next;
        public Node last;
        public Node(int x){val = x;}
    }
}
