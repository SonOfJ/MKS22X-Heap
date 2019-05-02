public class MyHeap {
  private static void pushDown(int[] data, int size, int index) {
    if (size > index * 2 + 1) { //There will only be pushing when a new row is needed.
      if (size != index * 2 + 2) { //If the final row isn't complete.
        if (data[index * 2 + 1] > data[index * 2 + 2]) { //If the left value is greater than the right value...
          if (data[index * 2 + 1] > data[index]) { //Only if the bottom value is bigger than the top value...
            int hold = data[index]; //Swap the left value with the upper value.
            data[index] = data[index * 2 + 1];
            data[index * 2 + 1] = hold;
            pushDown(data, size, index * 2 + 1); //Move on to the the bottom left value.
          }
        } else if (data[index * 2 + 2] > data[index]) { //If the right value is bigger, check to see if it is bigger than the top value.
          int hold = data[index]; //Swap the right value with the upper value.
          data[index] = data[index * 2 + 2];
          data[index * 2 + 2] = hold;
          pushDown(data, size, index * 2 + 2); //Move on to the bottom right value.
        }
      } else if (data[index * 2 + 1] > data[index]) { //If the final row is complete and the bottom left value is bigger than the top value...
        int hold = data[index]; //Simply swap the two.
        data[index] = data[index * 2 + 1];
        data[index * 2 + 1] = hold;
      }
    }
  }
  public static void heapify(int[] data) {
    for (int i = data.length - 1; i > -1; i = i - 1) {
      pushDown(data, data.length, i); //Starts from the bottom value because my push only compares the current value with lower values.
    }
  }
  public static void heapsort(int[] data) {
    heapify(data); //Got to convert the array to a heap first.
    for (int i = data.length; i > 0; i = i - 1) { //Start from the bottom value and leave the largest values at the end.
      int hold = data[0]; //Switch the bottom element with the top element and let the pushing do the work.
      data[0] = data[i - 1];
      data[i - 1] = hold;
      pushDown(data, i - 1, 0);
    }
  }
}
