package company;

public class MyArrayList<T> implements List<T>{
    private T[] arr;
    private int size;

    public MyArrayList() {
        arr = (T[]) new Object[5]; //New arr
        size = 0; //size of this arr is zero
    }

    @Override
    public void add(T item) {
        if (size >= arr.length) {
            increaseBuffer(); //Increase if reached the limit
        }

        arr[size++] = item; //add element to the end of arr //size++ - size incr
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index); //check the validness of index
        arr[index] = item; //add element at index
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index); //check the validness of index
        if (size >= arr.length) {
            increaseBuffer(); //Increase if reached the limit
        }

        for (int i = size; i > index; i--) {
            arr[i] = arr[i-1]; //move all elements after index forward by 1
        }

        arr[index] = item; //place element at index
        size++; //size incr
    }

    @Override
    public void addFirst(T item) {
        if (size >= arr.length) {
            increaseBuffer(); //Increase if reached the limit
        }

        for (int i = size; i > 0; i--) {
            arr[i] = arr[i-1]; //move all elements after index forward by 1
        }

        arr[0] = item; //place element at index
        size++; //size decr
    }

    @Override
    public void addLast(T item) {
        if (size >= arr.length) {
            increaseBuffer(); //Increase if reached the limit
        }
        arr[size++] = item; //similar to *add*
    }

    @Override
    public T get(int index) {
        checkIndex(index); //check the validness of index
        return arr[index]; //return element from index
    }

    @Override
    public T getFirst() {
        return arr[0]; //return first element
    }

    @Override
    public T getLast() {
        return arr[size-1]; //return last element
    }

    @Override
    public void remove(int index) {
        checkIndex(index); //check the validness of index
        for (int i = index + 1; i < size; i++) {
            arr[i-1] = arr[i]; //move all elements after index back by 1
        }
        size--; //size decr
    }

    @Override
    public void removeFirst() {
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i+1]; //move all elements  back by 1
        }
        size--; //size decr
    }

    @Override
    public void removeLast() {
        size--; //size decr
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++)
            if (arr[i] == object)
                return i; //return index if element is equal to object
        return -1; //return -1 if not exist in the array
    }

    @Override
    public int lastIndexOf(Object object) {
        int ind = -1; //starts -1 (not exist)
        for (int i = 0; i < size; i++)
            if (arr[i] == object)
                ind = i; //change to index if element is equal to object
        return ind; //return index
    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++)
            if (arr[i] == object)
                return true; //return true if was found in the array
        return false; //return false if wasn't found in the array
    }

    @Override
    public void clear() {
        arr = (T[]) new Object[5]; //create new array
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct"); //Error output
    }

    public void printArr() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2]; //create new arr with length multiplied by 2
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i]; //save all elements from the prev arr
        }
        arr = newArr; //change prev arr with the new one
    }

}
