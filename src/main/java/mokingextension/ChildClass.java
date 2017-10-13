package mokingextension;

public class ChildClass extends ParentClass {
    public String saveWith(String toBeSaved) {
        this.save();

        return "Successfully saved: " + toBeSaved;
    }
}
