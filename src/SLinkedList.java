public class SLinkedList {
    protected Node head, tail;
    protected long size;

    public SLinkedList(){
        head= tail =null;
        size=0;
    }
    public void addFirst(Node n){
        n.setNext( head);
        head=n ;
        size++;
        if (tail == null) {
            tail = n;
        }
    }
    public void insertAfter(Node after, Node n){
        n.setNext(after.getNext());
        after.setNext(n);
        if (after == tail) {
            tail = n;
        }
        size++;
    }
    public Node get(int i){
        if(i < 0 || i>=size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node ptr =head;
        for(int k=0;k<i;k++){
            ptr=ptr.getNext();
        }
        return ptr;
    }
    public Node removeFirst(){
        if (head == null) {
            return null;
        }
        Node temp =head;
        head= head.getNext();
        if (head == null) {
            tail = null;
        }
        temp.setNext(null);
        --size;
        return temp;
    }
    public void addLast(Node n){
        if (head == null) {
            head = n;
            tail = n;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(n);
            tail=n;
        }
        size++;
    }
    public void removeLast(){
        if (head==null){
            return;
        }
        if(head.getNext()==null){
            head=null;
            tail=null;
        }
        else{
            Node temp=head;
            while(temp.getNext().getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(null);
            tail= temp;
        }
        --size;
    }
    public void removeAfter(Node n){
        if (n == null || n.getNext() == null) {
            return;
        }
        Node temp;
        temp=n.getNext();
        n.setNext(temp.getNext());
        if (temp == tail) {
            tail = n;
        }
        temp.setNext(null);
        --size;
    }

}
