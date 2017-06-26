package m.pac;


import java.util.EventObject;

public class MyEventObject extends EventObject
{
    private String state;
    public  MyEventObject(Object object, String stateButton)
    {
        super(object);
        state = stateButton;
    }

    public String getState()
    {
        return state;
    }
}
