package mx.uv.fiee.iinf.poo.primerparcial;

class Entry<K,V>{
    K key;
    V value;

    public Entry(K k, V v){
        this.key = k;
        this.value = v;
    }

    @Override
    public String toString(){
        return key + " : " + value;
    }
}