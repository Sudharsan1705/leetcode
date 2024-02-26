class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
         this.val=val;
         left=null;
         right=null;
    }
}

class Solution {
    boolean flag;
    public void traverse(Node root,List<Integer> l,int label){
        if(root == null){
            return;
        }
        else if(root.val == label){
            l.add(root.val);
            flag=true;
            return;
        }
        else{
            if(!flag){
               // System.out.println(root.val);
                l.add(root.val);
                traverse(root.left,l,label);
                traverse(root.right,l,label);
            }
            if(!flag){
                l.remove(l.size()-1);
            }
            
        }
    }
    public List<Integer> pathInZigZagTree(int label) {
        flag=false;
        List<Integer> l = new ArrayList<>();
        int lev=1,val=1;
        while(val<label){
            val+=Math.pow(2,lev);
            lev++;
        }
        lev--;
        Node root=new Node(1);
        Queue<Node> q=new LinkedList<>();
        int lv=1;
        int v=1;
        q.add(root);
        while(lev-->0){
            int size=q.size();
            int temp=v+1;
            v+=Math.pow(2,lv);
           // System.out.println(v);
            if(lv%2 == 0){ 
              while(size-->0){
                  Node n=q.poll();
                  n.left=new Node(temp);
                  temp++;
                  n.right=new Node(temp);
                  temp++;
                  q.add(n.left);
                  q.add(n.right);
              }
            }
            else{
              temp=v;
              while(size-->0){
                  Node n=q.poll();
                  n.left=new Node(temp);
                  temp--;
                  n.right=new Node(temp);
                  temp--;
                  q.add(n.left);
                  q.add(n.right);
              } 
            }
            lv++;
        }
        traverse(root,l,label);
        return l;
    }
}