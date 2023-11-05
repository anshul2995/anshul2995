package src.pattern.factory;

public class main {
    public static void main(String[] args) {



        OSFactory os = new OSFactory();
        OS os1 = os.factory("android");

    }
}
