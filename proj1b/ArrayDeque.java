public class ArrayDeque<Item> implements Deque<Item> {
    private Item[] items;
    private int size;
    private int fp;//aka front pointer
    private int rp;//aka rear pointer

    public int size() {
        return size;
    }

    /*
    creat an empty deque
     */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        fp = (items.length - 1) % items.length;
        rp = 0;
        size = 0;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        int front = (fp + 1) % items.length;
        int rear = (rp - 1 + items.length) % items.length;
        if (front <= rear) {
            System.arraycopy(items, front, a, 0, size);
            fp = (a.length - 1) % a.length;
            rp = size;
        } else {
            System.arraycopy(items, front, a, 0, items.length - front);
            System.arraycopy(items, 0, a, items.length - front, size - items.length + front);
            fp = (a.length - 1) % a.length;
            rp = size;
        }
        items = a;
    }

    @Override
    public void addLast(Item T) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[rp] = T;
        rp = (rp + 1) % items.length;
        size = size + 1;
    }

    @Override
    public void addFirst(Item T) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[fp] = T;
        fp = (fp - 1) % items.length;
        size = size + 1;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void printDeque() {
        int front = (fp + 1) % items.length;
        int rear = (rp - 1 + items.length) % items.length;
        if (!this.isEmpty()) {
            if (front <= rear) {
                for (int i = front; i <= rear; i++) {
                    Item n = items[i];
                    System.out.println(n);
                }
            } else {
                for (int i = front; i < items.length; i++) {
                    Item n = items[i];
                    System.out.println(n);
                }
                for (int i = 0; i <= rear; i++) {
                    Item n = items[i];
                    System.out.println(n);
                }
            }
        }
    }

    @Override
    public Item removeLast() {
        if (size <= items.length / 4 & size >=16 ){
            resize(size / 2);
        }
        int rear = (rp - 1 + items.length) % items.length;
        if (!this.isEmpty()) {
            Item a = items[rear];
            items[rear] = null;
            size = size - 1;
            rp = (rp - 1 + items.length) % items.length;
            return a;
        }
        return null;
    }

    @Override
    public Item removeFirst() {
        if (size <= items.length / 4 & size >=16 ){
            resize(size / 2);
        }
        int front = (fp + 1) % items.length;
        if (!this.isEmpty()) {
            Item a = items[front];
            items[front] = null;
            size = size - 1;
            fp = (fp + 1) % items.length;
            return a;
        }
        return null;
    }

    @Override
    public Item get(int index) {
        if (!this.isEmpty()) {
            return items[(fp + 1 + index) % items.length];
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayDeque a = new ArrayDeque<Integer>();
        int i = 0;
        while (i < 5) {
            a.addLast(4);
            a.addFirst(3);
            a.addLast(44);
            a.addFirst(30);
            a.addLast(444);
            a.addFirst(33);
            i++;
        }
        i = 0;
        while (i < 3) {
            a.removeFirst();
            a.removeLast();
            a.removeFirst();
            a.removeLast();
            a.removeFirst();
            a.removeLast();
            i++;
        }
        int size = a.size();
        a.printDeque();
    }
}
