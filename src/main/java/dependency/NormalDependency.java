package dependency;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class NormalDependency {
    private String oneProperty;

    public String generateSomeId() {
        throw new NotImplementedException();
    }

    public String getOneProperty() {
        return oneProperty;
    }

    public void setOneProperty(String oneProperty) {

        this.oneProperty = oneProperty;
    }
}
