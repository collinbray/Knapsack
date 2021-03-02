//Solves Knapsack problem, recursively
//input requires a list of numbers separated by single spaces... the first number is the target,
//the numbers following the first are the weights

 import java.util.*;
 
 public class Main{
   public static void main(String[] args){
      KnapSack weights = new KnapSack();//creating ArrayLists for weights
      KnapSack knapSackBag = new KnapSack(); //creating ArrayLists for KnapSackBag
      
      //User input
      Scanner input = new Scanner(System.in);
      System.out.println("Enter input: ");
      String nums = input.nextLine();
      String[] in = nums.trim().split("\\s+");
      
      //Stores input
      for(int i = 1; i < in.length; i++){
         weights.add(Integer.parseInt(in[i]));
         }
         
      //setting the first input as the target
      int target = Integer.parseInt(in[0]);
      
      //placing items in sack
      KnapSack_F(target, knapSackBag,weights);
   }
   
   //clears and fills bag
   public static void KnapSack_F(int maxWeight,KnapSack bag,KnapSack weights){
      bag.clear();
      knapSackRecursive(maxWeight, 0, weights, bag);
   }
   public static void knapSackRecursive(int maxWeight,int n, KnapSack weights, KnapSack knapSackBag){
      if(n == weights.size()){
         if(maxWeight == 0){
            System.out.println("Solution: ");
            for(int i = 0; i < knapSackBag.size(); i++){
               System.out.print(knapSackBag.getWeight(i) + " ");
            }
            System.out.println("");
          }
          return;
       }
       //Adding items
       knapSackBag.add(weights.getWeight(n));
       knapSackRecursive(maxWeight - weights.getWeight(n), n+1, weights, knapSackBag);
       knapSackBag.remove(knapSackBag.size()-1);
       knapSackRecursive(maxWeight,n+1, weights, knapSackBag);
   }
  }
class KnapSack extends ArrayList{
   public int getWeight(int num){
      int W = -1;
      if(num <size()){
          Integer weight = (Integer) get(num);
          W = weight.intValue();
      }
      return W;
   }
 }


      
