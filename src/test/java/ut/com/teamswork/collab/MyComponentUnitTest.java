package ut.com.teamswork.collab;

import org.junit.Test;
import com.teamswork.collab.api.MyPluginComponent;
import com.teamswork.collab.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}