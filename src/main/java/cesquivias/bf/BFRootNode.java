package cesquivias.bf;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.RootNode;

import java.util.List;

public class BFRootNode extends RootNode {
    @Children private final BFNode[] nodes;

    protected BFRootNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, List<BFNode> nodes) {
        super(language, frameDescriptor);
        this.nodes = nodes.toArray(new BFNode[] {});
    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame frame) {
        CompilerAsserts.compilationConstant(nodes.length);
        for (BFNode node : nodes) {
            node.execute(frame);
        }
        return 0;
    }
}
