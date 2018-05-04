public class CompareTimeSorting {
    public static void main(String[] args) {

        Array array = new Array(100000);
        Array array1 = new Array(array);
        Array array2 = new Array(array);
        
        array.bubbleSort();
        array1.selectSort();
        array2.insertSort();
    }
}
