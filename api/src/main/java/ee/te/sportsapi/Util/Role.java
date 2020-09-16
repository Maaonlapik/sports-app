package ee.te.sportsapi.Util;

public enum Role {

    USER, ADMIN;

    public String toSpringRole(){
        return "ROLE_" + this.name();
    }

    public boolean isAdmin(){
        return this == ADMIN;
    }

}
