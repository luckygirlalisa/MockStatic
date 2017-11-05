package daorelated;

public class Invoker {
    DaoImpl dao;

    public Invoker(DaoImpl dao) {
        this.dao = dao;
    }

    public String invokeDao() {
        return dao.doSomething();
    }
}
