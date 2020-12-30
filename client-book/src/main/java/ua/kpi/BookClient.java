package ua.kpi;

import ua.kpi.requests.ManageRoomRequest;
import ua.kpi.requests.GetRoomsRequest;
import ua.kpi.requests.NewUserRequest;
import ua.kpi.responses.NewUserResponse;
import ua.kpi.services.BookRoomService;
import ua.kpi.services.GetRoomsService;
import ua.kpi.services.NewUserService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class BookClient {
    public static final String NEW_USER_SERVICE_NAME = "NewUserService";
    public static final String GET_ROOMS_SERVICE_NAME = "GetRoomsService";
    public static final String BOOK_ROOM_SERVICE_NAME = "BookRoomService";

    public static NewUserService newUserService;
    public static GetRoomsService getRoomsService;
    public static BookRoomService bookRoomService;

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Scanner scanner = new Scanner(System.in);
        registerServices();

        NewUserRequest request = registerOnServer(scanner);
        NewUserResponse response = newUserService.registerNewUser(request);

        System.out.println("[CLIENT] - Successfully logged in to system as: " + request.getFirstName() + " "
                + request.getLastName());

        while (true) {
            System.out.println("[CLIENT] - Type 'r' if you want to see available rooms " +
                    "and 'b' if you need to book a room!");
            String command = scanner.nextLine();

            switch (command) {
                case "r":
                    System.out.println(getRoomsService
                            .getAvailableRooms(new GetRoomsRequest(response.getAccountData())));
                    break;
                case "b":
                    int roomNum = scanner.nextInt();
                    System.out.println(bookRoomService
                            .bookRoom(new ManageRoomRequest(response.getAccountData(), roomNum)));
                    break;
                default:
                    System.out.println("[CLIENT] - Unknown command, please try again!");
            }
        }
    }

    private static NewUserRequest registerOnServer(Scanner scanner) {
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        return new NewUserRequest(firstName, lastName);
    }

    private static void registerServices() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(1099);
        newUserService = (NewUserService) registry.lookup(NEW_USER_SERVICE_NAME);
        getRoomsService = (GetRoomsService) registry.lookup(GET_ROOMS_SERVICE_NAME);
        bookRoomService = (BookRoomService) registry.lookup(BOOK_ROOM_SERVICE_NAME);
    }
}
