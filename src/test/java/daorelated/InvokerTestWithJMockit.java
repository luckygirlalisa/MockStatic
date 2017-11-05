package daorelated;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class InvokerTestWithJMockit {
    Invoker invoker;


    public static class MockedFrmPersistenceEntityManagerAccessor extends MockUp<FrmPersistenceEntityManagerAccessor>
    {
        @Mock
        void $init() { }

        @Mock
        public static FrmPersistenceEntityManagerAccessor getAccessor() {
            return null;
        }
    }

    @Test
    public void shouldNotCallMethodInDAOImpl() throws Exception {
        new MockedFrmPersistenceEntityManagerAccessor();
        DaoImpl dao = mock(DaoImpl.class);
        when(dao.doSomething()).thenReturn("mocked result");

        invoker = new Invoker(dao);
        String result = invoker.invokeDao();

        assertEquals("mocked result", result);
    }
}

