package cesquivias.bf;

import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;

import java.io.IOException;

public class ReadDataNode extends BFNode {
    private final FrameSlot ptr;
    private final FrameSlot data;

    public ReadDataNode(FrameSlot ptr, FrameSlot data) {
        this.ptr = ptr;
        this.data = data;
    }

    @Override
    public void execute(VirtualFrame frame) {
        try {
            ((byte[]) frame.getObject(data))[frame.getInt(ptr)] = (byte) System.in.read();
        } catch (FrameSlotTypeException | IOException e) {
            e.printStackTrace();
        }
    }
}
