package daorelated;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class InvokerTestWithJMockit {
    Invoker invoker;

    @Test
    public void shouldNotCallMethodInDAOImpl() throws Exception {
        new MockUp<DaoImpl>() {
            @Mock
            void $clinit() {

            }

            @Mock
            public String doSomething() {
                return "mocked result";
            }

        };

        DaoImpl dao = new DaoImpl();

        invoker = new Invoker(dao);
        String result = invoker.invokeDao();

        assertEquals("mocked result", result);
    }
}

