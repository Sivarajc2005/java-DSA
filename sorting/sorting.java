package sorting;

public class sorting{
    public static void main (String[] args){

        int nums[] = new int[5];
        nums[0]=24;
        nums[1]=43;
        nums[2]=2;
        nums[3]=5;
        nums[4]=20;

        // sorting1.insertion_sort(nums);
        quick_sort.split(nums,0,4);
        for (int k = 0 ; k < nums.length ; k++){
            System.out.println(nums[k]);
        }
        System.out.println("nice to meet you");
    }
}

class sorting1 extends  merge_sort{

    public static void selection_sort(int[] arr){
        //minimum element 1st sorted to the begining
        // time complexity O(N)
        int n=arr.length;
        for (int i=0;i<n-1;i++){
            int min = i;
            for (int j=i+1 ; j < n ; j++){
                if(arr[j] < arr[min]){
                    min=j;
                }   
            }
            int tem=arr[i];
                arr[i]=arr[min];
                arr[min]= tem;
            
        }
    }

    public static void bubble_sort(int[] arr){ 
        //maximum number 1st sorted to the end 
        int n = arr.length;
        int i,j,temp;
        boolean swap;
        for (i=0;i<n-1;i++){
            swap = false;   //making it more optimal
            for (j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap = true;
                }
            }
            // with this we not need to check for further after sorting hence in best case we got time complesity of O(n)
            if(!swap) break;
        }
    }

    public static void insertion_sort(int[] arr){

        //each time took the subarray and sort the subarray
        int n,i,j,key;
        n=arr.length; //5
        for (i=1; i<n;i++){
            j=i-1;
            key=arr[i];
            while (j >= 0 && key < arr[j] ){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

}

class merge_sort{
    public static void divide(int[] arr,int low , int high ){
        int mid;
        if(low >= high ) return;
        mid=(low + high )/2;
        divide(arr,low,mid);
        divide(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    private static void merge(int[] arr , int low , int mid ,int high ){
        int down , up , i ;
        down = low;
        up = mid+1;
        i=0;

        int[] temp = new int[high - low + 1];


        while(down <= mid && up <= high){
            if (arr[down] <= arr[up]){
                temp[i]=arr[down];               
                down++;
                i++;
                
            }
            else{
                temp[i]=arr[up];
                up++;
                i++;
            }
        }

        while(down <= mid ){
            temp[i]=arr[down];
            down++;
            i++;
        }

        while ( up <= high){
            temp[i]=arr[up];
            up++;
            i++;
        }

        for ( int j = 0 ; j < temp.length ; j++){
            arr[low+j]=temp[j];
        }
    }
}

class quick_sort{
    public static void split(int[] arr , int low , int high){
        if(low < high) {
        int pivote=partition(arr,low,high);
        split(arr,low,pivote-1);
        split(arr,pivote+1,high);}
    }

    private static int partition(int[] arr , int low , int high){
        int pivote = arr[low];
        int i=low,j=high,temp;
        while(i<j){
            while (arr[i] <= pivote && i<high ){i++; } 
            while(arr[j]>= pivote && j >= low){
                j--; }
            if (i<j){
                temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        temp = arr[low];   // it occur because i is larger than j 
        arr[low]=arr[j];
        arr[j]=temp;
        return j;
    }
}
