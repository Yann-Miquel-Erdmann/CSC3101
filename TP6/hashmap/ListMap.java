package TP6.hashmap;

public class ListMap<K, V> implements Map<K, V> {
    private ListMap<K, V> next;
    private ListMap<K, V> prev;
    private K key;
    private V value;

    public ListMap(K key, V val) {
        this.key = key;
        this.value = val;
        this.next = this;
        this.prev = this;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    private void append(K key, V val) {
        this.next.prev = new ListMap<>(key, val);
        this.next.prev.next = this.next;
        this.next = this.next.prev;
        this.next.prev = this;
    }

    @Override
    public void display() {
        System.out.println("List:");
        ListMap<K, V> e = this.next;
        while (e != this) {
            System.out.println("\t" + e);
            e = e.next;
        }
    }

    private ListMap<K, V> lookupNode(K key) {
        ListMap<K, V> e = this.next;
        while (e != this) {

            if (e.key.equals(key)) {
                return e;
            }
            e = e.next;
        }

        return null;
    }

    @Override
    public V get(K key) {
        ListMap<K, V> n = lookupNode(key);
        if (n != null) {
            return n.value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        ListMap<K, V> n = lookupNode(key);
        if (n != null) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            return true;
        }
        return false;
    }

    @Override
    public boolean put(K key, V value) {
        ListMap<K, V> n = lookupNode(key);
        if (n != null) {
            n.value = value;
            return false;
        }
        this.append(key, value);
        return true;

    }

    @Override
    public void allTo(Map<K, V> map) {
        ListMap<K, V> e = this.next;
        while (e != this) {
            map.put(e.key, e.value);
            e = e.next;
        }
    }

}
