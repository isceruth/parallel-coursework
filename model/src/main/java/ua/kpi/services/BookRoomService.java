package ua.kpi.services;

import ua.kpi.requests.ManageRoomRequest;
import ua.kpi.responses.ManageRoomResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookRoomService extends Remote {
    String SERVICE_NAME = "BookRoomService";

    ManageRoomResponse bookRoom(ManageRoomRequest request) throws RemoteException;
}
