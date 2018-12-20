package eg.edu.alexu.csd.oop.cs51.objects.constant;

import eg.edu.alexu.csd.oop.cs51.objects.AbstractObject;

public class CanonObject extends AbstractObject{
    private static final String PATH = "res/canons.png";
    private static final int WIDTH = 1366;
    private static final int HEIGHT = 150;

    public CanonObject() {
        super(WIDTH, HEIGHT, PATH, true, "");
    }
    
    public CanonObject(CanonObject canonLeft) {
        super(canonLeft);
    }

    @Override
    public AbstractObject clone() {
        return new CanonObject(this);
    }
    @Override
    public void setX(int x) {
    }
    
    @Override
    public void setY(int y) {
    }
}
