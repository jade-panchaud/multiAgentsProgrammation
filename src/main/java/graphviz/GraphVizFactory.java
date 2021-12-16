package graphviz;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import trust.graph.FeedBackGraph;
import trust.graph.ReputationGraph;

import java.io.File;
import java.io.IOException;

public class GraphVizFactory {

    private static String directoryPath = "VisualizeGraph";
    private static String directorySeparator = "\\";

    public static void generateSvg(FeedBackGraph graph) throws IOException {
        Graphviz.fromString(graph.toDot())
                .render(Format.SVG)
                .toFile(new File(directoryPath + directorySeparator + "feedBack"));
    }

    public static void generateSvg(ReputationGraph graph) throws IOException {
        Graphviz.fromString(graph.toDot())
                .render(Format.SVG)
                .toFile(new File(directoryPath + directorySeparator + "reputationBack"));
    }
}
