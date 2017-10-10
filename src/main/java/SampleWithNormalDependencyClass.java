import dependency.AnotherNormalDependency;
import dependency.NormalDependency;

public class SampleWithNormalDependencyClass {

    public SampleWithNormalDependencyClass(AnotherNormalDependency anotherNormalDependency) {

    }

    public String resultFromParameterDependency(NormalDependency normalDependency) {
        return "Id is " + normalDependency.generateSomeId();
    }

    public String resultFromInjectedDependency(AnotherNormalDependency anotherNormalDependency) {
        return "Id from injected dependency is " + anotherNormalDependency.generateSomeId();
    }
}
