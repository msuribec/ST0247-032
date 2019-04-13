
import java.util.Stack;

public class TSPGreedy {


    public static void tsp(Digraph g,int start) {

        int numberOfNodes = g.size();
        boolean[] visited = new boolean[numberOfNodes];
        Stack<Integer> stack = new Stack<>();
        visited[start] = true;
        stack.push(start);
        int element, dst = 0;
        boolean minFound = false;
        System.out.print(start + "\t");

        while (!stack.isEmpty()) {
            element = stack.peek();
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < numberOfNodes; i++ ){
                int weight = g.getWeight(element,i);
                if (weight>0 && !visited[i]){
                    if (min > weight){
                        min = weight;
                        dst = i;
                        minFound = true;
                    }
                }
            }
            if (minFound) {
                visited[dst] = true;
                stack.push(dst);
                System.out.print(dst + "\t");
                minFound = false;
                continue;
            }
            stack.pop();
        }
    }
}

