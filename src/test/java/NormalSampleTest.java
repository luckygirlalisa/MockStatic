import dependency.AnotherNormalDependency;
import dependency.NormalDependency;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class NormalSampleTest {
    @Mock
    private NormalDependency normalDependency;
    @Mock
    private AnotherNormalDependency anotherNormalDependency;
    private NormalSample normalSample;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        normalSample = new NormalSample(anotherNormalDependency);
    }

    @Test
    public void shouldMockBehaviourOfDependencyAsParameter() throws Exception {
        when(normalDependency.generateSomeId()).thenReturn("preFakedId");

        String result = normalSample.resultFromFreshCreatedDependency(normalDependency);

        verify(normalDependency).generateSomeId();
        verify(normalDependency, times(1)).generateSomeId();
        assertEquals("Id from parameter dependency is preFakedId", result);
    }

    @Test
    public void shouldMockInjectedDependencyBehaviour() throws Exception {
        when(anotherNormalDependency.generateSomeId()).thenReturn("preFakedId");

        String result = normalSample.resultFromInjectedDependency();

        verify(anotherNormalDependency).generateSomeId();
        verify(anotherNormalDependency, times(1)).generateSomeId();
        assertEquals("Id from injected dependency is preFakedId", result);
    }

    @Test
    @Ignore("Should not pass since new created instance couldn't be mocked.")
    public void shouldNotBeAbleToMockCreatedInstanceInMethodToBeTested() throws Exception {
        when(normalDependency.generateSomeId()).thenReturn("preFakedId");

        String result = normalSample.resultFromFreshCreatedDependency();

        assertEquals("Id from parameter dependency is preFakedId", result);
    }
}
