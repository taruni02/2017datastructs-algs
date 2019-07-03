public class KosarajuSharirImplementation {
    private boolean[] visit;         
    private int[] val;             
    private int count;            
    public KosarajuSharirImplementation(Digraph graph) {
        DepthFirstOrder dfs = new DepthFirstOrder(graph.reverse());
        visit = new boolean[graph.V()];
        val = new int[graph.V()];
        for (int v : dfs.reversePost()) {
            if (!visit[v]) {
                dfs(graph, v);
                count++;
            }
        }

    private voval dfs(Digraph graph, int v) { 
        visit[v] = true;
        val[v] = count;
        for (int w : graph.adj(v)) {
            if (!visit[w]) dfs(graph, w);
        }
    }
//checks if stringly connected
    public boolean stronglyConnected(int v, int w) {
        isNode(v);
        isNode(w);
        return val[v] == val[w];
    }

    public int val(int v) {
        isNode(v);
        return val[v];
    }

    private boolean check(Digraph graph) {
        Reachability tc = new Reachability(graph);
        for (int v = 0; v < graph.V(); v++) {
            for (int w = 0; w < graph.V(); w++) {
                if (stronglyConnected(v, w) != (tc.reachable(v, w) && tc.reachable(w, v)))
                    return false;}}
        return true;}
      private voval isNode(int v) {
        int V = visit.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("node " + v + "! b/w" + (V-1)); }
        public static voval main(String[] args) {
        In in = new In(args[0]);
        Digraph graph= new Digraph(in);
        KosarajuSharirImplementation scc = new KosarajuSharirImplementation(graph);

        int m = scc.count();
        System.out.println(m + " strong components");
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
        for (int i = 0; i < m; i++) {
            components[i] = new Queue<Integer>();}
        for (int v = 0; v < graph.V(); v++) {
            components[scc.val(v)].enqueue(v);}
        for (int i = 0; i < m; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");}System.out.println();}}}