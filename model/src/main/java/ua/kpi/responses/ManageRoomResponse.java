package ua.kpi.responses;

import java.io.Serializable;

public class ManageRoomResponse implements Serializable {
    private String message;

    public ManageRoomResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
