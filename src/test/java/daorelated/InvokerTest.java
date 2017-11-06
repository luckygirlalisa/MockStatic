package daorelated;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FrmPersistenceEntityManagerAccessor.class)
public class InvokerTest {
    Invoker invoker;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    @Ignore("Can't use power mock to mock static private field in dependency's parent class")
    public void shouldNotCallMethodInDAOImpl() throws Exception {
//        Field accessor = PowerMockito.field(DaoImpl.class, "accessor");
//        accessor.set(DaoImpl.class, mock(FrmPersistenceEntityManagerAccessor.class));
        Mockito.mock(FrmPersistenceEntityManagerAccessor.getAccessor().getClass());
        DaoImpl dao = mock(DaoImpl.class);
//        Field accessor = dao.getClass().getDeclaredField("accessor");
//        accessor.setAccessible(true);
//        accessor.set(dao, null);
//        Field accessor = FrmDao.class.getDeclaredField("accessor");
//        accessor.setAccessible(true);
//        accessor.set(FrmDao.class, null);


//        Field field = FrmDao.class.getDeclaredField("accessor");
//
//        field.setAccessible(true);
//
//        field.set(null, null);

        invoker = new Invoker(dao);

        invoker.invokeDao();
    }


    @Test
    public void shouldNotCallMethodInDAOAndItsParentStaticFieldInitialize() throws Exception {
        DaoInterface dao = mock(DaoInterface.class);

        Invoker invoker = new Invoker(dao);
        when(dao.doSomething()).thenReturn("mocked result");

        String result = invoker.invokeDao();

        assertEquals("mocked result", result);
    }

    @Test
    public void shouldNotCallMethodInDAOAndItsParentStaticFieldInitializeWithProductCode() throws Exception {
        Invoker invoker = new Invoker(new DaoInterface() {
            public String doSomething() {
                return "mocked result";
            }
        });

        String result = invoker.invokeDao();

        assertEquals("mocked result", result);
    }
}