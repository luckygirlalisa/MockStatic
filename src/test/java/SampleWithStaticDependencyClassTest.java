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
public class SampleWithStaticDependencyClassTest {

    private SampleWithStaticDependencyClass sampleWithStaticDependencyClass;

    @Before
    public void setUp() {
        sampleWithStaticDependencyClass = new SampleWithStaticDependencyClass();
    }

    @Test
    public void shouldVerifyStaticMethodIsCalledWithCorrectParameter() {
        PowerMockito.mockStatic(StaticDependency.class);

        sampleWithStaticDependencyClass.doSomethingWithStaticDependency("test");

        PowerMockito.verifyStatic(StaticDependency.class);
        StaticDependency.staticMethod("test");
    }

    @Test
    public void shouldVerifyNumbersOfCalls() throws Exception {
        PowerMockito.mockStatic(StaticDependency.class);

        sampleWithStaticDependencyClass.doSomethingWithStaticDependency("test");

        PowerMockito.verifyStatic(StaticDependency.class, Mockito.times(1));
        StaticDependency.staticMethod("test");
    }

    @Test
    public void shouldGetPreDefinedOutputFromStaticMethod() throws Exception {
        PowerMockito.mockStatic(StaticDependency.class);
        Mockito.when(StaticDependency.generateSomeId()).thenReturn("preFakedId");

        String result = sampleWithStaticDependencyClass.generateSomethingFromStaticDependency();

        assertEquals("Id is preFakedId", result);
    }
}
