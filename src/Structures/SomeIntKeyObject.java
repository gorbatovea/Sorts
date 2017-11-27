package Structures;

import Interfaces.IntKeyObject;

public class SomeIntKeyObject<T> implements IntKeyObject<T>{
    public int key;
    public T value;

    public SomeIntKeyObject(int key,T value){
        this.key = key;
        this.value = value;
    }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public int compareTo(IntKeyObject anotherIntKeyObject) {
        if (this.getKey() < anotherIntKeyObject.getKey()) return -1;
        if (this.getKey() > anotherIntKeyObject.getKey()) return 1;
        return 0;
    }
}
