import dependency.AnotherNormalDependency;
import dependency.NormalDependency;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class NormalSample {
    private AnotherNormalDependency anotherNormalDependency;

    public NormalSample(AnotherNormalDependency anotherNormalDependency) {
        this.anotherNormalDependency = anotherNormalDependency;
    }

    public NormalSample() {
    }

    public String resultFromFreshCreatedDependency(NormalDependency normalDependency) {
        String beCalled = toBeCalled();
        String notMockedDependency = normalDependency.beRealCalled();
        return "Id from parameter dependency is " + normalDependency.generateSomeId() + " " + beCalled
                + " " + notMockedDependency;
    }

    public String resultFromInjectedDependency() {
        return "Id from injected dependency is " + anotherNormalDependency.generateSomeId();
    }


    public String resultFromFreshCreatedDependency() {
        NormalDependency normalDependency = new NormalDependency();

        return "Id is " + normalDependency.generateSomeId();
    }

    private String toBeCalled() {
        throw new NotImplementedException();
    }
}
