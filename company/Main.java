package company;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList<>(); // Create linked list
        MyArrayList myArrayList = new MyArrayList<>(); // Create array list

        myArrayList.add(1); // 1
        myArrayList.add(0,2); // 2 1
        myArrayList.addFirst(3); // 3 2 1
        myArrayList.addLast(5); // 3 2 1 5
        myArrayList.printArr();

        System.out.println(myArrayList.get(2)); // 1
        System.out.println(myArrayList.getFirst()); // 3
        System.out.println(myArrayList.getLast()); // 5

        myArrayList.remove(1); // remove 2
        myArrayList.removeFirst();  // remove 3
        myArrayList.removeLast(); // remove 5
        myArrayList.printArr(); // 1

        myArrayList.add(5); // 1 5
        myArrayList.add(3); // 1 5 3
        myArrayList.add(7); // 1 5 3 7
        myArrayList.add(4); // 1 5 3 7 4
        myArrayList.add(3); // 1 5 3 7 4 3

        System.out.println(myArrayList.indexOf(3)); // 2
        System.out.println(myArrayList.lastIndexOf(3)); // 5
        System.out.println(myArrayList.exists(2)); // false

        System.out.println(myArrayList.getSize()); // 6
        myArrayList.clear(); //clear


        System.out.println();


        myLinkedList.add(1); // 1
        myLinkedList.add(2); // 1 2
        myLinkedList.add(6); // 1 2 6
        myLinkedList.add(3); // 1 2 6 3
        myLinkedList.add(4); // 1 2 6 3 4
        myLinkedList.add(1, 5); // 1 5 6 3 4
        myArrayList.addFirst(2); // 2 5 6 3 4
        myArrayList.addLast(3); // 2 5 6 3 3

        System.out.println(myLinkedList.get(2)); // 6
        System.out.println(myLinkedList.getFirst()); // 2
        System.out.println(myLinkedList.getLast()); // 3

        myLinkedList.remove(1); // remove 5
        myLinkedList.removeFirst();  // remove 2
        myLinkedList.removeLast(); // remove 3

        myLinkedList.add(5); // 6 3 5
        myLinkedList.add(4); // 6 3 5 4
        myLinkedList.add(3); // 6 3 5 4 3

        System.out.println(myLinkedList.indexOf(3)); // 1
        System.out.println(myLinkedList.lastIndexOf(3)); // 4
        System.out.println(myLinkedList.exists(2)); // false

        System.out.println(myLinkedList.getSize()); // 5
        myLinkedList.clear(); //clear
    }
}