package tree;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * @author gaoyh
 */
public class Trie {
    private TireNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TireNode(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TireNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TireNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TireNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TireNode tireNode = node.children[c - 'a'];
            if (tireNode == null) {
                return false;
            }
            node = tireNode;
        }
        return node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TireNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TireNode tireNode = node.children[c - 'a'];
            if (tireNode == null) {
                return false;
            }
            node = tireNode;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
}