package cesquivias.bf;

import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;

public class BFInitNode extends BFNode {
    public static final int MEMORY_SIZE = 10000;
    private final FrameSlot ptr;
    private final FrameSlot data;

    public BFInitNode(FrameSlot ptr, FrameSlot data) {
        this.ptr = ptr;
        this.data = data;
    }

    @Override
    public void execute(VirtualFrame frame) {
        frame.setInt(ptr, 0);
        frame.setObject(data, new byte[MEMORY_SIZE]);
    }
}
