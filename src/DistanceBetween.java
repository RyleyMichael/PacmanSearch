/**
 * Class to find the distance between two given nodes
 */
public class DistanceBetween
{

    //constructor
    public DistanceBetween()
    {

    }

    /**
     * Calculates the Manhattan distance between 2 nodes
     * @param from the current node
     * @param to the node of interest
     * @return the distance between from and to
     */
    public int distance(Node from, Node to){
        int distance;
        distance = Math.abs(to.getxCord() - from.getxCord()) + Math.abs(to.getyCord() - from.getyCord());

        //experimental
        from.sethScore(distance);

        return distance;
    }
}