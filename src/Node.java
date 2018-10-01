/**
 * Class to represent a given space on the maze
 */

public class Node {

    //instance variables
    private int xCord;
    private int yCord;
    private Node parent;

    /**
     * Constructor
     * @param xCord
     * @param yCord
     */
    public Node(int xCord, int yCord)
    {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    /**
     *
     * @return
     */
    public int getxCord()
    {
        return xCord;
    }

    /**
     *
     * @return
     */
    public int getyCord()
    {
        return yCord;
    }

    /**
     *
     * @param parent
     */
    public void setParent(Node parent)
    {
        this.parent = parent;
    }

    /**
     *
     * @return
     */
    public Node getParent()
    {
        return parent;
    }

    @Override
    public String toString()
    {
        return "(" + xCord + "," + yCord + ")";
    }
}
