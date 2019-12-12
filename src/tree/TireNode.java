package tree;

class TireNode {
    public char val;
    public boolean isWord;
    public TireNode[] children = new TireNode[26];

    TireNode() {

    }

    TireNode(char val) {
        TireNode tireNode = new TireNode();
        tireNode.val = val;
    }
}
