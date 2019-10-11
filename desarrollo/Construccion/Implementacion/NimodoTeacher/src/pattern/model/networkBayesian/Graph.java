package pattern.model.networkBayesian;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes = new ArrayList<>();

    public void setNodes(List<Node> nodes){
        this.nodes = nodes;
    }

    public List<Node> getNodes(){
        return nodes;
    }

    public void addNode(Node node){
        node.setId(node.getId());
        node.setName(node.getName());
        nodes.add(node);
    }
     
    public void clear(){
        nodes.clear();
    }

}
