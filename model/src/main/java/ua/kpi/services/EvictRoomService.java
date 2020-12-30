package ua.kpi.services;

import ua.kpi.requests.ManageRoomRequest;
import ua.kpi.responses.ManageRoomResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EvictRoomService extends Remote {
    String SERVICE_NAME = "EvictRoomService";

    ManageRoomResponse evictRoom(ManageRoomRequest request) throws RemoteException;
}
