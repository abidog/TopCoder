import java.util.*;

public class DisjointSet {


    public static void main(String[] args) {


        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findParent(1));
        System.out.println(ds.findParent(2));
        System.out.println(ds.findParent(3));
        System.out.println(ds.findParent(4));
        System.out.println(ds.findParent(5));
        System.out.println(ds.findParent(6));
        System.out.println(ds.findParent(7));


    }

    Map<Long, Node> map =  new HashMap<>();
    class Node{
        long data;
        Node parent;
        int rank;
        public Node(long data) {
          this.data = data;
        }
    }

    public void makeSet(long l) {
        Node n = new Node(l);
        n.parent = n;
        n.rank = 0;
        map.put(l, n);
    }

    public boolean union(long l1, long l2) {
        Node n1 = map.get(l1);
        Node n2 = map.get(l2);

        Node p1 = findSet(n1);
        Node p2 = findSet(n2);

        if (p1.data == p2.data) {
            return false;
        }

        if (p1.rank >= p2.rank) {
            p1.rank = p1.rank == p2.rank ? p1.rank + 1 : p2.rank;
            p2.parent = p1;
        } else {
            p1.parent = p2;
        }

        return true;

    }

    private long findParent(long l1) {

        return findSet(map.get(l1)).data;
    }

    public Node findSet(Node node) {

        Node parent = node.parent;
        if (node.data == parent.data) {
            return node;
        }
        node.parent = findSet(node.parent);
        return node.parent;

    }

}
