package hu.benyuss.binaryTree;

import hu.benyuss.binaryTree.implementation.LZWBinaryTree;
import hu.benyuss.binaryTree.traversing.TraversConst;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeProcess {

    TraversConst travWay;

    public TraversConst getTravWay() {
        return travWay;
    }

    public void setTravWay(TraversConst travWay) {
        this.travWay = travWay;
    }

    public Map<String, String> makefun(String bits) {
        Map<String, String> treeData = new HashMap<>();

        LZWBinaryTree lzwTree = new LZWBinaryTree();
        lzwTree.add(bits, travWay);

        String[] results = lzwTree.depth(travWay);
        lzwTree.setDepth(Integer.parseInt(results[1]));
        lzwTree.setAvg(lzwTree.averageDepth(travWay));
        lzwTree.setVar(lzwTree.variance(travWay));
        lzwTree.setHash(lzwTree.hashCode());

        treeData.put("bits", bits);
        treeData.put("depth", Integer.toString(lzwTree.getDepth()));
        treeData.put("avg", Double.toString(lzwTree.getAvg()));
        treeData.put("var", Double.toString(lzwTree.getVar()));
        treeData.put("log", results[0]);

        return treeData;
    }


}
