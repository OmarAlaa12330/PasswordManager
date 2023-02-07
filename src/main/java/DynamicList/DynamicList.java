package DynamicList;

import Classes_Schemas.LoginDetails;

public class DynamicList {
     private int amount;
     private Node head;

     public DynamicList(){
         head = null;
         amount = 0;
     }

     public DynamicList(LoginDetails loginDetails){
         head = new Node(loginDetails, head);
         amount++;
     }


    @Override
    public String toString() {
        StringBuilder outcome = new StringBuilder();
        for (Node cur = head; cur != null; cur= cur.getNextNode()){
            outcome.append(cur.getLoginInfo());
        }
        return outcome.toString();
    }
}
