package company;

public class MyLinkedList<T> implements List<T>{
    private class MyNode<T> {
        T data; //access to data from node
        MyNode<T> next; //next node

        public MyNode(T data) {
            this.data = data;
            next = null;
        }
    }
    private MyNode<T> head;
    private int size;

    public MyLinkedList(){
        head = null; //first element (head) is null
        size = 0; //size is zero
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = newNode; //if there is no element at start, add it
        }
        else {
            MyNode<T> currentNode = head;
            while (currentNode.next != null){ //go until empty node
                currentNode = currentNode.next;
            }
            currentNode.next = newNode; //change first null node with new element
        }
        size++; //size incr
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index); //check the validness of index
        MyNode<T> newNode = new MyNode<>(item);

        MyNode<T> currentNode = head;

        if (index == 0) {
            newNode.next = head; //change next node with prev head element
            head = newNode; //change head element with new node
        }

        else {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next; //go until index
            }
            currentNode = newNode;
        }
        size++; //size incr
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index); //check the validness of index
        MyNode<T> newNode = new MyNode<>(item);
        MyNode<T> currentNode = head;
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }
        else {
            for (int i = 0; i < index; i++) { //go until index
                currentNode = currentNode.next;
            }
            currentNode = newNode;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);

        newNode.next = head;
        head = newNode;
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        MyNode<T> currentNode = head;
        for (int i = 1; i < size - 1; i++) { //go until end
            currentNode = currentNode.next;
        }
        currentNode = newNode;
    }

    @Override
    public T get(int index) {
        checkIndex(index); //check the validness of index
        MyNode<T> currentNode = head;
        if (index == 0)
            return currentNode.data;
        else {
            for (int i = 0; i < index; i++) { //go until index
                currentNode = currentNode.next;
            }
        }
        return currentNode.data;
    }

    @Override
    public T getFirst() {
        return head.data; //get head data
    }

    @Override
    public T getLast() {
        MyNode<T> currentNode = head;

        for (int i = 1; i < size-1; i++) { //go until end
            currentNode = currentNode.next;
        }
        return currentNode.data; //get Node data
    }

    @Override
    public void remove(int index) {
        checkIndex(index); //check the validness of index
        if(index == 0)
            head = head.next;
        else {
            MyNode<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) { //go until end
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
        size--; //size decr
    }

    @Override
    public void removeFirst() {
        head = head.next;
        size--; //size decr
    }

    @Override
    public void removeLast() {
        MyNode<T> currentNode = head;
        for (int i = 1; i < size - 2; i++) { //go until end
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        size--; //size decr
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> currentNode = head;
        if (head == object) {
            return 0; //stop if found
        }
        for (int i = 0; i < size - 1; i++) { //go until end
            currentNode = currentNode.next;
            if (currentNode == object)
                return i+1; //stop if found
        }
        return -1; //-1 if it does not exist
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> currentNode = head;
        int ind = -1; //starts -1 (not exists)
        if (head == object) {
            ind = 0; //0 if at the start
        }
        for (int i = 0; i < size - 1; i++) { //go until end
            currentNode = currentNode.next;
            if (currentNode == object)
                ind = i+1; //change to index if found
        }
        return ind;
    }

    @Override
    public boolean exists(Object object) {
        MyNode<T> currentNode = head;
        if (head == object) {
            return true; //return true if found
        }
        for (int i = 0; i < size - 1; i++) { //go until end
            currentNode = currentNode.next;
            if (currentNode == object)
                return true; //return true if found
        }
        return false; //false if not found
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct"); //Error output
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

}
