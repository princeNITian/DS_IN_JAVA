package RedBlackTree;

public class App{
    public static void main(String [] args){
        Tree rbt = new RedBlackTree();
        rbt.insert(10);
        rbt.insert(20);
        rbt.insert(30);
        rbt.insert(80);
        rbt.insert(50);
        rbt.insert(40);
        rbt.insert(70);
        rbt.insert(60);
        rbt.traverse();
    }
}
