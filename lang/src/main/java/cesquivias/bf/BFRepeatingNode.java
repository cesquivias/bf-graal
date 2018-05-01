package cesquivias.bf;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RepeatingNode;

public class BFRepeatingNode extends Node implements RepeatingNode {
    @Child private ConditionNode conditionNode;
    @Children private final BFNode[] body;

    public BFRepeatingNode(ConditionNode conditionNode, BFNode[] body) {
        this.conditionNode = conditionNode;
        this.body = body;
    }

    @Override
    @ExplodeLoop
    public boolean executeRepeating(VirtualFrame frame) {
        if (!conditionNode.executeCondition(frame)) {
            return false;
        }
        CompilerAsserts.compilationConstant(body.length);
        for (BFNode node : body) {
            node.execute(frame);
        }
        return true;
    }
}
