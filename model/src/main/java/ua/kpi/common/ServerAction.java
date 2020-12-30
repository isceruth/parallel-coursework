package ua.kpi.common;

import ua.kpi.common.Action;

import java.time.LocalDateTime;
import java.util.UUID;

public class ServerAction {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private LocalDateTime time;
    private Action action;

    public ServerAction() {}

    public ServerAction(UUID uuid, String firstName, String lastName, LocalDateTime time, Action action) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.time = time;
        this.action = action;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "ServerAction{" +
                "uuid=" + uuid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", time=" + time +
                ", action=" + action +
                '}';
    }
}
