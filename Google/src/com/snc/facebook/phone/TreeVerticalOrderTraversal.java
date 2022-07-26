package com.snc.facebook.phone;

public class TreeVerticalOrderTraversal {

	
	   
    static class Pair{
        TreeNode node;
        int hd;
        
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
       
        
        List<List<Integer>> result = new ArrayList<>();
        
         if(root == null)
             return result;
        
        Queue<Pair> queue = new LinkedList<>();
        
        Pair p = new Pair();
        p.node=root;
        p.hd=0;
        queue.add(p);
        Map<Integer ,  ArrayList<Integer>> treeMap = new TreeMap<>();
        
        while(!queue.isEmpty()){
            
            Pair temp = queue.remove();
            
            TreeNode node=temp.node;
            
            if(treeMap.containsKey(temp.hd)){
                ArrayList<Integer> list = treeMap.get(temp.hd);
                list.add(node.val);
                treeMap.put(temp.hd , list);
             }
            
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(node.val);
            treeMap.put(temp.hd , list);
            }
            
            if(node.left != null){
                Pair leftP = new Pair();
                leftP.node=node.left;
                leftP.hd = temp.hd-1;
                queue.add(leftP);
            }
                
               if(node.right != null){
                Pair rightP = new Pair();
                rightP.node=node.right;
                rightP.hd = temp.hd+1;
                queue.add(rightP);
            }
                
        }
        
        for(Entry<Integer , ArrayList<Integer>> entry : treeMap.entrySet()){
            
            result.add(entry.getValue());
        }
        
        return result;
        
    }
}
