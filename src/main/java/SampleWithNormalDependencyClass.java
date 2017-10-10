import dependency.AnotherNormalDependency;
import dependency.NormalDependency;

public class SampleWithNormalDependencyClass {
    private AnotherNormalDependency anotherNormalDependency;

    public SampleWithNormalDependencyClass(AnotherNormalDependency anotherNormalDependency) {
        this.anotherNormalDependency = anotherNormalDependency;
    }

    public String resultFromParameterDependency(NormalDependency normalDependency) {
        return "Id is " + normalDependency.generateSomeId();
    }

    public String resultFromInjectedDependency() {
        return "Id from injected dependency is " + anotherNormalDependency.generateSomeId();
    }


}
