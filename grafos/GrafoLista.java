
import java.util.ArrayList;
import java.util.List;

public class GrafoLista {
    private final List<List<Integer>> adj;

    public GrafoLista(int n) {
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public boolean saoVizinhos(int u, int v) {
        return adj.get(u).contains(v);
    }

    public int grau(int u) {
        return adj.get(u).size();
    }
}
