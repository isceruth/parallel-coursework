package ua.kpi.responses;

import ua.kpi.common.AccountData;

import java.io.Serializable;
import java.util.UUID;

public class NewUserResponse implements Serializable {
    private AccountData accountData;

    public NewUserResponse(AccountData accountData) {
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
        return "NewUserResponse{" +
                "accountData=" + accountData +
                '}';
    }
}
