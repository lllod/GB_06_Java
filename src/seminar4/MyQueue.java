package seminar4;

public class MyQueue {

    private Integer[] array = new Integer[16];
    private int size = 0;

    public void enqueue(int element){
        if (size == array.length) {
            Integer[] newArray = new Integer[array.length + 16];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = element;
    }


    public int dequeue(){
        int firstElement = array[0];
        Integer[] newArray = new Integer[array.length - 1];
        System.arraycopy(array, 1, newArray, 0, array.length - 1);
        array = newArray;
        return firstElement;
    }


    public int first(){
        return array[0];
    }


    public void print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer element : array) {
            if (element != null) {
                stringBuilder.append(element);
                stringBuilder.append(" ");
            }

        }
        System.out.println(stringBuilder.toString());
    }
}
