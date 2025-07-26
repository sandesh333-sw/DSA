import java.util.ArrayList;
public class Introduction {
    public static void main(String[] args){

        //Creating an arraylist
        ArrayList<Integer> list = new ArrayList<>();

        //Adding elements
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        System.out.println(list);

        //getting elements
        // System.out.println(list.get(1));

        //removing elements
        // list.remove(1);
        // System.out.println(list);

        // boolean pr = list.contains(1);
        // System.out.println(pr);

        //printing list in reverse
        for(int i=list.size()-1; i>=0; i--){
            System.out.println(list.get(i)+  "");
        }
    }
}