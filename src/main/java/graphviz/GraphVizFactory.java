package graphviz;

import agent.Agent;
import guru.nidi.graphviz.engine.Engine;
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
                .engine(Engine.DOT)
                .render(Format.SVG)
                .toFile(new File(directoryPath + directorySeparator + "feedBack"));
    }

    public static void generateSvg(ReputationGraph graph) throws IOException {
        Graphviz.fromString(graph.toDot())
                .engine(Engine.NEATO)
                .render(Format.SVG)
                .toFile(new File(directoryPath + directorySeparator + "reputationBack"));
    }


    public static void generateSvg(Agent agent) throws IOException {
        String path = directoryPath + directorySeparator + agent.getName();
//        Graphviz.fromString(agent.getFeedBackGraph().toDot())
//                .engine(Engine.DOT)
//                .render(Format.SVG)
//                .toFile(new File(path + directorySeparator + "feedBack"));

        Graphviz.fromString(agent.getReputationGraph().toDot())
                .engine(Engine.NEATO)
                .render(Format.SVG)
                .toFile(new File(path + directorySeparator + "reputationBack"));
    }
}
