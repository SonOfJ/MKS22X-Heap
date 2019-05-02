public class MyHeap {
  private static void pushDown(int[] data, int size, int index) {
    if (size > index * 2 + 1) { //There will only be pushing when a new row is needed.
      if (size != index * 2 + 2) { //If the final row isn't complete.
        if (data[index * 2 + 1] > data[index * 2 + 2]) { //If the left value is greater than the right value...
          int hold = data[index]; //Swap the left value with the upper value.
          data[index] = data[index * 2 + 1];
          data[index * 2 + 1] = hold;
          pushDown(data, size, index * 2 + 1); //Move on the the bottom left value.
        }
      }
    }
  private static void pushUp(int[]data,int index)
  public static void heapify(int[])
  public static void heapsort(int[])
}
