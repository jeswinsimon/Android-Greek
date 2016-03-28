package com.jeswinsimon.greek;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeswinsimon on 28/03/16.
 */
public class AlphabetParser {

    private static final String ns = null;

    public ArrayList<Alphabet> getAlphabets(InputStream inputStream) {
        ArrayList<Alphabet> alphabets = new ArrayList<Alphabet>();

        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(inputStream, null);

            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                String name = parser.getName();

                if (event == XmlPullParser.START_TAG) {
                    if(name.equals("alphabet")) {
                        //TODO:Move to separate method
                        String alphabetName = parser.getAttributeValue(null, "name") == null ? "Undef" : parser.getAttributeValue(null, "name");
                        String uppercase = parser.getAttributeValue(null, "uppercase") == null ? "Undef" : parser.getAttributeValue(null, "uppercase");
                        String lowercase = parser.getAttributeValue(null, "lowercase") == null ? "Undef" : parser.getAttributeValue(null, "lowercase");
                        //TODO:Safely fetch Description. .nextText() fails and crashes.
                        Alphabet alphabet = new Alphabet(alphabetName, uppercase, lowercase, "No Description Available!");
                        alphabets.add(alphabet);
                    }
                }

                event = parser.next();
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alphabets;
    }
}
