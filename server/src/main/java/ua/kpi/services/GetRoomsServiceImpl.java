package ua.kpi.services;

import ua.kpi.common.Action;
import ua.kpi.internal.MessageSender;
import ua.kpi.internal.RoomLocator;
import ua.kpi.common.ServerAction;
import ua.kpi.requests.GetRoomsRequest;
import ua.kpi.responses.GetRoomsResponse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class GetRoomsServiceImpl extends UnicastRemoteObject implements GetRoomsService {
    private RoomLocator roomLocator;
    private MessageSender messageSender;

    public GetRoomsServiceImpl(RoomLocator roomLocator, MessageSender messageSender) throws RemoteException {
        super();
        this.roomLocator = roomLocator;
        this.messageSender = messageSender;
    }

    @Override
    public GetRoomsResponse getAvailableRooms(GetRoomsRequest request) {
        messageSender.sendMessage(buildServerAction(request));
        System.out.println("[SERVER] - [ROOM SERVICE] - User " + request.getAccountData().getUuid()
                + " requested available rooms");
        return new GetRoomsResponse(roomLocator.getAvailableRooms());
    }

    private ServerAction buildServerAction(GetRoomsRequest request) {
        return new ServerAction(request.getAccountData().getUuid(),
                request.getAccountData().getFirstName(), request.getAccountData().getLastName(),
                LocalDateTime.now(), Action.ROOM_GET);
    }
}
