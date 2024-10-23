package ownLibraryPrototype;

public class Main {
    public static void main(String[] args) {
        Data dataInstance = new Data();
        SaveData saveDataInstance = new SaveData(dataInstance, 6);
        saveDataInstance.saveToFile("data.json");
    }
}
