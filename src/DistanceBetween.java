public class DistanceBetween {
    public DistanceBetween(){}

    // Calculates the Manhattan distance between 2 nodes
    public int distance(Node from, Node to){
        int distance;
        distance = Math.abs(to.getxCord() - from.getxCord()) + Math.abs(to.getyCord() - from.getyCord());
        return distance;
    }
}