class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans = -1;

        // months of alice and bob
        int aliceStartMonth = Integer.parseInt(arriveAlice.substring(0,2));
        int aliceEndMonth = Integer.parseInt(leaveAlice.substring(0,2));
        int bobStartMonth = Integer.parseInt(arriveBob.substring(0,2));
        int bobLeaveMonth = Integer.parseInt(leaveBob.substring(0,2));

        // days of alice and bob
        int aliceStartDate = Integer.parseInt(arriveAlice.substring(3,5));
        int aliceEndDate = Integer.parseInt(leaveAlice.substring(3,5));
        int bobStartDate = Integer.parseInt(arriveBob.substring(3,5));
        int bobLeaveDate = Integer.parseInt(leaveBob.substring(3,5));

        // converting into single integer (no. of days)
        int aliceStartDay = aliceStartDate;
        for(int i=0; i<aliceStartMonth-1; i++) {
            aliceStartDay += months[i];
        }
        int aliceEndDay = aliceEndDate;
        for(int i=0; i<aliceEndMonth-1; i++) {
            aliceEndDay += months[i];
        }
        int bobStartDay = bobStartDate;
        for(int i=0; i<bobStartMonth-1; i++) {
            bobStartDay += months[i];
        }
        int bobEndDay = bobLeaveDate;
        for(int i=0; i<bobLeaveMonth-1; i++) {
            bobEndDay += months[i];
        }

        int commonStart = Math.max(aliceStartDay, bobStartDay);
        int commonEnd = Math.min(aliceEndDay, bobEndDay);

        ans = Math.max(0, commonEnd - commonStart + 1);

        return ans;
    }
}