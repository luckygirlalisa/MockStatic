public class SampleClass {
    public void doSomethingWithStaticDependency(String inputString) {
        StaticDependency.staticMethod(inputString);
    }

    public String generateSomethingFromStaticDependency() {
        String someId = StaticDependency.generateSomeId();

        return "Id is " + someId;
    }
}
