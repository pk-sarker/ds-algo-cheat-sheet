package com.dsalgo.sorting;

import java.util.*;

public class TopologicalSort {
    public static class Node {
        public int value;
        public LinkedList<Node> adjacent = new LinkedList<>();

        Node(int val) {
            this.value= val;
        }
    }
    HashMap<Integer, Node> graph = new HashMap<>();
    HashMap<Integer, Integer> inComingEdges = new HashMap<>();

    public Node getNode(int value) {
        if  (!this.graph.containsKey(value)) {
            this.graph.put(value, new Node(value));
        }
        return this.graph.get(value);
    }

    public void addEdge(int source, int destination)  {
        Node src = getNode(source);
        Node dest = getNode(destination);
        src.adjacent.offer(dest);
        this.inComingEdges.put(destination, this.inComingEdges.getOrDefault(destination, 0)+1);
    }

    public List<Node> order() {
        // Set of all nodes with no incoming edge
        LinkedList<Node> nodesWithNoInEdge = this.getNodesWithoutInEdge();
        List<Node> result = new ArrayList<>();

        //  while S is not empty do
        while(!nodesWithNoInEdge.isEmpty()) {
            // remove a node n from S
            Node node = nodesWithNoInEdge.poll();
            // add n to L
            result.add(node);

            if (!node.adjacent.isEmpty()) {
                // for each node m with an edge e from n to m do
                Iterator<Node> nodeItr = node.adjacent.iterator();
                while(nodeItr.hasNext()) {
                    Node adjNode = nodeItr.next();
                    // remove edge e from the graph
                    // graph.get(node.value).adjacent.removeIf( adj -> adj.value == adjNode.value); -> moved down
                    this.inComingEdges.put(adjNode.value, this.inComingEdges.get(adjNode.value)-1);
                    // if m has no other incoming edges then
                    if (this.inComingEdges.get(adjNode.value) == 0) {
                        // insert m into S
                        nodesWithNoInEdge.add(adjNode);
                    }
                }
                // remove edge e from the graph
                graph.get(node.value).adjacent.removeIf(adj -> node.adjacent.contains(adj));
            }

            node.adjacent.clear();
        }

        // if graph has edges then return error (graph has at least one cycle)
        int edges = 0;
        for(int key : this.graph.keySet()) {
            edges += this.graph.get(key).adjacent.size();
        }
        if (edges > 0) {
            return null;
        } else {
            // else return L (a topologically sorted order)
            return result;
        }
    }

    public LinkedList<Node> getNodesWithoutInEdge() {
        LinkedList<Node> nodesWithNoInEdge = new LinkedList<>();
        Set<Integer> allAdjacents = new HashSet<>();
        Set<Integer> allNodes = new HashSet<>();
        for(Integer key : graph.keySet()) {
            allNodes.add(key);
            LinkedList<Node> adj = graph.get(key).adjacent;
            if (adj.size()>0) {
                for(int i=0; i<adj.size(); i++) {
                    allAdjacents.add(adj.get(i).value);
                    allNodes.add(adj.get(i).value);
                }
            }
        }
        for(Integer node: allNodes) {
            if (!allAdjacents.contains(node)) {
                nodesWithNoInEdge.add(getNode(node));
            }
        }


        StringBuilder sb = new StringBuilder();
        nodesWithNoInEdge.forEach((Node node) -> {
            sb.append(node.value + ", ");
        });

        return nodesWithNoInEdge;
    }


    public static void main(String args[]) {
        TopologicalSort ob = new TopologicalSort();
        ob.addEdge(1, 3);
        ob.addEdge(3, 2);
        ob.addEdge(2, 4);
        ob.addEdge(5, 3);
        ob.addEdge(3, 4);


        List<Node> res = ob.order();
        StringBuilder sb = new StringBuilder();
        for(Node node: res) {
            sb.append(node.value+" > ");
        }
        sb.setLength(sb.length()-3);
        System.out.println(sb.toString());

    }
}
