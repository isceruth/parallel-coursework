package ua.kpi;

import ua.kpi.internal.RoomLocator;
import ua.kpi.services.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main( String[] args )
    {
        System.out.println("[SERVER] - Starting server...");

        RoomLocator roomLocator = new RoomLocator();
        roomLocator.init();

        try {
            Registry registry = LocateRegistry.createRegistry(1099);

            NewUserService newUserService = new NewUserServiceImpl();
            GetRoomsService getRoomsService = new GetRoomsServiceImpl(roomLocator);
            BookRoomService bookRoomService = new BookRoomServiceImpl(roomLocator);
            EvictRoomService evictRoomService = new EvictRoomServiceImpl(roomLocator);
            GetRoomsReportService getRoomsReportService = new GetRoomsReportServiceImpl(roomLocator);

            registry.rebind(NewUserService.SERVICE_NAME, newUserService);
            registry.rebind(GetRoomsService.SERVICE_NAME, getRoomsService);
            registry.rebind(BookRoomService.SERVICE_NAME, bookRoomService);
            registry.rebind(EvictRoomService.SERVICE_NAME, evictRoomService);
            registry.rebind(GetRoomsReportService.SERVICE_NAME, getRoomsReportService);

            Thread.sleep(Integer.MAX_VALUE);
        } catch (RemoteException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
