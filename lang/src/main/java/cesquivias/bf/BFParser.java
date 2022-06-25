package cesquivias.bf;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.source.Source;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BFParser {
    public static RootNode parse(BFLanguage bfLanguage, Source source) throws IOException {
        FrameDescriptor frameDescriptor = new FrameDescriptor();
        FrameSlot ptr = frameDescriptor.addFrameSlot("ptr", FrameSlotKind.Int);
        FrameSlot data = frameDescriptor.addFrameSlot("data", FrameSlotKind.Object);
        List<BFNode> nodes = new ArrayList<>();
        nodes.add(new BFInitNode(ptr, data));
        Stack<List<BFNode>> loops = new Stack<>();
        Reader reader = source.getReader();
        int i = reader.read();
        while (i != -1) {
            switch ((char) i) {
            case '>':
                nodes.add(new IncPointerNode(ptr));
                break;
            case '<':
                nodes.add(new DecPointerNode(ptr));
                break;
            case '+':
                nodes.add(new IncDataNode(ptr, data));
                break;
            case '-':
                nodes.add(new DecDataNode(ptr, data));
                break;
            case '.':
                nodes.add(new PrintDataNode(ptr, data));
                break;
            case ',':
                nodes.add(new ReadDataNode(ptr, data));
                break;
            case '[':
                loops.push(nodes);
                nodes = new ArrayList<>();
                break;
            case ']':
                BFNode loopNode = new BFLoopNode(new ConditionNode(ptr, data), nodes.toArray(new BFNode[] {}));
                nodes = loops.pop();
                nodes.add(loopNode);
                break;
            }
            i = reader.read();
        }
        return new BFRootNode(bfLanguage, frameDescriptor, nodes);
    }
}
