package DynamicList;

import Classes_Schemas.LoginDetails;

public class Node {
    private LoginDetails loginInfo;
    private Node nextNode;

    //constructors
    public Node(LoginDetails data, Node next){
        loginInfo = data;
        nextNode = next;
    }
    public Node(LoginDetails data ){
        loginInfo = data;
        nextNode= null;
    }

    //getters
    public LoginDetails getLoginInfo() {
        return loginInfo;
    }
    public Node getNextNode() {
        return nextNode;
    }

    //setters
    public void setLoginInfo(LoginDetails loginInfo) {
        this.loginInfo = loginInfo;
    }
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
