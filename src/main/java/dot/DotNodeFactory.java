package dot;

public class DotNodeFactory {


    public static DotInterface getDefaultDotNode() {
        return new DotNode("", "", "", "black");
    }

    public static DotInterface getBlueDotNode() {
        return new DotNode("", "", "", "blue");
    }

    public static DotInterface getBlueDotNode(String label) {
        return new DotNode(label, "", "", "blue");
    }

    public static DotInterface getRedDotNode() {
        return new DotNode("", "", "", "Red");
    }

    public static DotInterface getRedDotNode(String label) {
        return new DotNode(label, "", "", "Red");
    }

}
