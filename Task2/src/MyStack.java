public class MyStack {
    public  int size;
    private int top;
    private Vertice[] array;
    public MyStack(int size){
        array = new Vertice[size];
        this.size = size;
        top = -1;
    }

    public void push(Vertice v){
        array[++top] = v;
    }
    public Vertice pop(){
        return array[top--];
    }
    public Vertice peek(){
        return array[top];
    }
    public boolean isEmpty(){
        if (top ==-1){
            return true;
        }
        else{
            return false;
        }
    }
}
