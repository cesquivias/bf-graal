package cesquivias.bf;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;
import com.oracle.truffle.api.nodes.RootNode;

import static cesquivias.bf.BFLanguage.ID;

@TruffleLanguage.Registration(id = ID, name = "BF", version = "1.0-SNAPSHOT",
        defaultMimeType = BFLanguage.MIME_TYPE, characterMimeTypes = BFLanguage.MIME_TYPE,
contextPolicy = TruffleLanguage.ContextPolicy.SHARED, fileTypeDetectors = BFFileDetector.class)
@ProvidedTags({StandardTags.StatementTag.class, StandardTags.RootTag.class})
public class BFLanguage extends TruffleLanguage<BFContext> {
    public static final String ID = "bf";
    public static final String MIME_TYPE = "application/x-bf";

    @Override
    protected BFContext createContext(Env env) {
        return new BFContext(this, env);
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        RootNode rootNode = BFParser.parse(this, request.getSource());
        return Truffle.getRuntime().createCallTarget(rootNode);
    }
}
