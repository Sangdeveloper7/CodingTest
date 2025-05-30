package 취업준비.저자;

public class 저자_정렬_정렬이완료된두배열합치기 {



    public static void main(String[] args){
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] answer = new int[arr1.length + arr2.length];

        int count = 0;
        int arr1_idx = 0;
        int arr2_idx = 0;
        while(arr1_idx <= arr1.length-1 && arr2_idx <= arr2.length-1 && count < 6){
            if(arr1[arr1_idx] < arr2[arr2_idx])
                answer[count++] = arr1[arr1_idx++];
            else if(arr1[arr1_idx] > arr2[arr2_idx])
                answer[count++] = arr2[arr2_idx++];
        }

        if(arr1_idx <= arr1.length-1){
            while(arr1_idx <= arr1.length-1){
                answer[count++] = arr1[arr1_idx++];
            }
        }

        if(arr2_idx <= arr2.length-1){
            while(arr2_idx <= arr2.length-1){
                answer[count++] = arr2[arr2_idx++];
            }
        }

        for(int i : answer){
            System.out.print(i + " ");
        }
    }
}
