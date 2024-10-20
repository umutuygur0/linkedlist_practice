public class DNode {
    protected int element;
    protected DNode next,prev;
    public DNode(int e,DNode p,DNode n){
        element =e;
        prev=p;
        next=n;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }
}
