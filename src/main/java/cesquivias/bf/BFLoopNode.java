package cesquivias.bf;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.LoopNode;

public class BFLoopNode extends BFNode {
    @Child private LoopNode loopNode;

    public BFLoopNode(ConditionNode conditionNode, BFNode[] body) {
        this.loopNode = Truffle.getRuntime().createLoopNode(new BFRepeatingNode(conditionNode, body));
    }

    @Override
    public void execute(VirtualFrame frame) {
        loopNode.executeLoop(frame);
    }
}
