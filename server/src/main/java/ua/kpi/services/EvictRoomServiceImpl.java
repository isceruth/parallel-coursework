package ua.kpi.services;

import ua.kpi.internal.RoomLocator;
import ua.kpi.requests.ManageRoomRequest;
import ua.kpi.responses.ManageRoomResponse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EvictRoomServiceImpl extends UnicastRemoteObject implements EvictRoomService {
    private RoomLocator roomLocator;

    public EvictRoomServiceImpl(RoomLocator roomLocator) throws RemoteException {
        super();
        this.roomLocator = roomLocator;
    }

    @Override
    public ManageRoomResponse evictRoom(ManageRoomRequest request) throws RemoteException {
        return new ManageRoomResponse(roomLocator.evictRoom(request.getRoomId()));
    }
}
