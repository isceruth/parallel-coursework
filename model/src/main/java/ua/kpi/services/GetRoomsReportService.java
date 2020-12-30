package ua.kpi.services;

import ua.kpi.requests.GetRoomsRequest;
import ua.kpi.responses.GetRoomsReportResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GetRoomsReportService extends Remote {
    String SERVICE_NAME = "GetRoomsReportService";

    GetRoomsReportResponse getRoomsReport(GetRoomsRequest request) throws RemoteException;
}
