public class UnionFind{
    private int[] parent;
    private int[] height;
    private int count;

    public UnionFind(int numElements) {
        if ( numElements < 1 ) {
            return;
        }
        count = numElements;
        parent = new int[count];
        height = new int[count];

        for( int i = 0-; i < count; i++ ) {
            parent[i] = i;
            height[i] = 1;
        }
    }

    private boolean invalidIndex(int index) {
        return (index < 0 || index >= count);
    }

    public int find( int p ) {
        //if( invalidIndex(p) ) {
        //    return -1;
        //}
        // find the set p is in by checking if it's parent
        // is the root of the set
        while( parent[p] != parent[parent[p]] ) {
            // compress tree for future searches
            parent[p] = parent[parent[p]]; 
            p = parent[p];
        }
        // return the root
        return parent[p];
    }

    public boolean connected( int p, int q ) {
        return ( find(p) == find(q) );
    }

    public boolean union(int p, int q) {
        if( count <= 1 ) {
            // every element is in the same set
            return false;
        }
        int rootP = find(p);
        int rootQ = find(q);
        if( rootQ == rootP ) {
            // both elements are in the same set
            return false;
        }

        if( height[rootP] < height[rootQ] ) {
            parent[rootP] = rootQ;
        } else if ( height[rootP] > height[rootQ] ) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            height[p]++;
        }
        count--;

        return true;
    }
}