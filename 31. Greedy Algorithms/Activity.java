import java.util.ArrayList;

public class Activity {
    public static void main(String args[]){
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};

        //end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for(int i=1; i<end.length; i++){
            if(start[i] >= lastEnd){
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("max activities" + maxAct);
        for(int i=0; i<ans.size(); i++){
            System.out.println("A "+ ans.get(i));
        }
    }
}


//* if Not sorted  *//



// import java.util.*;

// public class Activity {
//     public static void main(String args[]) {
//         int[] start = {1, 3, 0, 5, 8, 5};
//         int[] end =   {2, 4, 6, 7, 9, 9};

//         // Create a list of activity objects
//         int n = start.length;
//         ActivityPair[] activities = new ActivityPair[n];
//         for (int i = 0; i < n; i++) {
//             activities[i] = new ActivityPair(start[i], end[i], i);
//         }

//         // Sort activities by end time
//         Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

//         ArrayList<Integer> ans = new ArrayList<>();
//         int maxAct = 1;
//         ans.add(activities[0].index);  // Track original index
//         int lastEnd = activities[0].end;

//         for (int i = 1; i < n; i++) {
//             if (activities[i].start >= lastEnd) {
//                 maxAct++;
//                 ans.add(activities[i].index);
//                 lastEnd = activities[i].end;
//             }
//         }

//         System.out.println("Max activities: " + maxAct);
//         for (int i : ans) {
//             System.out.println("A " + i);
//         }
//     }
// }

// class ActivityPair {
//     int start, end, index;

//     ActivityPair(int start, int end, int index) {
//         this.start = start;
//         this.end = end;
//         this.index = index;
//     }
// }


