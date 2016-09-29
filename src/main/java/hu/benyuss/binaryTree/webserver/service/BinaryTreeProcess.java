package hu.benyuss.binaryTree.webserver.service;

import hu.benyuss.binaryTree.implementation.TreeBuilder;
import hu.benyuss.binaryTree.binaryTreeUtils.traversing.TraversConst;

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

    public Map<String, String> processTree(String bits) { //TODO
        Map<String, String> treeData = new HashMap<>();
        //we'll put every data into that map then pass the whole collection as one in the controller
        // instead of pass these datas one by one.

        TreeBuilder lzwTree = new TreeBuilder();
        lzwTree.add(bits, travWay);

        String[] results = lzwTree.depth(travWay);
        lzwTree.setDepth(Integer.parseInt(results[1]));
        lzwTree.setAvg(lzwTree.averageDepth(travWay));
        lzwTree.setVar(lzwTree.variance(travWay));

        treeData.put("log", results[0]);
        treeData.put("bits", bits);
        treeData.put("depth", Integer.toString(lzwTree.getDepth()));
        treeData.put("avg", Double.toString(lzwTree.getAvg()));
        treeData.put("var", Double.toString(lzwTree.getVar()));

        return treeData;
    }


}
