package com.epam.mjc.io;

public class ProfileDataParser {

    private String data;
    private String name = null;
    private String email = null;
    private String phone = null;
    private String age = null;
    public ProfileDataParser(String data) {
        this.data = data;
        this.parseData(data);
    }

    public void parseData(String data) {
        String[] arrayData = data.split(System.lineSeparator());

        for (int i = 0; i < arrayData.length; i++) {
            String[] values = arrayData[i].split(":");
            String key = values[0];
            String value = values[1].trim();

            switch (key) {
                case "Name" -> this.name = value;
                case "Age" -> this.age = value;
                case "Email" -> this.email = value;
                case "Phone" -> this.phone = value;
            }
        }
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return Integer.parseInt(age);
    }
    public Long getPhone() {
        return Long.parseLong(phone);
    }
    public String getEmail() {
        return email;
    }
}
