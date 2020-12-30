package ua.kpi.services;

import ua.kpi.common.AccountData;
import ua.kpi.requests.NewUserRequest;
import ua.kpi.responses.NewUserResponse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;

public class NewUserServiceImpl extends UnicastRemoteObject implements NewUserService {

    public NewUserServiceImpl() throws RemoteException {
        super();
    }

    public NewUserResponse registerNewUser(NewUserRequest request) {
        AccountData accountData = new AccountData(request.getFirstName(), request.getLastName(), generateRandomUuid());
        NewUserResponse response =
                new NewUserResponse(accountData);

        System.out.println("[SERVER] - [USER SERVICE] - Registered new user " + accountData.getFirstName()
                + " " + accountData.getLastName() + " with UUID: " + accountData.getUuid());

        return response;
    }

    private UUID generateRandomUuid() {
        return UUID.randomUUID();
    }
}
