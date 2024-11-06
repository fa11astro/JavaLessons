package converter_2;

record Book(String author, String year, String name) {

    @Override
    public String toString() {
        return author + " + " + name;
    }
}
