public class IntegerNode {

    //Used to store data
    private int data;

    //Used to store next data
    private IntegerNode next;

    public IntegerNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public IntegerNode getNext() {
        return next;
    }

    public void setNext(IntegerNode next) {
        this.next = next;
    }
}
