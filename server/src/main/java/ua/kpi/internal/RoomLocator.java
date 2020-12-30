package ua.kpi.internal;

import ua.kpi.common.AccountData;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class RoomLocator {
    private final Map<Integer, AccountData> rooms = new HashMap<>();

    public void init() {
        IntStream.range(1, 11).forEach(num -> rooms.put(num, null));
    }

    public String bookRoom(int roomId, AccountData accountData) {
        if (!rooms.containsKey(roomId)) return RoomOperationStatus.ERROR.getMessage();
        if (rooms.containsKey(roomId) && rooms.get(roomId) != null) return RoomOperationStatus.BOOK_FAIL.getMessage();

        rooms.put(roomId, accountData);
        return RoomOperationStatus.BOOK_SUCCESS.getMessage();
    }

    public String evictRoom(int roomId) {
        if (!rooms.containsKey(roomId)) return RoomOperationStatus.ERROR.getMessage();
        if (rooms.containsKey(roomId) && rooms.get(roomId) == null) return RoomOperationStatus.EVICT_FAIL.getMessage();

        rooms.replace(roomId, null);
        return RoomOperationStatus.EVICT_SUCCESS.getMessage();
    }

    public Map<Integer, AccountData> getRooms() {
        return rooms;
    }

    public int[] getAvailableRooms() {
        return rooms.entrySet().stream()
                .filter(entry -> entry.getValue() == null)
                .map(Map.Entry::getKey)
                .mapToInt(entry -> entry)
                .toArray();
    }

    private enum RoomOperationStatus {
        BOOK_SUCCESS("Successfully booked room"),
        BOOK_FAIL("Couldn't book room"),
        EVICT_SUCCESS("Successfully evicted person from room"),
        EVICT_FAIL("Couldn't evict anyone from room"),
        ERROR("Room with this number does not exist");

        private String message;

        RoomOperationStatus(String message) {
            this.message = message;
        }

        String getMessage() {
            return message;
        }
    }
}
