package src.pattern.factory;

public class OSFactory {

    public OS factory(String os){
        if (os.equals("android"))
            return new Android();
        else
            return new IOS();
    }
}
