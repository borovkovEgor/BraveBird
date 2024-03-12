package ru.borovkov.bravebird;

public class DataHolder {

    private static DataHolder instance = new DataHolder();
    private int data;

    private DataHolder() {}

    public static DataHolder getInstance() {
        return instance;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
