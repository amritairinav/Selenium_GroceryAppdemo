package utility;

import com.github.javafaker.Faker;

public class FakerUtility {

    static Faker faker = new Faker();

    public String createRandomFirstName() {
        return faker.name().firstName();
    }

    public String createRandomLastName() {
        return faker.name().lastName();
    }

    public String createRandomFullName() {
        return faker.name().fullName();
    }

    public String generateAddress() {
        return faker.address().fullAddress();
    }

    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    public String generateUsername() {
        return faker.name().username();
    }

    public String generatePassword() {
        return faker.internet().password();
    }

    public String generatePhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public String generateCity() {
        return faker.address().city();
    }

    public String generateCountry() {
        return faker.address().country();
    }
}