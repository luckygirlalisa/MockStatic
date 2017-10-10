import dependency.NormalDependency;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class SampleWithNormalDependencyClassTest {
    @Mock
    NormalDependency normalDependency;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldMockDependencyBehaviourOut() throws Exception {
        SampleWithNormalDependencyClass sampleWithNormalDependencyClass = new SampleWithNormalDependencyClass();
        when(normalDependency.generateSomeId()).thenReturn("preFakedId");

        String result = sampleWithNormalDependencyClass.generateSomeResult(normalDependency);

        assertEquals("Id is preFakedId", result);
    }
}
