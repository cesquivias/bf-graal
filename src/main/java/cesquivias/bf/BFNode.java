package cesquivias.bf;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;

public abstract class BFNode extends Node {
    public abstract void execute(VirtualFrame frame);
}
