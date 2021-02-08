import java.util.*;

public class HeapSorting {
    public static int[] arr;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Input length(array):");
        int length = input.nextInt();
        arr = new int[length];
        System.out.println("==============");
        for(int i = 0; i < length; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Do you want to delete(Y/N):");
        String str = input.next();
        if(str.equals("Y")){
            System.out.print("Input(position):");
            int sum = input.nextInt();
            arr = delete(sum);
        }
        System.out.print("Do you want add number(Y/N):");
        String str2 = input.next();
        if(str2.equals("Y")){
            System.out.print("Input:");
            int sum2 = input.nextInt();
            int n = arr.length;
            arr = insert(sum2, n);
        }
        System.out.println("");
        System.out.println(Arrays.toString(arr));
        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.print("Solution:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] insert(int num, int n) {
        int newArr[] = new int[n + 1];
        for (int i = 0; i < n; i++){ 
            newArr[i] = arr[i];
            newArr[n] = num;
        }
        return newArr;
        
    }
        public static int[] delete(int num){
            int[] proxyArray = new int[arr.length - 1];
            for (int i = 0, k = 0;  i < arr.length; i++){
                if (i == num) { 
                    continue; 
                } 
                proxyArray[k++] = arr[i];
            }
            return proxyArray;
        }
        public void sort(int arr[]){ 
            int n = arr.length; 
            for (int i = n / 2 - 1; i >= 0; i--) 
                max(arr, n, i); 

            for (int i=n-1; i>=0; i--){ 
                int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            max(arr, i, 0); 
        } 
    }
        void max(int arr[], int n, int i){ 
        int largest = i;  
        int k = 2 * i + 1;  
        int z = 2 * i + 2; 
        if (k < n && arr[k] > arr[largest]) 
            largest = k; 
  
        if (z < n && arr[z] > arr[largest]) 
            largest = z; 
  
        if (largest != i){ 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 

            max(arr, n, largest); 
        } 
    } 
}
