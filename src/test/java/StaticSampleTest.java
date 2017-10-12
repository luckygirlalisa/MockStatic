import dependency.StaticDependency;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticDependency.class)
public class StaticSampleTest {

    private StaticSample staticSample;

    @Before
    public void setUp() {
        staticSample = new StaticSample();
    }

    @Test
    public void shouldVerifyStaticMethodIsCalledWithCorrectParameter() {
        PowerMockito.mockStatic(StaticDependency.class);

        staticSample.doSomethingWithStaticDependency("test");

        PowerMockito.verifyStatic(StaticDependency.class);
        StaticDependency.staticMethod("test");
    }

    @Test
    public void shouldVerifyNumbersOfCalls() throws Exception {
        PowerMockito.mockStatic(StaticDependency.class);

        staticSample.doSomethingWithStaticDependency("test");

        PowerMockito.verifyStatic(StaticDependency.class, Mockito.times(1));
        StaticDependency.staticMethod("test");
    }

    @Test
    public void shouldGetPreDefinedOutputFromStaticMethod() throws Exception {
        PowerMockito.mockStatic(StaticDependency.class);
        Mockito.when(StaticDependency.generateSomeId()).thenReturn("preFakedId");

        String result = staticSample.generateSomethingFromStaticDependency();

        assertEquals("Id is preFakedId", result);
    }
}
