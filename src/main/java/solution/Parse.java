package solution;

import java.io.InputStream;

public interface Parse<T> {
    T from(InputStream input);
}
