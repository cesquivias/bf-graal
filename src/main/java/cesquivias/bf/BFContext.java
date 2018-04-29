package cesquivias.bf;

import com.oracle.truffle.api.TruffleContext;
import com.oracle.truffle.api.TruffleLanguage;

public class BFContext {
    private final BFLanguage bfLanguage;
    private final TruffleLanguage.Env env;

    public BFContext(BFLanguage bfLanguage, TruffleLanguage.Env env) {
        this.bfLanguage = bfLanguage;
        this.env = env;
    }
}
