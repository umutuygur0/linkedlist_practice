public class DLinkedList {
    protected int size;
    protected DNode head, tail;

    public DLinkedList(){
        head= tail =null;
        size=0;
    }
    public void addFirst(DNode n){
        if (head == null) { // Liste boşsa
            head = n;
            tail = n;
        }
        else{
            n.setNext(head);
            head.setPrev(n);
            head = n;
        }
        size++;
    }
    public void insertAfter(DNode after, DNode n){
        n.setNext(after.getNext());
        n.setPrev(after);
        if (after.getNext() != null) {
            after.getNext().setPrev(n); // Sonraki düğüm varsa, onun prev'ini güncelle
        }
        after.setNext(n);
        if (after == tail) { // Eğer son düğümden sonra ekleniyorsa tail güncellenir
            tail = n;
        }
        size++;
    }
    public DNode get(int i){
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        DNode temp=head;
        while(temp.getNext()!=null){
            temp=temp.getNext();
        }
        return temp;
    }
    public DNode removeFirst(){
        if (head == null) { // Liste boşsa
            return null;
        }
        DNode temp =head;
        head=head.getNext();
        if(head!=null){
            head.setPrev(null);
        }else{
            tail=null;
        }
        temp.setNext(null);
        --size;
        return temp;
    }

    public void addLast(DNode n){
        if(tail==null){
            head =n;
            tail=n;
        }else{
            tail.setNext(n);
            n.setPrev(tail);
            tail =n;
        }
        size++;
    }
    public void removeLast(){
        if(head==null){
            return;
        }
        if(head.getNext()==null){
            head=null;
            tail=null;
        }else{
            DNode temp=tail;
            tail=tail.getPrev();
            tail.setNext(null);
            temp.setPrev(null);
        }
        --size;
    }
    public void removeAfter(DNode n){
        if(n.getNext()==null){
            return;
        }
        DNode temp =n.getNext();
        n.setNext(temp.getNext());
        if (temp.getNext() != null) {
            temp.getNext().setPrev(n); // Silinen düğümden sonraki düğümün prev'ini güncelle
        } else {
            tail = n; // Eğer silinen düğüm tail ise, tail'i güncelle
        }

        temp.setPrev(null);
        temp.getNext(null);
        --size;

    }

}
