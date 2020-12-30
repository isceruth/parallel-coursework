package ua.kpi.services;

import ua.kpi.common.Action;
import ua.kpi.internal.MessageSender;
import ua.kpi.internal.RoomLocator;
import ua.kpi.common.ServerAction;
import ua.kpi.requests.GetRoomsRequest;
import ua.kpi.responses.GetRoomsReportResponse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class GetRoomsReportServiceImpl extends UnicastRemoteObject implements GetRoomsReportService {
    private RoomLocator roomLocator;
    private MessageSender messageSender;

    public GetRoomsReportServiceImpl(RoomLocator roomLocator, MessageSender messageSender) throws RemoteException {
        super();
        this.roomLocator = roomLocator;
        this.messageSender = messageSender;
    }

    @Override
    public GetRoomsReportResponse getRoomsReport(GetRoomsRequest request) {
        messageSender.sendMessage(buildServerAction(request));
        return new GetRoomsReportResponse(roomLocator.getRooms());
    }

    private ServerAction buildServerAction(GetRoomsRequest request) {
        return new ServerAction(request.getAccountData().getUuid(),
                request.getAccountData().getFirstName(), request.getAccountData().getLastName(),
                LocalDateTime.now(), Action.ROOM_REPORT_GET);
    }
}
