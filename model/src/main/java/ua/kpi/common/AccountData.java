package ua.kpi.common;

import java.io.Serializable;
import java.util.UUID;

public class AccountData implements Serializable {
    private String firstName;
    private String lastName;
    private UUID uuid;

    public AccountData(String firstName, String lastName, UUID uuid) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "AccountData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", uuid=" + uuid +
                '}';
    }
}
