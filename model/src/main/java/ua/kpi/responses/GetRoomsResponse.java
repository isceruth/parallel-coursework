package ua.kpi.responses;

import java.io.Serializable;
import java.util.Arrays;

public class GetRoomsResponse implements Serializable {
    private int[] roomIds;

    public GetRoomsResponse(int[] roomIds) {
        this.roomIds = roomIds;
    }

    public int[] getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(int[] roomIds) {
        this.roomIds = roomIds;
    }

    @Override
    public String toString() {
        return "GetRoomsResponse{" +
                "roomIds=" + Arrays.toString(roomIds) +
                '}';
    }
}
