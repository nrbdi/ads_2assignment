import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private int size;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(item);
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node<T> newNode = new Node<>(item);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    @Override
    public void set(int index, T item) {
        Node<T> node = getNode(index);
        node.data = item;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new IndexOutOfBoundsException("List is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (head == null) throw new IndexOutOfBoundsException("List is empty");
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void addFirst(T item) {
        Node<T> node = new Node<>(item);
        node.next = head;
        head = node;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> node = new Node<>(item);
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            removeFirst();
            return;
        }
        Node<T> prev = getNode(index - 1);
        prev.next = prev.next.next;
        size--;
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new IndexOutOfBoundsException("List is empty");
        head = head.next;
        size--;
    }

    @Override
    public void removeLast() {
        if (head == null) throw new IndexOutOfBoundsException("List is empty");
        if (head.next == null) {
            head = null;
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    @Override
    public void sort() {
        // Optional: implement if needed
    }

    @Override
    public int indexOf(Object obj) {
        Node<T> current = head;
        int i = 0;
        while (current != null) {
            if (current.data.equals(obj)) return i;
            current = current.next;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        Node<T> current = head;
        int i = 0, lastIndex = -1;
        while (current != null) {
            if (current.data.equals(obj)) lastIndex = i;
            current = current.next;
            i++;
        }
        return lastIndex;
    }

    @Override
    public boolean exists(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Node<T> current = head;
        int i = 0;
        while (current != null) {
            result[i++] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}