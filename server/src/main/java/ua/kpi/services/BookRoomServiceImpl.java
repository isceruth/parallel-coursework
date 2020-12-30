package ua.kpi.services;

import ua.kpi.internal.RoomLocator;
import ua.kpi.requests.ManageRoomRequest;
import ua.kpi.responses.ManageRoomResponse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BookRoomServiceImpl extends UnicastRemoteObject implements BookRoomService {
    private RoomLocator roomLocator;

    public BookRoomServiceImpl(RoomLocator roomLocator) throws RemoteException {
        super();
        this.roomLocator = roomLocator;
    }

    @Override
    public ManageRoomResponse bookRoom(ManageRoomRequest request) throws RemoteException {
        return new ManageRoomResponse(roomLocator.bookRoom(request.getRoomId(), request.getAccountData()));
    }
}
