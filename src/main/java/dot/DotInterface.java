package dot;

import org.jgrapht.nio.Attribute;

import java.util.Map;

public interface DotInterface {

    Map<String, Attribute> getStyle();

    void setLabel(String label);

    String getName();

    void setName(String name);
}
