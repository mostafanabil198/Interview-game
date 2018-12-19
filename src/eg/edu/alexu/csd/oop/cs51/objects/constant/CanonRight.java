package eg.edu.alexu.csd.oop.cs51.objects.constant;

import eg.edu.alexu.csd.oop.cs51.objects.AbstractObject;

public class CanonRight extends AbstractObject{
    private static final String PATH = "res/canonRight.png";
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    public CanonRight() {
        super(WIDTH, HEIGHT, PATH, true, "");
        // TODO Auto-generated constructor stub
    }
    
    public CanonRight(CanonRight canonRight) {
        super(canonRight);
    }

}
