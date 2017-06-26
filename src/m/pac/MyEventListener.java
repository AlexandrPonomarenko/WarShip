package m.pac;

import java.util.EventListener;

public interface MyEventListener extends EventListener
{
    public void clickButton(MyEventObject eventObject);
}
