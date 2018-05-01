package cesquivias.bf;

import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;

public class DecPointerNode extends BFNode {
    final FrameSlot ptr;

    public DecPointerNode(FrameSlot ptr) {
        this.ptr = ptr;
    }

    @Override
    public void execute(VirtualFrame frame) {
        try {
            frame.setInt(ptr, frame.getInt(ptr) - 1);
        } catch (FrameSlotTypeException e) {
            e.printStackTrace();
        }
    }
}
