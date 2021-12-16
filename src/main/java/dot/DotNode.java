package dot;

import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;

import java.util.HashMap;
import java.util.Map;

public class DotNode implements DotInterface {

    protected String label;
    protected String name;
    protected String shape;
    protected String color;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public DotNode(String label, String name, String shape, String color) {
        this.label = label;
        this.name = name;
        this.shape = shape;
        this.color = color;
    }

    @Override
    public Map<String, Attribute> getStyle() {
        Map<String, Attribute> map = new HashMap<>();
        map.put("label", DefaultAttribute.createAttribute(label));
        map.put("shape", DefaultAttribute.createAttribute(shape));
        map.put("color", DefaultAttribute.createAttribute(color));
        return map;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }
}
