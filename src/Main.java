public class Main {
    public static void main(String[] args) {
        System.out.println("Testing MyStack");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Popped: " + stack.pop());

        System.out.println("Testing MyQueue");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("Asem");
        queue.enqueue("Moldir");
        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Testing MyMinHeap");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(7);
        heap.insert(2);
        heap.insert(9);
        System.out.println("Extract Min: " + heap.extractMin());
    }
}