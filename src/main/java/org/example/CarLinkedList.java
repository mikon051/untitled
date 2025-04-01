package org.example;

public class CarLinkedList implements CarList {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public Car get(int index) {
      return getIndex(index).value;
    }

    @Override
    public void add(Car car) {
        if (size == 0) {
            first = new Node(null, null, car);
            last = first;
        } else {
            Node secondLast = last;
            Node node = new Node(secondLast, null, car);
            secondLast.setNext(node);
            last = node;
        }
        size++;
    }

    @Override
    public void add(Car car, int index) {
        if ((index > size) || (index < 0)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(car);
            return;
        }
        Node elementIndex = getIndex(index);
        Node preElementIndex = elementIndex.previous;
        Node node = new Node(preElementIndex, elementIndex, car);
        elementIndex.previous = node;
        if (preElementIndex != null) {
            preElementIndex.next = node;
        } else {
            first = node;
        }
        size++;
    }

    @Override
    public boolean remove(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)) {
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        if ((index > size) || (index < 0)) {
            throw new IndexOutOfBoundsException();
        }
        Node elementIndex = getIndex(index);
        Node preElementIndex = elementIndex.previous;
        Node afterElementIndex = elementIndex.next;
        if (afterElementIndex != null) {
            afterElementIndex.previous = preElementIndex;
        } else {
            last = preElementIndex;
        }
        if (preElementIndex != null) {
            preElementIndex.next = afterElementIndex;
        } else {
            first = afterElementIndex;
        }
        if (index == size) {
            preElementIndex = last;
            preElementIndex.next = null;
        }
        size--;
        return true;


    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public Node getIndex(int index) {
        if ((index > size) || (index < 0)) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public static class Node {
        private Node previous;
        private Node next;
        private Car value;

        public Node(Node previous, Node next, Car value) {
            this.previous = previous;
            this.next = next;
            this.value = value;
        }

        public Node getPrevious() {
            return previous;
        }

        public Node getNext() {
            return next;
        }

        public Car getValue() {
            return value;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(Car value) {
            this.value = value;
        }
    }

}
