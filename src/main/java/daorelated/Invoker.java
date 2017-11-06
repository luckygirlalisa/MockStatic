package daorelated;

public class Invoker {
    DaoInterface dao;

    public Invoker(DaoInterface dao) {
        this.dao = dao;
    }

    public String invokeDao() {
        return dao.doSomething();
    }
}
