import java.util.Random;

public class Array {
    private Random random;
    private int [] array;
    private int capacity;
    private int size;

    Array(int capacity){
        random = new Random();
        this.capacity = capacity;
        size = 0;
        array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = random.nextInt(100001);
            size++;
        }
    }
    Array(Array ob){
        this.capacity = ob.capacity;
        this.array = new int[this.capacity];
        for (int i = 0; i < capacity; i++) {
            this.array[i] = ob.array[i];
            size++;
        }
    }

    public void showArray(){
        for (int i = 0; i < size; i++) {
            if (i%5==0){
                System.out.println();
            }
            System.out.print(array[i]+"; ");
        }
        System.out.println();
    }

    public void addElement(int index, int value){
        if (size < capacity)size++;
        if (index < size){
            for (int i = size-1; i > index; i--) {
                array[i] = array[i-1];
            }
            array[index] = value;
        }
        if (index == size){
            array[index] = value;
        }

    }

    public void removeElement(int value){
        int findIndexElement = lineSearch(value);
        if (findIndexElement!= -1){
            for (int i = findIndexElement; i < size-1 ; i++) {
                array[i] = array[i+1];
            }
            size--;
        }else System.out.println("There is no element "+ value);


    }
    public int lineSearch(int value){
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
    public int biSearch(int value){
        int first = 0;
        int last = size - 1;
        int mid = size/2;
        while (array[mid]!=value && last!=mid && first!=mid){
            if (array[mid]<value){
                first = mid+1;
                mid = (first+last)/2;
            }else {
                last = mid-1;
                mid = (first+last)/2;
            }
        }
        if (array[first]==value){
            return first;
        }
        if (array[last]==value){
            return last;
        }
        return array[mid]==value ? mid : -1;
    }

    public void replace(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void bubbleSort(){
        double startTime = System.currentTimeMillis();
        for (int i = 0; i <size; i++) {
            for (int j = 0; j < size-1; j++) {
                if (array[j]>array[j+1]){
                    replace(j,j+1);
                }
            }
        }
        double finishTime = System.currentTimeMillis();
        System.out.println("BubbleSort time: " +(finishTime - startTime)/1000 + " sec.");
    }

    public void selectSort(){
        double startTime = System.currentTimeMillis();
        int i,j,index;
        for (i = 0; i <size-1; i++) {
            index = i;
            for (j = i+1; j < size; j++) {
                if (array[j]<array[index]){
                    index = j;
                }
            }
            replace(i,index);
        }
        double finishTime = System.currentTimeMillis();
        System.out.println("SelectSort time: " +(finishTime - startTime)/1000 + " sec.");
    }

    public void insertSort(){
        double startTime = System.currentTimeMillis();
        int i, j;
        for(i = 1;i < size; i++){
            int tmp = array[i];
            j = i;
            while(j > 0 && array[j-1] >= tmp){
                array[j] = array[j-1];
                --j;
            }
           array[j] = tmp;
        }
        double finishTime = System.currentTimeMillis();
        System.out.println("InsertSort time: " +(finishTime - startTime)/1000 + " sec.");
    }

}
