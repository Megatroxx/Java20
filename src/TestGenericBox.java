public class TestGenericBox {
    public static void main(String[] args) {
        GenericBox<String, Animal, String> box1 = new GenericBox<String, Animal, String>("Hello", new Animal("cat", 7), "Bye");
        String str = box1.getFirst();
        Animal animal = box1.getSecond();
        String str2 = box1.getThird();
        System.out.println(box1);
    }
}
