package ua.kpi.services;

import ua.kpi.internal.RoomLocator;
import ua.kpi.requests.GetRoomsRequest;
import ua.kpi.responses.GetRoomsResponse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GetRoomsServiceImpl extends UnicastRemoteObject implements GetRoomsService {

    private RoomLocator roomLocator;

    public GetRoomsServiceImpl(RoomLocator roomLocator) throws RemoteException {
        super();
        this.roomLocator = roomLocator;
    }

    @Override
    public GetRoomsResponse getAvailableRooms(GetRoomsRequest request) throws RemoteException {
        return new GetRoomsResponse(roomLocator.getAvailableRooms());
    }
}
