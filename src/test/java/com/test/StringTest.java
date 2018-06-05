package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(MockitoJUnitRunner.class)
public class StringTest {

    @Test
    public void parseString() {
        String text = "[{redirectCount=0, encodedBodySize=8236, unloadEventEnd=0, responseEnd=1663.5350000000003, domainLookupEnd=0, unloadEventStart=0, domContentLoadedEventStart=12663.42, type=navigate, decodedBodySize=42198, duration=12802.655, redirectStart=0, connectEnd=0, toJSON={}, requestStart=0, startTime=0, fetchStart=1100.665, domContentLoadedEventEnd=12711.595000000001, entryType=navigation, workerStart=0, responseStart=0, domInteractive=12663.365, domComplete=12784.705, domainLookupStart=0, redirectEnd=0, transferSize=9150, connectStart=0, loadEventStart=12784.730000000001, secureConnectionStart=0, name=https://giris.turkiye.gov.tr/Giris/Banka-Giris-Kontrol, initiatorType=navigation, loadEventEnd=12802.655}, {encodedBodySize=0, entryType=resource, responseEnd=1909.5750000000003, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=234.625, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/css/base.1.21.css, startTime=1674.9500000000003, fetchStart=1674.9500000000003, initiatorType=link}, {encodedBodySize=0, entryType=resource, responseEnd=1753.905, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=78.77499999999964, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/js/header.1.21.js, startTime=1675.1300000000003, fetchStart=1675.1300000000003, initiatorType=script}, {encodedBodySize=0, entryType=resource, responseEnd=1747.3900000000003, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=72.1550000000002, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/ankara/js/t.1.21.js, startTime=1675.2350000000001, fetchStart=1675.2350000000001, initiatorType=script}, {encodedBodySize=0, entryType=resource, responseEnd=2277.0950000000003, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=601.77, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/js/common.1.21.js, startTime=1675.3250000000003, fetchStart=1675.3250000000003, initiatorType=script}, {encodedBodySize=0, entryType=resource, responseEnd=2014.04, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=338.6249999999998, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/css/homepage.1.21.css, startTime=1675.4150000000002, fetchStart=1675.4150000000002, initiatorType=link}, {encodedBodySize=0, entryType=resource, responseEnd=2672.1100000000006, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=996.5000000000005, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/printhead.png, startTime=1675.6100000000001, fetchStart=1675.6100000000001, initiatorType=img}, {encodedBodySize=0, entryType=resource, responseEnd=2619.925, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=944.1300000000001, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/placeholder.png, startTime=1675.795, fetchStart=1675.795, initiatorType=img}, {encodedBodySize=0, entryType=resource, responseEnd=2864.4700000000003, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=1188.4, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/footer/basbakanlik.png, startTime=1676.0700000000002, fetchStart=1676.0700000000002, initiatorType=img}, {encodedBodySize=0, entryType=resource, responseEnd=2785.675, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=1109.515, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/footer/ulastirma.png, startTime=1676.16, fetchStart=1676.16, initiatorType=img}, {encodedBodySize=0, entryType=resource, responseEnd=2749.6400000000003, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=1073.4, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/footer/hgm.png, startTime=1676.2400000000002, fetchStart=1676.2400000000002, initiatorType=img}, {encodedBodySize=0, entryType=resource, responseEnd=2829.0050000000006, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=1152.6850000000006, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/footer/turksat.png, startTime=1676.32, fetchStart=1676.32, initiatorType=img}, {encodedBodySize=0, entryType=resource, responseEnd=2233.9900000000002, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=557.585, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/js/forms.1.21.js, startTime=1676.4050000000002, fetchStart=1676.4050000000002, initiatorType=script}, {encodedBodySize=0, entryType=resource, responseEnd=1923.69, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=0, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/fonts/opensans-light-webfont.2038.woff, startTime=1923.69, fetchStart=1923.69, initiatorType=css}, {encodedBodySize=0, entryType=resource, responseEnd=1924.055, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=0, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/fonts/opensans-regular-webfont.2038.woff, startTime=1924.055, fetchStart=1924.055, initiatorType=css}, {encodedBodySize=0, entryType=resource, responseEnd=1924.3500000000001, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=0, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/fonts/opensans-bold-webfont.2038.woff, startTime=1924.3500000000001, fetchStart=1924.3500000000001, initiatorType=css}, {encodedBodySize=0, entryType=resource, responseEnd=2806.61, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=428.5899999999997, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/ekapilogo.2038.svg, startTime=2378.0200000000004, fetchStart=2378.0200000000004, initiatorType=css}, {encodedBodySize=0, entryType=resource, responseEnd=2450.105, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=71.79499999999962, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/fonts/fontello.2038.woff2, startTime=2378.3100000000004, fetchStart=2378.3100000000004, initiatorType=css}, {encodedBodySize=0, entryType=resource, responseEnd=2669.2650000000003, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=290.2650000000003, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/search.2038.svg, startTime=2379, fetchStart=2379, initiatorType=css}, {encodedBodySize=0, entryType=resource, responseEnd=2606.07, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=226.66999999999962, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/fonts/edk.2038.woff, startTime=2379.4000000000005, fetchStart=2379.4000000000005, initiatorType=css}, {encodedBodySize=0, entryType=resource, responseEnd=3278.905, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=898.7849999999999, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/ankara/images/banners/f065.jpg?v=1.11, startTime=2380.1200000000003, fetchStart=2380.1200000000003, initiatorType=css}, {encodedBodySize=0, entryType=resource, responseEnd=3199.8400000000006, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=816.9100000000008, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/banners/t002.2038.svg, startTime=2382.93, fetchStart=2382.93, initiatorType=css}, {encodedBodySize=0, entryType=resource, responseEnd=2880.9900000000002, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=496.4749999999999, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/helpbuoy.2038.svg, startTime=2384.5150000000003, fetchStart=2384.5150000000003, initiatorType=css}, {duration=0, entryType=paint, toJSON={}, name=first-paint, startTime=2445.4500000000003}, {duration=0, entryType=paint, toJSON={}, name=first-contentful-paint, startTime=2445.4800000000005}, {encodedBodySize=6811, entryType=resource, responseEnd=2678.8100000000004, workerStart=0, responseStart=2677.1900000000005, domainLookupEnd=2601.465, domainLookupStart=2601.465, redirectEnd=0, decodedBodySize=6811, duration=77.34500000000025, transferSize=6811, redirectStart=0, connectEnd=2601.465, toJSON={}, connectStart=2601.465, requestStart=2601.7200000000003, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/yas.png, startTime=2601.465, fetchStart=2601.465, initiatorType=img}, {encodedBodySize=0, entryType=resource, responseEnd=12692.755000000001, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=0, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/bb-ubak-tsat-black.png, startTime=12692.755000000001, fetchStart=12692.755000000001, initiatorType=img}, {encodedBodySize=0, entryType=resource, responseEnd=12783.275000000001, workerStart=0, responseStart=0, domainLookupEnd=0, domainLookupStart=0, redirectEnd=0, decodedBodySize=0, duration=77.22000000000116, transferSize=0, redirectStart=0, connectEnd=0, toJSON={}, connectStart=0, requestStart=0, secureConnectionStart=0, name=https://static.turkiye.gov.tr/themes/izmir/images/form-progress.2038.svg, startTime=12706.055, fetchStart=12706.055, initiatorType=css}]";
        text = text.replace(" ", "");
        String urlRegex = "(http|ftp|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(text);
        List<String> matchedUrls = new LinkedList<>();
        while (matcher.find()) {
            matchedUrls.add(matcher.group());
        }
        text = matcher.replaceAll("URL_REGEX");

        String[] parse = text.split(",|=");
        List<String> list = new LinkedList<>();
        for (String s : parse) {
            boolean sp = false;
            boolean kp = false;
            for (char c : s.toCharArray()) {

                if (c == '{') {
                    s = s.replace("{", "");
                    list.add("{");
                } else if (c == '[') {
                    s = s.replace("[", "");
                    list.add("[");
                } else if (c == ']') {
                    s = s.replace("]", "");
                    kp = true;
                } else if (c == '}') {
                    s = s.replace("}", "");
                    sp = true;
                }
            }
            if (!s.equals("")) {
                list.add(s);
            }
            if (sp) {
                list.add("}");
            }
            if (kp) {
                list.add("]");
            }
        }
        int counter = 0;
        List<String> sb = new LinkedList<>();
        for (String s : list) {
            if (s.equals("{")) {
                String last = ((LinkedList<String>) sb).getLast();
                if (last.equals("}")) {
                    sb.add(",");
                    //sb.add("\n");
                }

                sb.add(s);
                counter = 0;
            } else if (s.equals("[")) {
                sb.add(s);
                //sb.add("\n");
                counter = 0;
            } else if (s.equals("]")) {
                sb.add(s);
                //sb.add("\n");
                counter = 0;
            } else if (s.equals("}")) {
                String last = ((LinkedList<String>) sb).getLast();
                if (last.equals(",")) {
                    ((LinkedList<String>) sb).removeLast();
                    sb.add(s);
                    counter = 0;
                } else if (last.equals("{")) {
                    sb.add(s);
                    counter = 0;
                    sb.add(",");
                }
            } else {
                sb.add("\"");
                sb.add(s);
                sb.add("\"");
                if (counter == 1) {
                    sb.add(",");
                    counter = 0;

                } else {
                    if (counter == 0) {
                        counter++;
                        sb.add(":");
                    }
                }
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        counter = 0;
        for (String s : sb) {
            if ("URL_REGEX".equals(s)) {
                stringBuilder.append(matchedUrls.get(counter++));
            } else {
                stringBuilder.append(s);
            }
        }

        System.out.println(stringBuilder.toString());
    }

    @Test
    public void jsonTest() {

    }
}
