package mokingextension;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ParentClass.class)
public class ChildClassTest {

    @Test
    public void shouldMockParentMethod() throws Exception {
        PowerMockito.suppress(PowerMockito.method(ParentClass.class));

        ChildClass childClass = new ChildClass();

        String toBeSaved = "This is funny";
        String savedByChild = childClass.saveWith(toBeSaved);

        assertEquals("Successfully saved: " + toBeSaved, savedByChild);
    }
}