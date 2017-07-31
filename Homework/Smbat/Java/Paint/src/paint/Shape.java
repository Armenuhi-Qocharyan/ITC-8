package paint;

import java.io.PrintStream;

public interface Shape {
    public boolean draw(PrintStream out, char symbol);
}
