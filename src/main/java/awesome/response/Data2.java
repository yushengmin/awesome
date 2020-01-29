package awesome.response;

import java.util.ArrayList;

public class Data2<T> {
    private int total;

    private T list;


    public Data2(int total, T list) {
        this.total = total;
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }
}
