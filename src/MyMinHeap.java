public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyMinHeap() {
        this.list = new MyArrayList<>();
    }

    public void insert(T item) {
        list.addLast(item);
        heapifyUp(list.size() - 1);
    }

    public T extractMin() {
        if (list.size() == 0) throw new IllegalStateException("Heap is empty");
        T min = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.removeLast();
        heapifyDown(0);
        return min;
    }

    public T getMin() {
        if (list.size() == 0) throw new IllegalStateException("Heap is empty");
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parent)) < 0) {
                T temp = list.get(index);
                list.set(index, list.get(parent));
                list.set(parent, temp);
                index = parent;
            } else break;
        }
    }

    private void heapifyDown(int index) {
        int left, right, smallest;
        while (true) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            smallest = index;

            if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) smallest = left;
            if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) smallest = right;

            if (smallest != index) {
                T temp = list.get(index);
                list.set(index, list.get(smallest));
                list.set(smallest, temp);
                index = smallest;
            } else break;
        }
    }
}