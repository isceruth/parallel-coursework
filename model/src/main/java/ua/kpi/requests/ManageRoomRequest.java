package ua.kpi.requests;

import ua.kpi.common.AccountData;

import java.io.Serializable;

public class ManageRoomRequest implements Serializable {
    private AccountData accountData;
    private int roomId;

    public ManageRoomRequest(AccountData accountData, int roomId) {
        this.accountData = accountData;
        this.roomId = roomId;
    }

    public AccountData getAccountData() {
        return accountData;
    }

    public void setAccountData(AccountData accountData) {
        this.accountData = accountData;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "ManageRoomRequest{" +
                "accountData=" + accountData +
                ", roomId=" + roomId +
                '}';
    }
}
