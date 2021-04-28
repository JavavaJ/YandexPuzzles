package codewars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    https://www.codewars.com/kata/59df2f8f08c6cec835000012/train/java

    John has invited some friends. His list is:

    s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";

    Could you make a program that

    makes this string uppercase
    gives it sorted in alphabetical order by last name.
    When the last names are the same, sort them by first name. Last name and first name of a guest come in the result between parentheses separated by a comma.

    So the result of function meeting(s) will be:

    "(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"

    It can happen that in two distinct families with the same family name two people have the same first name too.


 */
public class MeetingGuests {

    public static String meeting(String s) {
        MeetingGuests handler = new MeetingGuests();
        return handler.handle(s);
    }

    public String handle(String s) {
            return Arrays.stream(s.split(";"))
                .map(guest -> guest.split(":"))
                .map(arr -> new Guest(arr[0].toUpperCase(), arr[1].toUpperCase()))
                .sorted(Guest::compareTo)
                .map(Guest::getFullName)
                .collect(Collectors.joining(""));
    }

    public class Guest implements Comparable<Guest> {

        private String firstName;
        private String lastName;

        public Guest(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
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

        public String getFullName() {
            return String.format("(%s, %s)", lastName, firstName);
        }

        @Override
        public int compareTo(Guest other) {
            int result = 0;
            if (!this.lastName.equals(other.getLastName())) {
                result = this.lastName.compareTo(other.getLastName());
            } else {
                result = this.firstName.compareTo(other.getFirstName());
            }
            return result;
        }

        @Override
        public String toString() {
            return "Guest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
        }
    }
}
