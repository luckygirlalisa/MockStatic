package daorelated;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FrmPersistenceEntityManagerAccessor {

    private static FrmPersistenceEntityManagerAccessor accessor = new FrmPersistenceEntityManagerAccessor();

    private FrmPersistenceEntityManagerAccessor() {
        throw new NotImplementedException();
    }

    public static FrmPersistenceEntityManagerAccessor getAccessor() {
        return accessor;
    }
}
