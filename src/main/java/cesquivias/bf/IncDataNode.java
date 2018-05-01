package cesquivias.bf;

import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;

public class IncDataNode extends BFNode {
    private FrameSlot ptr;
    private FrameSlot data;

    public IncDataNode(FrameSlot ptr, FrameSlot data) {
        this.ptr = ptr;
        this.data = data;
    }

    @Override
    public void execute(VirtualFrame frame) {
        try {
            ((byte[]) frame.getObject(data))[frame.getInt(ptr)]++;
        } catch (FrameSlotTypeException e) {
            e.printStackTrace();
        }
    }
}
