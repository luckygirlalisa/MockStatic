import wrapper.StaticDependencyWrapper;

public class StaticSampleWithWrapper {
    StaticDependencyWrapper wrapper = new StaticDependencyWrapper();

    public StaticSampleWithWrapper(StaticDependencyWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public String generateSomethingFromStaticDependency() {
        String someId = wrapper.generateValueFromStatic();

        return "Id is " + someId;
    }

}
