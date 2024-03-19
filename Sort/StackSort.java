import util.SortUtil;

import java.util.Stack;

public class StackSort {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] ints = SortUtil.genRandomArray(10, 10);
        for(int i = 0; i < ints.length; i++)
        {
            stack.push(ints[i]);
        }
        System.out.println(stack);
        System.out.println(stackSort(stack));
    }

    public static Stack<Integer> stackSort(Stack<Integer> input)
    {
       Stack<Integer> temp = new Stack<>();

       while(!input.isEmpty())
       {
           if(temp.isEmpty())
               temp.push(input.pop());
           if(!input.isEmpty())
           {
               int cur = input.pop();
               while(!temp.isEmpty() && cur < temp.peek())
               {
                   input.push(temp.pop());
               }
               temp.push(cur);
           }
       }
       return temp;
    }
}
