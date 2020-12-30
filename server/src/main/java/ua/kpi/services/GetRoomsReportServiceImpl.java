package ua.kpi.services;

import ua.kpi.internal.RoomLocator;
import ua.kpi.requests.GetRoomsRequest;
import ua.kpi.responses.GetRoomsReportResponse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GetRoomsReportServiceImpl extends UnicastRemoteObject implements GetRoomsReportService {
    private RoomLocator roomLocator;

    public GetRoomsReportServiceImpl(RoomLocator roomLocator) throws RemoteException {
        super();
        this.roomLocator = roomLocator;
    }

    @Override
    public GetRoomsReportResponse getRoomsReport(GetRoomsRequest request) throws RemoteException {
        return new GetRoomsReportResponse(roomLocator.getRooms());
    }
}
