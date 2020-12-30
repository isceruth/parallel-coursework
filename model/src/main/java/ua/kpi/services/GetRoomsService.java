package ua.kpi.services;

import ua.kpi.requests.GetRoomsRequest;
import ua.kpi.responses.GetRoomsResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GetRoomsService extends Remote {
    String SERVICE_NAME = "GetRoomsService";

    GetRoomsResponse getAvailableRooms(GetRoomsRequest request) throws RemoteException;
}
