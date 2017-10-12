package wrapper;

import dependency.StaticDependency;

public class StaticDependencyWrapper {
    public String generateValueFromStatic() {
        return StaticDependency.generateSomeId();
    }
}
