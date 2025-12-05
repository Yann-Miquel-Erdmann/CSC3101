package TP6.hashmap;

public class HashSet<E> implements Set<E> {
    private HashMap<E, Boolean> map;

    HashSet(){
        map = new HashMap<>();
    }

    public boolean add(E e){
        return map.put(e, true);
    }

    public boolean remove (E e){
        return map.remove(e);
    } 

    public boolean contains(E e){
        return !(map.get(e) == null);
    }


}
