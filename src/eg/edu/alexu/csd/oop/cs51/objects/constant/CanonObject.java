package eg.edu.alexu.csd.oop.cs51.objects.constant;

import eg.edu.alexu.csd.oop.cs51.objects.AbstractObject;

public class CanonObject extends AbstractObject{
    private static final String PATH = "res/canons.png";
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    public CanonObject() {
        super(WIDTH, HEIGHT, PATH, true, "");
    }
    
    public CanonObject(CanonObject canonLeft) {
        super(canonLeft);
    }
}
