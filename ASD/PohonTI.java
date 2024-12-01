import java.util.*;

class Reseller {
    String id;
    int point;
    List<Reseller> children;

    public Reseller(String id) {
        this.id = id;
        this.point = 0;
        this.children = new ArrayList<>();
    }
}

public class PohonTI {
    private Map<String, Reseller> map = new HashMap<>();
    private Reseller root;

    public void buildTree(String yrId, List<String[]> queries) {
        root = new Reseller(yrId);
        map.put(yrId, root);

        for (String[] query : queries) {
            String idA = query[0];
            String idB = query[1];

            map.putIfAbsent(idA, new Reseller(idA));
            map.putIfAbsent(idB, new Reseller(idB));

            Reseller parent = map.get(idA);
            Reseller child = map.get(idB);

            parent.children.add(child);
            tambahPoin(idA, 2);
        }
    }

    private void tambahPoin(String id, int poin) {
        while (id != null) {
            map.get(id).point += poin;
            poin = 1;
            id = cariUpline(id);
        }
    }

    private String cariUpline(String id) {
        for (Reseller reseller : map.values()) {
            for (Reseller child : reseller.children) {
                if (child.id.equals(id)) {
                    return reseller.id;
                }
            }
        }
        return null;
    }

    public List<String> preorderTraversal() {
        List<String> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(Reseller node, List<String> result) {
        if (node == null) return;
        result.add(node.id + " " + node.point);
        for (Reseller child : node.children) {
            preorder(child, result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String yrId = scanner.nextLine();
        int T = Integer.parseInt(scanner.nextLine());

        List<String[]> queries = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            String[] input = scanner.nextLine().split(" ");
            queries.add(input);
        }

        PohonTI tree = new PohonTI();
        tree.buildTree(yrId, queries);

        List<String> result = tree.preorderTraversal();
        for (String line : result) {
            System.out.println(line);
        }

        scanner.close();
    }
}
