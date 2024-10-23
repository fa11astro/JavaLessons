package ownLibraryPrototype;

public class Data {
    @Ok
    private int field1 = 10;
    @Ok
    private int field2 = 20;

    @Ugly
    private int field3 = 30;
    @Ugly
    private int field4 = 40;

    private int field5 = 50;  // No annotation

    public int getField1() { return field1; }
    public int getField2() { return field2; }
    public int getField3() { return field3; }
    public int getField4() { return field4; }
    public int getField5() { return field5; }
}
