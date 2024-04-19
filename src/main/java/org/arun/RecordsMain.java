package org.arun;


import lombok.Builder;

public class RecordsMain {
    public static void main(String[] args) {
        // Welcome to TechAugust - Today we are going to see
        // 3 different ways to build Records and when to choose what
        // records are java's native way to create immutable data containers (or objects)

        // 1st way of creating record - use its constructor
        var person = new Person(
                "Arun",
                39,
                "Arun Kumar",

                "Meenakshi Sundaram",
                "arun@arun.com",
                "123123123123",
                "India",
                "Father",
                "Mother"
        );
        //System.out.println(person);

        //2nd way of creating record - use builder class

        var person2 = new Person.Builder()
                .setName("John")
                .setAge(35)
                .setFirstName("John")
                .setLastName("Last Name")
                .setAddress("some address")
                .setEmailId("john@john.com")
                .setPhoneNumber("sfdsdfsdf")
                .setFatherName("John's father")
                .setMotherName("John's mother")

                .build();

        //System.out.println(person2);

        // 3rd way of creating record - using Lombok

        var person3 = Person1.builder()
                .name("Ajith").age(44).firstName("Ajit").lastName("lsat name")
                .emailId("ajit@ajit.com").phoneNumber("123123123").address("chennai")
                .fatherName("ajit's father").motherName("mother")
                .build();


        System.out.println(person3);


    }


}

//1.18.20
@Builder
record Person1(String name,
              int age,
              String firstName,
              String lastName,
              String emailId,
              String phoneNumber,
              String address,
              String fatherName,
              String motherName

){}

record Person(String name,
              int age,
              String firstName,
              String lastName,
              String emailId,
              String phoneNumber,
              String address,
              String fatherName,
              String motherName

) {

    public static class Builder {
        private String name;
        private int age;
        private String firstName;
        private String lastName;
        private String emailId;
        private String phoneNumber;
        private String address;
        private String fatherName;
        private String motherName;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmailId(String emailId) {
            this.emailId = emailId;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setFatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }

        public Builder setMotherName(String motherName) {
            this.motherName = motherName;
            return this;
        }

        public Person build() {
            return new Person(
                    this.name,
                    this.age,
                    this.firstName,
                    this.lastName,
                    this.emailId,
                    this.phoneNumber,
                    this.address,
                    this.fatherName,
                    this.motherName
            );
        }
    }



}



