package ua.kpi.requests;

import ua.kpi.common.AccountData;

import java.io.Serializable;

public class GetRoomsRequest implements Serializable {
    private AccountData accountData;

    public GetRoomsRequest(AccountData accountData) {
        this.accountData = accountData;
    }

    public AccountData getAccountData() {
        return accountData;
    }

    public void setAccountData(AccountData accountData) {
        this.accountData = accountData;
    }

    @Override
    public String toString() {
        return "GetRoomsRequest{" +
                "accountData=" + accountData +
                '}';
    }
}
