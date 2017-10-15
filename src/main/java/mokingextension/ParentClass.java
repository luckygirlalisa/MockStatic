package mokingextension;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ParentClass {
    public String save() {
        throw new NotImplementedException();
    }

    //There's no way to avoid calling static block in parent class when initialize child class instance.
//    static {
//        if (true) {
//            throw new NotImplementedException();
//        }
//    }
}
