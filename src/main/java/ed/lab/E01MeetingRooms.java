package ed.lab;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class E01MeetingRooms {
    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals == null || meetingIntervals.isEmpty()) {
            return 0;
        }

        meetingIntervals.sort(Comparator.comparingInt(MeetingInterval::startTime));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(meetingIntervals.get(0).endTime());

        for (int i = 1; i < meetingIntervals.size(); i++) {
            MeetingInterval current = meetingIntervals.get(i);
            if (current.startTime() >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(current.endTime());
        }

        return minHeap.size();
    }
}