package com.snc.facebook.phone;

public class RightSideView {
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int size= queue.size();
            
            for(int i=0; i<size; i++){
                
                TreeNode temp = queue.remove();
                
                if(i == size-1)
                    result.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                
                if(temp.right != null)
                    queue.add(temp.right);
                
                
            }
            
            
        }
        
        
        return result;
        
        
    }

}
