package by.nintendo.springsecuritydemo.entity;

public enum Role {
    USER("USER")
    ,ADMIN("ADMIN");

    private String iteam;

    Role(String iteam) {
        this.iteam = iteam;
    }

    public String getIteam() {
        return iteam;
    }

    public void setIteam(String iteam) {
        this.iteam = iteam;
    }
}
