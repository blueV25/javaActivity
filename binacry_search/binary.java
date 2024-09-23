package binacry_search;

public class binary {


    int[] data = {1,2,3,4,5,6,7,8,9,10};

    int min = 0;
    int max = (data.length) -1 ;

    int target = 9;

public void search(){
   
    while (min <= max){
      int  mid = (min + max) / 2;

      if(target == data[mid]){
       System.out.println("target found at index: " + mid + "  Target Number: " + target );
        return;
      }else if(data[mid] < target){
        min = mid + 1;

      }else{
        max = mid - 1;
      }
       

    }
    
    System.out.println("target not found");


}
    public static void main(String[] args) {
       binary b = new binary();

       b.search();
    

    }







}




















