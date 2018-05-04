package cesquivias.bf;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
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
            ((byte[]) frame.getObject(data))[frame.getInt(ptr)] = stdinRead();
        } catch (FrameSlotTypeException | IOException e) {
            CompilerDirectives.transferToInterpreter();
            e.printStackTrace();
        }
    }

    @TruffleBoundary
    private byte stdinRead() throws IOException {
        return (byte) System.in.read();
    }
}
