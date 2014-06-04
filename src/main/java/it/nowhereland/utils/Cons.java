package it.nowhereland.utils;

public abstract class Cons<T> implements Iterable<T> {
    private final T head;
    private final Cons<T> rest;
    private final int size ;
    private static final Cons EMPTY = new Empty();
    public static final <T> Cons<T> empty() { return (Cons<T>) EMPTY; }
    protected final String toString;
    protected Cons(T head, Cons<T> rest, String toString, int size) { 
        this.head = head; this.rest = rest; 
        this.toString = toString; this.size = size;
    }

    public <T> Cons cons(T head) {
        return new NonEmpty(head, this);
    }

    public abstract boolean isEmpty(); 
    public T head() { return head; }
    public Cons<T> rest() { return rest; }
    public int size() { return size; }

    public String toString() { return toString; }
    public boolean equals(Object that) {
        if (that instanceof Cons) {
            Cons<T> c = (Cons<T>)that;
            if (c.isEmpty() && this.isEmpty()) return true;
            else return c.head().equals(this.head()) 
                         && c.rest().equals(this.rest());
        } else return false;
    }

    public java.util.Iterator<T> iterator() {
        return new Iterator(this);
    }

    public class Iterator<E> implements java.util.Iterator<E> {
        private Cons<E> cons;
        Iterator(Cons<E> cons) { this.cons = cons; }
        public boolean hasNext() { return !cons.isEmpty(); }
        public E next() { try { return cons.head(); } finally { cons = cons.rest(); } }
        public void remove() { throw new UnsupportedOperationException(); }
    }

    private static class Empty<T> extends Cons<T> {
        Empty() { super(null, null, "[]", 0); }
        public boolean isEmpty() { return true; }
        public T head() { throw new java.util.NoSuchElementException(); }
        public Cons<T> rest() { throw new java.util.NoSuchElementException(); }
    } 

    private static class NonEmpty<T> extends Cons<T> {
        NonEmpty(T first, Cons<T> rest){ super(first, rest, "[" + first + "," + rest + "]", rest.size() + 1); }
        public boolean isEmpty() { return false; }
    }

}
