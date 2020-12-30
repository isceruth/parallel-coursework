package ua.kpi.services;

import ua.kpi.common.AccountData;
import ua.kpi.common.Action;
import ua.kpi.internal.MessageSender;
import ua.kpi.common.ServerAction;
import ua.kpi.requests.NewUserRequest;
import ua.kpi.responses.NewUserResponse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.UUID;

public class NewUserServiceImpl extends UnicastRemoteObject implements NewUserService {
    private MessageSender messageSender;

    public NewUserServiceImpl(MessageSender messageSender) throws RemoteException {
        super();
        this.messageSender = messageSender;
    }

    public NewUserResponse registerNewUser(NewUserRequest request) {
        AccountData accountData = new AccountData(request.getFirstName(), request.getLastName(), generateRandomUuid());
        NewUserResponse response =
                new NewUserResponse(accountData);

        System.out.println("[SERVER] - [USER SERVICE] - Registered new user " + accountData.getFirstName()
                + " " + accountData.getLastName() + " with UUID: " + accountData.getUuid());
        messageSender.sendMessage(buildServerAction(response));

        return response;
    }

    private UUID generateRandomUuid() {
        return UUID.randomUUID();
    }

    private ServerAction buildServerAction(NewUserResponse response) {
        return new ServerAction(response.getAccountData().getUuid(),
                response.getAccountData().getFirstName(), response.getAccountData().getLastName(),
                LocalDateTime.now(), Action.REGISTERED);
    }
}
