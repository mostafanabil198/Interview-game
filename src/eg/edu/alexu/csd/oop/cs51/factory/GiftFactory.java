package eg.edu.alexu.csd.oop.cs51.factory;

import eg.edu.alexu.csd.oop.cs51.objects.Movable;
import eg.edu.alexu.csd.oop.cs51.objects.gifts.EmptyStack;
import eg.edu.alexu.csd.oop.cs51.objects.gifts.ExtraLife;

public class GiftFactory implements IFactory {

    @Override
    public Movable createNewMovable(String unused, String giftName)
            throws InstantiationException, IllegalAccessException {
        if(giftName.equals("ExtraLife")) {
            return new ExtraLife();
        } else if (giftName.equals("EmptyStack")){
            return new EmptyStack();
        }
        return null;
    }

}
