import java.util.Arrays;

public class MyList<T> {
    private T[] Arr;
    private int capacity;

    public MyList() {
        setCapacity(10);
        this.Arr = (T[]) new Object[getCapacity()];
    }

    public MyList(int capacity) {
        setCapacity(capacity);
        this.Arr = (T[]) new Object[getCapacity()];
    }

    public T[] getArr() {
        return Arr;
    }

    public void setArr(int capacity) {
        T[] tempArr = getArr();
        this.Arr = (T[]) new Object[capacity];

        for (int i = 0; i < tempArr.length; i++) {
            this.Arr[i] = tempArr[i];
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < this.Arr.length; i++) {
            if (getArr()[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void add(T value) {
        checkCapacity();
        for (int i = 0; i < getArr().length; i++) {
            if (getArr()[i] == null) {
                getArr()[i] = value;
                break;
            }
        }
    }

    public void remove(int index) {
        if (getArr()[index] != null) {
            getArr()[index] = null;
        } else {
            System.out.println("null");
        }

        for (int i = 0; i < size(); i++) {
            if (getArr()[i] == null) {
                getArr()[i] = getArr()[i + 1];
                getArr()[i + 1] = null;
            }
        }

    }

    public void checkCapacity() {
        if (size() >= getCapacity()) {
            setCapacity(getCapacity() * 2);
            setArr(getCapacity());
        }
    }

    public T get(int index) {
        return getArr()[index];
    }

    public void set(int index, T data) {
        getArr()[index] = data;
    }

    public String toString() {
        T[] tempArr = (T[]) new Object[size()];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = getArr()[i];
        }
        return Arrays.toString(tempArr);
    }

    public int indexOf(T data) {
        int index = -1;
        for (int i = 0; i < getArr().length; i++) {
            if (getArr()[i] == data) {
                return i;
            }
        }
        return index;
    }

    public int lastIndexOf(T data) {
        int index = -1;
        for (int i = size() - 1; i > 0; i--) {
            if (getArr()[i] == data) {
                return i;
            }
        }
        return index;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T[] toArray() {
        T[] tempArr = (T[]) new Object[size()];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = getArr()[i];
        }
        return tempArr;
    }

    public MyList<T> subList(int start, int end) {
        MyList<T> subArr = new MyList<>((end - start + 1));

        for (int i = start; i < end; i++) {
            subArr.add(get(i));
        }
        return subArr;
    }

    public boolean contains(T data){
        for (int i = 0; i < size(); i++) {
            if (get(i) == data){
                return  true;
            }
        }
        return  false;
    }
    public void clear(){
        Arrays.fill(getArr(), null);
        setCapacity(10);
    }
}
