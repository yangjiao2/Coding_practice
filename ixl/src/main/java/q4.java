/**
 * Created by Yang on 2017/5/17.
 */

import java.io.InputStream;
import java.util.HashMap;
import java.util.*;

public class q4 {
    //
    // Generates an HTML select list that can be used to select a specific
    // U.S. state.
    //
    public enum State {
        ALABAMA("Alabama", "AL"), ALASKA("Alaska", "AK"), AMERICAN_SAMOA("American Samoa", "AS"), ARIZONA("Arizona", "AZ"), ARKANSAS(
                "Arkansas", "AR"), CALIFORNIA("California", "CA");
        private String name;
        private String abbreviation;

        State(String name, String abbreviation) {
            this.name = name;
            this.abbreviation = abbreviation;
        }

        public String getName() {
            return this.name;
        }

        public String getAbbreviation() {
            return this.abbreviation;
        }

    }

    public static String createStateSelectList() {
        StringBuilder result = new StringBuilder();

        result.append("<select name=\"state\">\n");
        for (State key: State.values()) {
            result.append("<option value=\""+ key.getName() + "\">" + key.getName() + "</option>\n");
        }
        result.append("</select>\n");
        return result.toString();
    }

    //
    // Parses the state from an HTML form submission, converting it to
    // the two-letter abbreviation.
    //
    public static String parseSelectedState(String s) {
        for(State key : State.values()){
            if( s.equals(key.getName())){
                return key.getAbbreviation();
            }
        }
        return null;
    }

    //
    // Displays the full name of the state specified by the two-letter code.
    //
    public static String displayStateFullName(String abbr) {
        for(State key : State.values()){
            if( abbr.equals(key.getAbbreviation())){
                return key.getName();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(createStateSelectList() );
        System.out.println(displayStateFullName("CA"));
    }
}