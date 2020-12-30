package ua.kpi;

import ua.kpi.requests.GetRoomsRequest;
import ua.kpi.requests.ManageRoomRequest;
import ua.kpi.requests.NewUserRequest;
import ua.kpi.responses.NewUserResponse;
import ua.kpi.services.EvictRoomService;
import ua.kpi.services.GetRoomsReportService;
import ua.kpi.services.NewUserService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ManageClient {
    public static final String NEW_USER_SERVICE_NAME = "NewUserService";
    public static final String GET_ROOMS_REPORT_SERVICE_NAME = "GetRoomsReportService";
    public static final String EVICT_ROOM_SERVICE_NAME = "EvictRoomService";

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        NewUserRequest request = new NewUserRequest(firstName, lastName);

        Registry registry = LocateRegistry.getRegistry(1099);
        NewUserService newUserService = (NewUserService) registry.lookup(NEW_USER_SERVICE_NAME);
        GetRoomsReportService getRoomsReportService = (GetRoomsReportService) registry.lookup(GET_ROOMS_REPORT_SERVICE_NAME);
        EvictRoomService evictRoomService = (EvictRoomService) registry.lookup(EVICT_ROOM_SERVICE_NAME);

        NewUserResponse response = newUserService.registerNewUser(request);
        System.out.println("Got response: " + response);

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("r")) {
                System.out.println(getRoomsReportService.getRoomsReport(new GetRoomsRequest(response.getAccountData())));
            }

            if (command.equals("e")) {
                int roomNum = scanner.nextInt();
                System.out.println(evictRoomService.evictRoom(new ManageRoomRequest(response.getAccountData(), roomNum)));
            }
        }
    }
}
