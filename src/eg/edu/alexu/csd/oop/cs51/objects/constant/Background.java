package eg.edu.alexu.csd.oop.cs51.objects.constant;

import eg.edu.alexu.csd.oop.cs51.objects.AbstractObject;

public class Background extends AbstractObject{
    private static final String PATH = "res/background.jpg";
    
    public Background(int w, int h) {
        super(w, h, PATH, true, "");
    }
    
    public Background(Background background) {
        super(background);
    }

}
