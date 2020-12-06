
public class DemoGeneric<T> {
    int code;
    String message;
    T data;

    public DemoGeneric(T data) {
        this.data = data;
    }
}

// DemoGeneric<Student>
// data, code, message