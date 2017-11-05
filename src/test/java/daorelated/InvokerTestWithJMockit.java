package daorelated;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import static org.mockito.Mockito.mock;


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

        invoker = new Invoker(dao);

        invoker.invokeDao();
    }
}

