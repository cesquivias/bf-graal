package cesquivias.bf;

import com.beust.jcommander.JCommander;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;
import java.io.IOException;

public class Main {

    public static final String BF = "bf";

    public static void main(String[] args) throws IOException {
        Flags flags = new Flags();
        JCommander jCommander = new JCommander.Builder()
            .addObject(flags)
            .build();
        jCommander.parse(args);
        if (flags.isHelp) {
            jCommander.usage();
            return;
        }

        Source src = Source.newBuilder(BF, new File(flags.script)).build();
        Context context = Context.newBuilder(BF).in(System.in).out(System.out).build();
        for (int i = 0; i < flags.iterations; i ++) {
            context.eval(src);
        }
    }
}
