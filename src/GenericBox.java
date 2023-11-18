import java.io.Serializable;

public class GenericBox<T extends Comparable<T>, V extends Animal & Serializable, K> {


    private T first;
    private V second;
    private K third;

    public GenericBox(T first, V second, K third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    public K getThird() {
        return third;
    }

    public void setThird(K third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return "first class is " + first.getClass()
                + ", second class is " + second.getClass()
                + ", third class is " + third.getClass();
    }
}
