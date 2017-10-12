import dependency.AnotherNormalDependency;
import dependency.NormalDependency;

public class NormalSample {
    private AnotherNormalDependency anotherNormalDependency;

    public NormalSample(AnotherNormalDependency anotherNormalDependency) {
        this.anotherNormalDependency = anotherNormalDependency;
    }

    public String resultFromFreshCreatedDependency(NormalDependency normalDependency) {
        return "Id from parameter dependency is " + normalDependency.generateSomeId();
    }

    public String resultFromInjectedDependency() {
        return "Id from injected dependency is " + anotherNormalDependency.generateSomeId();
    }


    public String resultFromFreshCreatedDependency() {
        NormalDependency normalDependency = new NormalDependency();

        return "Id is " + normalDependency.generateSomeId();
    }
}