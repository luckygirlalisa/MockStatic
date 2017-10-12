import org.junit.Test;
import wrapper.StaticDependencyWrapper;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StaticSampleWithWrapperTest {
    @Test
    public void generateSomethingFromStaticDependency() throws Exception {
        StaticDependencyWrapper dependencyWrapper = mock(StaticDependencyWrapper.class);
        when(dependencyWrapper.generateValueFromStatic()).thenReturn("preDefinedId");
        StaticSampleWithWrapper staticSample = new StaticSampleWithWrapper(dependencyWrapper);

        String result = staticSample.generateSomethingFromStaticDependency();

        assertEquals("Id is preDefinedId", result);
    }
}