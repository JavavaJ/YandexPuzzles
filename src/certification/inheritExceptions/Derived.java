package certification.inheritExceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

class Derived extends Base {
    @Override
    public void print() throws IOException {
        throw new FileNotFoundException();
    }
}
