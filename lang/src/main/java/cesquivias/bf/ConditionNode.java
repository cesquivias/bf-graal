package cesquivias.bf;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;

public class ConditionNode extends BFNode {
    private final FrameSlot ptr;
    private final FrameSlot data;

    ConditionNode(FrameSlot ptr, FrameSlot data) {
        this.ptr = ptr;
        this.data = data;
    }

    @Override
    public void execute(VirtualFrame frame) {
        executeCondition(frame);
    }

    public boolean executeCondition(VirtualFrame frame) {
        try {
            return ((byte[]) frame.getObject(data))[frame.getInt(ptr)] != 0;
        } catch (FrameSlotTypeException e) {
            CompilerDirectives.transferToInterpreter();
            e.printStackTrace();
        }
        return false;
    }
}
