/*
** Jonathan Ruel 
** jon.ruel@my.ccsu.edu
** CS 253 Final Project
** Dijkstra's Algorithm
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra
{
    public static void main(String[] args)
    {
        Scanner user = new Scanner(System.in);
        String input = "";
        int squareNum = 0;
        // create an array of nodes that represent the graph of the board game Chutes & Ladders
        Node[] gameboard = buildGameboard();  
         
        System.out. println("~~~ Chutes & Ladders Pathfinder ~~~"); 
        do // continue to test paths until the user no longer wishes to do so
        {
            try
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.print("Enter your current square number [1-100]: ");
                squareNum = user.nextInt();
                
                System.out.println("Starting from square " +gameboard[squareNum - 1]+ ".");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                
                // special cases if player enters a number that has a chute
                // the player must go down the chute and calculate path from there
                if(squareNum == 98)
                    {squareNum = 78; System.out.println("*Must first take chute to square "+squareNum+"*");}
                if(squareNum == 95)
                    {squareNum = 75; System.out.println("*Must first take chute to square "+squareNum+"*");}
                if(squareNum == 93)
                    {squareNum = 73; System.out.println("*Must first take chute to square "+squareNum+"*");}
                if(squareNum == 87)
                    {squareNum = 24; System.out.println("*Must first take chute to square "+squareNum+"*");}
                if(squareNum == 64) 
                    {squareNum = 60; System.out.println("*Must first take chute to square "+squareNum+"*");}
                if(squareNum == 62)
                    {squareNum = 19; System.out.println("*Must first take chute to square "+squareNum+"*");}
                if(squareNum == 56)
                    {squareNum = 53; System.out.println("*Must first take chute to square "+squareNum+"*");}
                if(squareNum == 49)
                    {squareNum = 11; System.out.println("*Must first take chute to square "+squareNum+"*");}
                if(squareNum == 47)
                    {squareNum = 26; System.out.println("*Must first take chute to square "+squareNum+"*");}
                if(squareNum == 16)
                    {squareNum = 6; System.out.println("*Must first take chute to square "+squareNum+"*");}
            
                // use dijkstra's algorithm to compute the shortest path to win the game chutes and ladders. 
                findPaths(gameboard[squareNum - 1]);
                System.out.println("Distance from square " +gameboard[squareNum - 1]+ " to finish: " +gameboard[99].minDistance);
                // print a list of the nodes visited to get to the target
                System.out.println("Best Path:\n" + getShortestPathTo(gameboard[99]));
            
            }
            catch(Exception e) // check for valid user input
            {
                System.out.println("ERROR! Must enter an integer between 1 and 100!");
            }
            // ask the user to test another path if they wish to do so
            System.out.print("\nWould you like to test another path? [Y or N]:");
            input = user.next();
            if(input.equalsIgnoreCase("n")==false) // reset paths if user agrees to try again
            {
                System.out.println("resetting paths . . .");
                for(int i=0; i<gameboard.length; i++)
                {
                    // reset the distances to infinity nodes for the next path search
                    gameboard[i].minDistance = Double.POSITIVE_INFINITY;
                    gameboard[i].previous = null;
                }
            }
        }while(input.equalsIgnoreCase("n")==false);    
    }

    // dijkstra's algorithm to calculate shortest path
    public static void findPaths(Node source)
    {
        source.minDistance = 0;
        PriorityQueue<Node> vertexQueue = new PriorityQueue<Node>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) 
        {
            Node u = vertexQueue.poll();
            // visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Node v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) 
                {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Node> getShortestPathTo(Node target)
    {
        List<Node> path = new ArrayList<Node>();
        
        for (Node vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
                
        Collections.reverse(path);
        return path;
    }
    
    public static Node[] buildGameboard()
    {
        // create a node for each square on the board game, chutes & ladders
        Node n1 = new Node("1"); //start if 1st roll is 1
        Node n2 = new Node("2"); //start if 1st roll is 2
        Node n3 = new Node("3"); //start if 1st roll is 3
        Node n4 = new Node("4"); //start if 1st roll is 4
        Node n5 = new Node("5"); //start if 1st roll is 5
        Node n6 = new Node("6"); //start if 1st roll is 6
        Node n7 = new Node("7");
        Node n8 = new Node("8");
        Node n9 = new Node("9");
        Node n10 = new Node("10");
        Node n11 = new Node("11");
        Node n12 = new Node("12");
        Node n13 = new Node("13");
        Node n14 = new Node("14");
        Node n15 = new Node("15");
        Node n16 = new Node("16");
        Node n17 = new Node("17");
        Node n18 = new Node("18");
        Node n19 = new Node("19");
        Node n20 = new Node("20");
        Node n21 = new Node("21");
        Node n22 = new Node("22");
        Node n23 = new Node("23");
        Node n24 = new Node("24");
        Node n25 = new Node("25");
        Node n26 = new Node("26");
        Node n27 = new Node("27");
        Node n28 = new Node("28");
        Node n29 = new Node("29");
        Node n30 = new Node("30");
        Node n31 = new Node("31");
        Node n32 = new Node("32");
        Node n33 = new Node("33");
        Node n34 = new Node("34");
        Node n35 = new Node("35");
        Node n36 = new Node("36");
        Node n37 = new Node("37");
        Node n38 = new Node("38");
        Node n39 = new Node("39");
        Node n40 = new Node("40");
        Node n41 = new Node("41");
        Node n42 = new Node("42");
        Node n43 = new Node("43");
        Node n44 = new Node("44");
        Node n45 = new Node("45");
        Node n46 = new Node("46");
        Node n47 = new Node("47");
        Node n48 = new Node("48");
        Node n49 = new Node("49");
        Node n50 = new Node("50");
        Node n51 = new Node("51");
        Node n52 = new Node("52");
        Node n53 = new Node("53");
        Node n54 = new Node("54");
        Node n55 = new Node("55");
        Node n56 = new Node("56");
        Node n57 = new Node("57");
        Node n58 = new Node("58");
        Node n59 = new Node("59");
        Node n60 = new Node("60");
        Node n61 = new Node("61");
        Node n62 = new Node("62");
        Node n63 = new Node("63");
        Node n64 = new Node("64");
        Node n65 = new Node("65");
        Node n66 = new Node("66");
        Node n67 = new Node("67");
        Node n68 = new Node("68");
        Node n69 = new Node("69");
        Node n70 = new Node("70");
        Node n71 = new Node("71");
        Node n72 = new Node("72");
        Node n73 = new Node("73");
        Node n74 = new Node("74");
        Node n75 = new Node("75");
        Node n76 = new Node("76");
        Node n77 = new Node("77");
        Node n78 = new Node("78");
        Node n79 = new Node("79");
        Node n80 = new Node("80");
        Node n81 = new Node("81");
        Node n82 = new Node("82");
        Node n83 = new Node("83");
        Node n84 = new Node("84");
        Node n85 = new Node("85");
        Node n86 = new Node("86");
        Node n87 = new Node("87");
        Node n88 = new Node("88");
        Node n89 = new Node("89");
        Node n90 = new Node("90");
        Node n91 = new Node("91");
        Node n92 = new Node("92");
        Node n93 = new Node("93");
        Node n94 = new Node("94");
        Node n95 = new Node("95");
        Node n96 = new Node("96");
        Node n97 = new Node("97");
        Node n98 = new Node("98");
        Node n99 = new Node("99");
        Node n100 = new Node("100"); // finish, game over

        // create edges that connect each node to other nodes
        // agencency lists for each node
        n1.adjacencies = new Edge[]{new Edge(n2,1),new Edge(n38,1)};//ladder 1 to 38
        n2.adjacencies = new Edge[]{new Edge(n3,1)};
        n3.adjacencies = new Edge[]{new Edge(n4,1)};
        n4.adjacencies = new Edge[]{new Edge(n5,1),new Edge(n14,1)};//ladder 4 to 14
        n5.adjacencies = new Edge[]{new Edge(n6,1)};
        n6.adjacencies = new Edge[]{new Edge(n7,1)};
        n7.adjacencies = new Edge[]{new Edge(n8,1)};
        n8.adjacencies = new Edge[]{new Edge(n9,1)};
        n9.adjacencies = new Edge[]{new Edge(n10,1),new Edge(n31,1)};//ladder 9 to 31
        n10.adjacencies = new Edge[]{new Edge(n11,1)};
        n11.adjacencies = new Edge[]{new Edge(n12,1)};
        n12.adjacencies = new Edge[]{new Edge(n13,1)};
        n13.adjacencies = new Edge[]{new Edge(n14,1)};
        n14.adjacencies = new Edge[]{new Edge(n15,1)};
        n15.adjacencies = new Edge[]{new Edge(n16,1)};
        n16.adjacencies = new Edge[]{new Edge(n17,1),new Edge(n6,1)};//chute 16 to 6
        n17.adjacencies = new Edge[]{new Edge(n18,1)};
        n18.adjacencies = new Edge[]{new Edge(n19,1)};
        n19.adjacencies = new Edge[]{new Edge(n20,1)};
        n20.adjacencies = new Edge[]{new Edge(n21,1)};
        n21.adjacencies = new Edge[]{new Edge(n22,1),new Edge(n42,1)};//ladder 21 to 42
        n22.adjacencies = new Edge[]{new Edge(n23,1)};
        n23.adjacencies = new Edge[]{new Edge(n24,1)};
        n24.adjacencies = new Edge[]{new Edge(n25,1)};
        n25.adjacencies = new Edge[]{new Edge(n26,1)};
        n26.adjacencies = new Edge[]{new Edge(n27,1)};
        n27.adjacencies = new Edge[]{new Edge(n28,1)};
        n28.adjacencies = new Edge[]{new Edge(n29,1),new Edge(n84,1)};//ladder 28 to 84
        n29.adjacencies = new Edge[]{new Edge(n30,1)};
        n30.adjacencies = new Edge[]{new Edge(n31,1)};
        n31.adjacencies = new Edge[]{new Edge(n32,1)};
        n32.adjacencies = new Edge[]{new Edge(n33,1)};
        n33.adjacencies = new Edge[]{new Edge(n34,1)};
        n34.adjacencies = new Edge[]{new Edge(n35,1)};
        n35.adjacencies = new Edge[]{new Edge(n36,1)};
        n36.adjacencies = new Edge[]{new Edge(n37,1),new Edge(n44,1)};//ladder 36 to 44
        n37.adjacencies = new Edge[]{new Edge(n38,1)};
        n38.adjacencies = new Edge[]{new Edge(n39,1)};
        n39.adjacencies = new Edge[]{new Edge(n40,1)};
        n40.adjacencies = new Edge[]{new Edge(n41,1)};
        n41.adjacencies = new Edge[]{new Edge(n42,1)};
        n42.adjacencies = new Edge[]{new Edge(n43,1)};
        n43.adjacencies = new Edge[]{new Edge(n44,1)};
        n44.adjacencies = new Edge[]{new Edge(n45,1)};
        n45.adjacencies = new Edge[]{new Edge(n46,1)};
        n46.adjacencies = new Edge[]{new Edge(n47,1)};
        n47.adjacencies = new Edge[]{new Edge(n48,1),new Edge(n26,1)};//chute 47 to 26
        n48.adjacencies = new Edge[]{new Edge(n49,1)};
        n49.adjacencies = new Edge[]{new Edge(n50,1),new Edge(n11,1)};//chute 49 to 11
        n50.adjacencies = new Edge[]{new Edge(n51,1)};
        n51.adjacencies = new Edge[]{new Edge(n52,1),new Edge(n67,1)};//ladder 51 to 67
        n52.adjacencies = new Edge[]{new Edge(n53,1)};
        n53.adjacencies = new Edge[]{new Edge(n54,1)};
        n54.adjacencies = new Edge[]{new Edge(n55,1)};
        n55.adjacencies = new Edge[]{new Edge(n56,1)};
        n56.adjacencies = new Edge[]{new Edge(n57,1),new Edge(n53,1)};//chute 56 to 53
        n57.adjacencies = new Edge[]{new Edge(n58,1)};
        n58.adjacencies = new Edge[]{new Edge(n59,1)};
        n59.adjacencies = new Edge[]{new Edge(n60,1)};
        n60.adjacencies = new Edge[]{new Edge(n61,1)};
        n61.adjacencies = new Edge[]{new Edge(n62,1)};
        n62.adjacencies = new Edge[]{new Edge(n63,1),new Edge(n19,1)};//chute 62 to 19
        n63.adjacencies = new Edge[]{new Edge(n64,1)};
        n64.adjacencies = new Edge[]{new Edge(n65,1),new Edge(n60,1)};//chute 64 to 60
        n65.adjacencies = new Edge[]{new Edge(n66,1)};
        n66.adjacencies = new Edge[]{new Edge(n67,1)};
        n67.adjacencies = new Edge[]{new Edge(n68,1)};
        n68.adjacencies = new Edge[]{new Edge(n69,1)};
        n69.adjacencies = new Edge[]{new Edge(n70,1)};
        n70.adjacencies = new Edge[]{new Edge(n71,1)};
        n71.adjacencies = new Edge[]{new Edge(n72,1),new Edge(n91,1)};//ladder 71 to 91
        n72.adjacencies = new Edge[]{new Edge(n73,1)};
        n73.adjacencies = new Edge[]{new Edge(n74,1)};
        n74.adjacencies = new Edge[]{new Edge(n75,1)};
        n75.adjacencies = new Edge[]{new Edge(n76,1)};
        n76.adjacencies = new Edge[]{new Edge(n77,1)};
        n77.adjacencies = new Edge[]{new Edge(n78,1)};
        n78.adjacencies = new Edge[]{new Edge(n79,1)};
        n79.adjacencies = new Edge[]{new Edge(n80,1)};
        n80.adjacencies = new Edge[]{new Edge(n81,1),new Edge(n100,1)};//ladder 80 to 100
        n81.adjacencies = new Edge[]{new Edge(n82,1)};
        n82.adjacencies = new Edge[]{new Edge(n83,1)};
        n83.adjacencies = new Edge[]{new Edge(n84,1)};
        n84.adjacencies = new Edge[]{new Edge(n85,1)};
        n85.adjacencies = new Edge[]{new Edge(n86,1)};
        n86.adjacencies = new Edge[]{new Edge(n87,1)};
        n87.adjacencies = new Edge[]{new Edge(n88,1),new Edge(n24,1)};//chute 87 to 24
        n88.adjacencies = new Edge[]{new Edge(n89,1)};
        n89.adjacencies = new Edge[]{new Edge(n90,1)};
        n90.adjacencies = new Edge[]{new Edge(n91,1)};
        n91.adjacencies = new Edge[]{new Edge(n92,1)};
        n92.adjacencies = new Edge[]{new Edge(n93,1)};
        n93.adjacencies = new Edge[]{new Edge(n94,1),new Edge(n73,1)};//chute 93 to 73
        n94.adjacencies = new Edge[]{new Edge(n95,1)};
        n95.adjacencies = new Edge[]{new Edge(n96,1),new Edge(n75,1)};//chute 95 to 75
        n96.adjacencies = new Edge[]{new Edge(n97,1)};
        n97.adjacencies = new Edge[]{new Edge(n98,1)};
        n98.adjacencies = new Edge[]{new Edge(n99,1),new Edge(n78,1)};//chute 98 to 78
        n99.adjacencies = new Edge[]{new Edge(n100,1)};
        n100.adjacencies = new Edge[]{new Edge(n1,1)};//terminating edge
        
        // array implementation of the vertices of the graph just created
        Node[] vertices = 
        {n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,
         n11,n12,n13,n14,n15,n16,n17,n18,n19,n20,
         n21,n22,n23,n24,n25,n26,n27,n28,n29,n30,
         n31,n32,n33,n34,n35,n36,n37,n38,n39,n40,
         n41,n42,n43,n44,n45,n46,n47,n48,n49,n50,
         n51,n52,n53,n54,n55,n56,n57,n58,n59,n60,
         n61,n62,n63,n64,n65,n66,n67,n68,n69,n70,
         n71,n72,n73,n74,n75,n76,n77,n78,n79,n80,
         n81,n82,n83,n84,n85,n86,n87,n88,n89,n90,
         n91,n92,n93,n94,n95,n96,n97,n98,n99,n100};
         
         return vertices;
    }
}

class Node implements Comparable<Node>
{
    public final String data;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Node previous;
    
    // constructor for node
    public Node(String data) 
    {
        // data of the node
        this.data = data; 
    }
    
    // return distance of edge between nodes
    public int compareTo(Node other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
    
    // return string representation of data
    public String toString() 
    { 
        return data; 
    }
}

class Edge
{
    public final Node target;
    public final double weight;
    
    // constructor for edge
    public Edge(Node target, double weight)
    { 
        // target node
        this.target = target;
        // weight of an edge
        this.weight = weight; 
    }
}