package ua.kpi.services;

import ua.kpi.requests.NewUserRequest;
import ua.kpi.responses.NewUserResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NewUserService extends Remote {
    String SERVICE_NAME = "NewUserService";

    NewUserResponse registerNewUser(NewUserRequest request) throws RemoteException;
}
