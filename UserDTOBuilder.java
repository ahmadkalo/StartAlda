public class UserDTOBuilder {
    private final UserDTO dto;

    public UserDTOBuilder() {
        dto = new UserDTO();
    }

    public UserDTOBuilder withName(String name) {
        dto.setName(name);
        return this;
    }

    public UserDTOBuilder withUserID(String id) {
        dto.setUserID(id);
        return this;
    }

    public UserDTOBuilder withPassword(String pw) {
        dto.setPassword(pw);
        return this;
    }

    public UserDTOBuilder withAddress(String address) {
        dto.setAddress(address);
        return this;
    }

    public UserDTOBuilder withGebDatum(String gebDatum) {
        dto.setGebDatum(gebDatum);
        return this;
    }

    public UserDTO build() {
        return dto;
    }
}
