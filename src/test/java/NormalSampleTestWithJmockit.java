
import dependency.NormalDependency;
import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JMockit.class)
public class NormalSampleTestWithJmockit {
    private NormalDependency normalDependency;
    private NormalSample normalSample;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldMockBehaviourOfDependencyAsParameter() throws Exception {
        new MockUp<NormalDependency>() {
            @Mock
            public String generateSomeId() {
                return "preFakedId";
            }
        };

        new MockUp<NormalSample>() {
            @Mock
            private String toBeCalled() {
                return "haha";
            }
        };

        normalDependency = new NormalDependency();
        normalSample = new NormalSample();

        String result = normalSample.resultFromFreshCreatedDependency(normalDependency);

        assertEquals("Id from parameter dependency is preFakedId haha Not mocked", result);
    }
}
