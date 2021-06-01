package training.my.eventlistener;

import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import training.my.event.MyEvent;


public class MyEventListener extends AbstractEventListener<MyEvent> {

    @Override
    protected void onEvent(MyEvent myEvent) {
            System.out.println("User added something to a cart");
    }
}
