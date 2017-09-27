import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticDependency.class)
public class StaticDependencyTest {

//    @Test
//    public void shouldTestStaticMethodThrowException() {
//        PowerMockito.doThrow(new NotImplementedException()).when(StaticDependency.class);
//        StaticDependency.staticMethod("");
//    }
}