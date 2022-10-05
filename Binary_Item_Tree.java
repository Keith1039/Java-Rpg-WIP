public class Binary_Item_Tree {
    private Node root;

    public static class Node{
        private int value;
        private int amount;
        private String item_name;
        private Node prev;
        private Node greater_than;
        private Node less_than;

        public Node(String string){
            String numString =" ";
            item_name=string;
            char[] chars = string.toCharArray();
            this.value = 0;
            for(int i=0; i< chars.length;i++){
                numString= Integer.toString((int)chars[i]);
            }
            this.amount=1;
            value= Integer.parseInt(numString);
        }
        public Node(){

        }
    }
        
    public void push(String string){
        Node new_node = new Node(string);
        Boolean flag = false;
        if(root == null){
            root= new_node;
        }
        else{
            Node current_node=root;
            while(flag==false){
                if(current_node.value<new_node.value && current_node.greater_than==null){
                    current_node.greater_than=new_node;
                    new_node.prev=current_node;
                    flag=true;
                }
                else if(current_node.value>new_node.value&&current_node.less_than==null){
                    current_node.less_than=new_node;
                    new_node.prev=current_node;
                    flag=true;
                }
                else if(current_node.value<new_node.value){
                    current_node=current_node.greater_than;
                }
                else if(current_node.value>new_node.value){
                    current_node=current_node.less_than;
                }
                else if(current_node.value==new_node.value){
                    current_node.amount++;
                    flag=true;
                }
            }
        }

    }

    public Boolean is_in(String string){
        Boolean flag = false;
        Node new_node= new Node(string);
        Node current_node= root;
        while(current_node != null){
            if(current_node.value < new_node.value){
                current_node=current_node.greater_than;
            }
            else if(current_node.value>new_node.value){
                current_node=current_node.less_than;
            }
            else if(current_node.value== new_node.value){
                current_node=null;
                flag=true;
            }
        }
        return(flag);
    }

    public void use_item(String string){
        if(is_in(string)==false){
            System.out.println("You do not have this item.");
        }
        else{
            Node new_node = new Node(string);
            Boolean flag=false;
            Node current_node= root;
            while(flag==false){
                if(current_node.value < new_node.value){
                    current_node=current_node.greater_than;
                }
                else if(current_node.value>new_node.value){
                    current_node=current_node.less_than;
                }
                else if(current_node.value== new_node.value){ //removes it
                    flag=true;
                    current_node.amount--;
                    if(current_node.amount==0){
                        if(current_node.value>current_node.prev.value){
                            current_node.prev.greater_than=null;
                        }
                        else{
                            current_node.prev.less_than=null;
                        }
                    }
                }

            }

        }
    }

    public String toString(){
        Node current_node=root;
        if(current_node==null){
            return("[ ]");
        }
        Boolean flag1=false;
        String returnable = "[ "+current_node.item_name+ " x"+Integer.toString(current_node.amount)+", ";
        
        Node right_side = current_node.greater_than;
        Node left_side= current_node.less_than;
        
        Node most_right=new Node();
        Node most_left= new Node();

        int tracker2=0;
        int tracker=0;

        Node new_pos = new Node();
        while(right_side!= null){
            returnable+= right_side.item_name+" x"+Integer.toString(right_side.amount)+", ";
            if(right_side.greater_than == null){
                most_right=right_side;
            }
            right_side=right_side.greater_than;
        }
        while(most_right!=root && most_right.item_name != null){
            if(new_pos== most_right){
                most_right=most_right.prev;
                tracker2=0;
            }
            if(most_right.less_than!= null && tracker2 ==0){
                new_pos=most_right.less_than;
                tracker2=1;
                returnable+= new_pos.item_name+" x"+Integer.toString(new_pos.amount)+", ";
                right_side=new_pos.greater_than;
                while(right_side!= null){
                    returnable+= right_side.item_name+" x"+Integer.toString(right_side.amount)+", ";
                    if(right_side.greater_than == null){
                        new_pos=right_side;
                    }
                    right_side=right_side.greater_than;
                }
            }
            if(most_right.less_than == null){
                most_right=most_right.prev;
                tracker2=0;
            }

            if(new_pos.less_than==null && new_pos.prev != null){
                new_pos=new_pos.prev;

            }
            if(new_pos.less_than != null && returnable.indexOf(new_pos.less_than.item_name)==-1 ){
                new_pos=new_pos.less_than;
                returnable+= new_pos.item_name+" x"+Integer.toString(new_pos.amount)+", ";
                right_side=new_pos.greater_than;
                while(right_side!= null){
                    returnable+= right_side.item_name+" x"+Integer.toString(right_side.amount)+", ";
                    if(right_side.greater_than == null){
                        new_pos=right_side;
                    }
                    right_side=right_side.greater_than;
                }
            }
            if(new_pos.less_than != null && returnable.indexOf(new_pos.less_than.item_name)!=-1){
                new_pos=new_pos.prev;
            }
            
        }

        while(left_side!= null){
            returnable+= left_side.item_name+" x"+Integer.toString(left_side.amount)+", ";
            if(left_side.less_than == null){
                most_left=left_side;
            }
            left_side=left_side.less_than;
        }
        
        while(most_left!=root && root.less_than != null){
            new_pos= new Node();
            if(new_pos== most_left){
                most_left=most_left.prev;
                tracker2=0;
            }
            if(most_left.greater_than!= null && tracker2 ==0){
                new_pos=most_right.greater_than;
                tracker2=1;
                returnable+= new_pos.item_name+" x"+Integer.toString(new_pos.amount)+", ";
                left_side=new_pos.less_than;
                while(left_side!= null){
                    returnable+= left_side.item_name+" x"+Integer.toString(left_side.amount)+", ";
                    if(left_side.less_than == null){
                        new_pos=left_side;
                    }
                    left_side=left_side.less_than;
                }
            }
            if(most_left.greater_than == null){
                most_left=most_left.prev;
                tracker2=0;
            }

            if(new_pos.greater_than==null && new_pos.prev!= null){
                new_pos=new_pos.prev;
            }
            if(new_pos.greater_than != null && returnable.indexOf(new_pos.greater_than.item_name)==-1){
                new_pos=new_pos.greater_than;
                returnable+= new_pos.item_name+" x"+Integer.toString(new_pos.amount)+", ";
                left_side=new_pos.less_than;
                while(left_side!= null){
                    returnable+= left_side.item_name+" x"+Integer.toString(left_side.amount)+", ";
                    if(left_side.less_than == null){
                        new_pos=left_side;
                    }
                    left_side=left_side.less_than;
                }
            }
            if(new_pos.greater_than!= null && returnable.indexOf(new_pos.greater_than.item_name)!=-1){
                new_pos=new_pos.prev;
            }
            
        }
        returnable+="]";
        return(returnable);
    }




    
}
