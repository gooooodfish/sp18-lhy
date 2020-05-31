public interface Deque<Item> {
    public int size();

    public void addLast(Item T);

    public void addFirst(Item T);

    public boolean isEmpty();

    public void printDeque();

    public Item removeLast();

    public Item removeFirst();

    public Item get(int index);
}
