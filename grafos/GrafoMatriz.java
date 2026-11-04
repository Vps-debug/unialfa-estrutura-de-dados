
public class GrafoMatriz {
    private final int[][] adj;
    private final int n;

    public GrafoMatriz(int n) {
        this.n = n;
        this.adj = new int[n][n];
    }

    public void adicionarAresta(int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    public boolean saoVizinhos(int u, int v) {
        return adj[u][v] == 1;
    }

    public int grau(int u) {
        int g = 0;

        for (int v = 0; v < n; v++) {
            g += adj[u][v];
        }

        return g;
    }
}
