package ua.kpi.services;

import ua.kpi.common.Action;
import ua.kpi.internal.MessageSender;
import ua.kpi.internal.RoomLocator;
import ua.kpi.common.ServerAction;
import ua.kpi.requests.ManageRoomRequest;
import ua.kpi.responses.ManageRoomResponse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class BookRoomServiceImpl extends UnicastRemoteObject implements BookRoomService {
    private RoomLocator roomLocator;
    private MessageSender messageSender;

    public BookRoomServiceImpl(RoomLocator roomLocator, MessageSender messageSender) throws RemoteException {
        super();
        this.roomLocator = roomLocator;
        this.messageSender = messageSender;
    }

    @Override
    public ManageRoomResponse bookRoom(ManageRoomRequest request) {
        messageSender.sendMessage(buildServerAction(request));
        System.out.println("[SERVER] - [ROOM SERVICE] - User " + request.getAccountData().getUuid()
                + " booked room " + request.getRoomId());
        return new ManageRoomResponse(roomLocator.bookRoom(request.getRoomId(), request.getAccountData()));
    }

    private ServerAction buildServerAction(ManageRoomRequest request) {
        return new ServerAction(request.getAccountData().getUuid(),
                request.getAccountData().getFirstName(), request.getAccountData().getLastName(),
                LocalDateTime.now(), Action.ROOM_BOOK);
    }
}
