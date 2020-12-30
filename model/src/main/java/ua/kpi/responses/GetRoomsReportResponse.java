package ua.kpi.responses;

import ua.kpi.common.AccountData;

import java.io.Serializable;
import java.util.Map;

public class GetRoomsReportResponse implements Serializable {
    private Map<Integer, AccountData> rooms;

    public GetRoomsReportResponse(Map<Integer, AccountData> rooms) {
        this.rooms = rooms;
    }

    public Map<Integer, AccountData> getRooms() {
        return rooms;
    }

    public void setRooms(Map<Integer, AccountData> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "GetRoomsReportResponse{" +
                "rooms=" + rooms +
                '}';
    }
}
