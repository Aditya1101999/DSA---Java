package DSAinJava.Heaps;
import java.util.*;
public class MeetingRoomsIII {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->(a[0]-b[0]));
        int[] roomsUsed=new int[n];
        //long[] lastAvailable=new long[n];
        PriorityQueue<Integer>unusedRooms=new PriorityQueue<>();
        //duration,room
        PriorityQueue<int[]>usedRooms=new PriorityQueue<>((a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);

        for(int room=0;room<n;room++){
            unusedRooms.add(room);
        }
        for(int[] meet : meetings){
            int start=meet[0];
            int end=meet[1];

            int duration=end-start;
            while(!usedRooms.isEmpty() && usedRooms.peek()[0]<=start){
                int room=usedRooms.poll()[1];
                unusedRooms.add(room);
            }
            if(!unusedRooms.isEmpty()){
                int room=unusedRooms.poll();
                usedRooms.add(new int[]{end,room});
                roomsUsed[room]++;
            }
            else{
                int room=usedRooms.peek()[1];
                int endTime=usedRooms.poll()[0];
                usedRooms.add(new int[]{endTime+duration,room});
                roomsUsed[room]++;
            }
//             boolean roomFound=false;

//             long availableTime=Long.MAX_VALUE;
//             int availableRoom=0;

//             for(int room=0;room<n;room++){
//                 if(lastAvailable[room]<=start){
//                     roomFound=true;
//                     lastAvailable[room]=end;
//                     roomsUsed[room]++;
//                     break;
//                 }
//                 if(lastAvailable[room]<availableTime){
//                     availableRoom=room;
//                     availableTime=lastAvailable[room];
//                 }
//             }
//             if(!roomFound){
//                 lastAvailable[availableRoom]+=duration;
//                 roomsUsed[availableRoom]++;
//             }

        }
        int result=-1;
        int max=0;
        for(int room=0;room<n;room++){
            if(roomsUsed[room]>max){
                max=roomsUsed[room];
                result=room;
            }
        }
        return result;
    }
}
