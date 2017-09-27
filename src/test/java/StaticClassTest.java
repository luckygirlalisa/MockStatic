import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticDependency.class)
public class StaticClassTest {
    @Test
    public void shouldVerifyStaticMethodIsCalledWithCorrectParameter() {
        PowerMockito.mockStatic(StaticDependency.class);

        SampleClass sampleClass = new SampleClass();
        sampleClass.doSomething("test");

        PowerMockito.verifyStatic(StaticDependency.class);
        StaticDependency.staticMethod("test");
    }

    @Test
    public void shouldVerifyNumbersOfCalls() throws Exception {
        PowerMockito.mockStatic(StaticDependency.class);

        SampleClass sampleClass = new SampleClass();
        sampleClass.doSomething("test");


        PowerMockito.verifyStatic(StaticDependency.class, Mockito.times(1));
        StaticDependency.staticMethod("test");
    }
}
