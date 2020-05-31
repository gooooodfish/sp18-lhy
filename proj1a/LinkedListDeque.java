public class LinkedListDeque<Item> {

    /**
     * Intnode constructor
     */
    public class Intnode {
        public Intnode prev;
        public Item item;
        public Intnode next;

        public Intnode(Intnode p, Item i, Intnode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Intnode sentinel;

    private int size;

    public int size() {
        return size;
    }

    public LinkedListDeque() {
        sentinel = new Intnode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(Item T) {
        sentinel = new Intnode(null, null, null);
        Intnode t = new Intnode(sentinel, T, sentinel);
        sentinel.next = t;
        sentinel.prev = t;
        size = 1;
    }

    public void addLast(Item T) {
        Intnode t = new Intnode(null, T, null);
        Intnode p = sentinel.prev;
        sentinel.prev = t;
        t.next = sentinel;
        p.next = t;
        t.prev = p;
        size += 1;
    }

    public void addFirst(Item T) {
        Intnode t = new Intnode(null, T, null);
        Intnode n = sentinel.next;
        sentinel.next = t;
        t.prev = sentinel;
        n.prev = t;
        t.next = n;
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        Intnode p = sentinel.next;
        while (p != sentinel) {
            System.out.println(p);
            p = p.next;
        }
    }

    public Item removeLast() {
        Item l = sentinel.prev.item;
        Intnode pp = sentinel.prev.prev;
        sentinel.prev = pp;
        pp.next = sentinel;
        size = size - 1;
        return l;
    }

    public Item removeFirst() {
        Item f = sentinel.next.item;
        Intnode nn = sentinel.next.next;
        sentinel.next = nn;
        nn.prev = sentinel;
        size = size - 1;
        return f;
    }

    public Item get(int index) {
        int i = 0;
        Intnode p = sentinel.next;
        while (i != index) {
            p = p.next;
            i += 1;
        }
        return p.item;
    }

    private Intnode getRecursiveIntnode(int index) {
        if (index > 0) {
            return getRecursiveIntnode(index - 1).next;
        } else {
            return sentinel.next;
        }

    }

    public Item getRecursive(int index){
        return getRecursiveIntnode(index).item;
    }

    public static void main(String[] args) {
        LinkedListDeque a = new LinkedListDeque<Integer>();
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        LinkedListDeque c = new LinkedListDeque();
        boolean d = c.isEmpty();
        Object b = a.getRecursive(2);
    }
}
