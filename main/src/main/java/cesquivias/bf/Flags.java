package cesquivias.bf;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Flags {
    @Parameter(arity = 1, description = "<bf-script>")
    String script;

    @Parameter(names = {"-n", "--num"},
            arity = 1,
            description = "Execute <bf-script> this number of times")
    int iterations = 1;

    @Parameter(names = {"-h", "--help"}, help = true,
            description = "This help text")
    boolean isHelp = false;
}
