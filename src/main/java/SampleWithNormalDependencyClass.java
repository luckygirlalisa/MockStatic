import dependency.NormalDependency;

public class SampleWithNormalDependencyClass {

    public String generateSomeResult(NormalDependency normalDependency) {
        return "Id is " + normalDependency.generateSomeId();
    }
}
