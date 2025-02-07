package LeetcodeSolutions.BitManipulation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class cloneGraph {
    
    // depth-first Traversal
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode graph){
          if(graph == null) return null;
          Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
          return DFS(graph, map);
    }

    private UndirectedGraphNode DFS(UndirectedGraphNode graph, Map<UndirectedGraphNode, UndirectedGraphNode> map){
        if(map.containsKey(graph)){
            return map.get(graph);
        }

        UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
        map.put(graph, graphCopy);
        for(UndirectedGraphNode neighbor : graph.neighbors){
            graphCopy.neighbors.add(DFS(neighbor, map));
        }
        return graphCopy;
    }




    // BreadthFirst Traversal
     public UndirectedGraphNode cloneGraphBreadth(UndirectedGraphNode graph){
         if(graph == null) return null;
          Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
          Queue<UndirectedGraphNode> q = new LinkedList<>();
          q.add(graph);
          UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
          map.put(graph, graphCopy);
          while(!q.isEmpty()){
            UndirectedGraphNode node = q.poll();
            for(UndirectedGraphNode neighbor : node.neighbors){
                if(map.containsKey(neighbor)){
                    map.get(node).neighbors.add(map.get(neighbor));
                } else{
                   UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                   map.get(node).neighbors.add(neighborCopy);
                   map.put(neighbor, neighborCopy);
                   q.add(neighbor); 
                }
            }
          }
        return graphCopy;
     }
}
