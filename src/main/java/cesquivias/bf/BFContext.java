package cesquivias.bf;

import com.oracle.truffle.api.TruffleContext;
import com.oracle.truffle.api.TruffleLanguage;

public class BFContext {
    public static final int MEMORY_SIZE = 10000;

    private final BFLanguage bfLanguage;
    private final TruffleLanguage.Env env;
    private final byte[] memory;

    public BFContext(BFLanguage bfLanguage, TruffleLanguage.Env env) {
        this.bfLanguage = bfLanguage;
        this.env = env;
        this.memory = new byte[MEMORY_SIZE];
    }
}
