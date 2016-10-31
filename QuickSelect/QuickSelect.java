public class QuickSelect{

    public int QuickSelect(int[] arr, int k) {
        if( arr == null || arr.length = 0 || 
            k < 0 || arr.lengh < k ) {
            return Integer.MIN_VALUE;
        }
        return QuickSelect(arr, k, 0, arr.length);
    }

    private int QuickSelect(int[] arr, int k, int first, int last) {
        if( first <= last ) {
            int pivot = partition(arr, first, last);

            if( pivot < k ) {
                return QuickSelect(arr, k, first, pivot - 1);
            } else if( pivot > k ) {
                return QuickSelect(arr, k, pivot + 1, last);
            } else {
                return arr[k];
            }

        }
        return Integer.MIN_VALUE;
    }

    private int partition( int[] arr, int first, int last ) {
        if( first >= last ) {
            return;
        }
        int pivot = first + new Random().nextInt(last - first + 1);

        swap(arr, last, pivot);
        for(int i = 0; i < last; i++) {
            if( arr[i] <= arr[last] ) {
                swap(arr, i, first);
                first++;
            }
        }

        swap(arr, last, first);
        return first;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}