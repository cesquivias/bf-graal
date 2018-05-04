package cesquivias.bf;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;

public class IncDataNode extends BFNode {
    private final FrameSlot ptr;
    private final FrameSlot data;

    public IncDataNode(FrameSlot ptr, FrameSlot data) {
        this.ptr = ptr;
        this.data = data;
    }

    @Override
    public void execute(VirtualFrame frame) {
        try {
            ((byte[]) frame.getObject(data))[frame.getInt(ptr)]++;
        } catch (FrameSlotTypeException e) {
            CompilerDirectives.transferToInterpreter();
            e.printStackTrace();
        }
    }
}
