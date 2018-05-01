package cesquivias.bf;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;
import java.io.IOException;

public class Main {

    public static final String BF = "bf";

    public static void main(String[] args) throws IOException {
        Source src = Source.newBuilder(BF, new File(args[0])).build();
        Context context = Context.newBuilder(BF).in(System.in).out(System.out).build();
        Value val = context.eval(src);
    }
}
