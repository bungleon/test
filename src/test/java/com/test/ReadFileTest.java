package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

@RunWith(MockitoJUnitRunner.class)
public class ReadFileTest {
    private static final String FILENAME = "/Users/erman/logs/oberonengine.txt";
    private static final String FILENAME2 = "/Users/erman/logs/oberonengine2.txt";
    private static final String F1 = "/Users/erman/logs/engine-2a.txt";
    private static final String F2 = "/Users/erman/logs/engine-2b.txt";
    private static final String F3 = "/Users/erman/logs/engine-3a.txt";
    private static final String F4 = "/Users/erman/logs/engine-3b.txt";
    private static final String F5 = "/Users/erman/logs/engine-4a.txt";

    private static final String F11 = "/Users/erman/logs/engine-2a1.txt";
    private static final String F21 = "/Users/erman/logs/engine-2b1.txt";
    private static final String F31 = "/Users/erman/logs/engine-3a1.txt";
    private static final String F41 = "/Users/erman/logs/engine-3b1.txt";
    private static final String F51 = "/Users/erman/logs/engine-4a1.txt";

    @Test
    public void find() {
        BufferedReader br = null;
        FileReader fr = null;
        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME2));

            String sCurrentLine;
            String before = null;

            int counter = 0;
            while ((sCurrentLine = br.readLine()) != null) {

                if (sCurrentLine.contains("AKBANK LOGIN REQUEST OVER")) {
                    writer.write(before);
                    writer.write("\n");
                    for (int i = 0; i < 7; i++) {
                        writer.write(sCurrentLine);
                        sCurrentLine = br.readLine();
                        writer.write("\n");
                    }
                    writer.write("\n");

                }
                before = sCurrentLine;
            }

            System.out.println("bitti");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

    @Test
    public void separatedTimes() {
        BufferedReader br = null;
        FileReader fr = null;


        BufferedWriter writer;

        String sCurrentLine;
        try {

            fr = new FileReader(FILENAME2);
            br = new BufferedReader(fr);

            BufferedWriter writer1 = new BufferedWriter(new FileWriter(F1));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter(F2));
            BufferedWriter writer3 = new BufferedWriter(new FileWriter(F3));
            BufferedWriter writer4 = new BufferedWriter(new FileWriter(F4));
            BufferedWriter writer5 = new BufferedWriter(new FileWriter(F5));


            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.contains("engine-2a")) {
                    writer = writer1;
                } else if (sCurrentLine.contains("engine-2b")) {
                    writer = writer2;
                } else if (sCurrentLine.contains("engine-3a")) {
                    writer = writer3;
                } else if (sCurrentLine.contains("engine-3b")) {
                    writer = writer4;
                } else if (sCurrentLine.contains("engine-4a")) {
                    writer = writer5;
                } else {
                    writer = null;
                }
                if (writer != null) {

                    for (int i = 0; i < 8; i++) {
                        if (sCurrentLine != null) {
                            writer.write(sCurrentLine);
                        } else {
                            System.out.println("null");
                        }
                        sCurrentLine = br.readLine();
                        writer.write("\n");
                    }
                    writer.write("\n");
                }

            }
            System.out.println("bitti");

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

    @Test
    public void elapsedTimes() {


        String sCurrentLine;
        try {

            BufferedReader reader1 = new BufferedReader(new FileReader(F1));
            BufferedReader reader2 = new BufferedReader(new FileReader(F2));
            BufferedReader reader3 = new BufferedReader(new FileReader(F3));
            BufferedReader reader4 = new BufferedReader(new FileReader(F4));
            BufferedReader reader5 = new BufferedReader(new FileReader(F5));

            BufferedWriter writer1 = new BufferedWriter(new FileWriter(F11));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter(F21));
            BufferedWriter writer3 = new BufferedWriter(new FileWriter(F31));
            BufferedWriter writer4 = new BufferedWriter(new FileWriter(F41));
            BufferedWriter writer5 = new BufferedWriter(new FileWriter(F51));
            while ((sCurrentLine = reader1.readLine()) != null) {
                if (sCurrentLine.contains("oberon-prod")) {
                    writer1.write(sCurrentLine.substring(110, 134));
                    writer1.write("\n");
                } else if (sCurrentLine.contains("elapsedTime")) {
                    writer1.write(sCurrentLine);
                    writer1.write("\n");
                    writer1.write("\n");
                }
            }

            while ((sCurrentLine = reader2.readLine()) != null) {
                if (sCurrentLine.contains("oberon-prod")) {
                    writer2.write(sCurrentLine.substring(110, 134));
                    writer2.write("\n");
                } else if (sCurrentLine.contains("elapsedTime")) {
                    writer2.write(sCurrentLine);
                    writer2.write("\n");
                    writer2.write("\n");
                }
            }

            while ((sCurrentLine = reader3.readLine()) != null) {
                if (sCurrentLine.contains("oberon-prod")) {
                    writer3.write(sCurrentLine.substring(110, 134));
                    writer3.write("\n");
                } else if (sCurrentLine.contains("elapsedTime")) {
                    writer3.write(sCurrentLine);
                    writer3.write("\n");
                    writer3.write("\n");
                }
            }

            while ((sCurrentLine = reader4.readLine()) != null) {
                if (sCurrentLine.contains("oberon-prod")) {
                    writer4.write(sCurrentLine.substring(110, 134));
                    writer4.write("\n");
                } else if (sCurrentLine.contains("elapsedTime")) {
                    writer4.write(sCurrentLine);
                    writer4.write("\n");
                    writer4.write("\n");
                }
            }

            while ((sCurrentLine = reader5.readLine()) != null) {
                if (sCurrentLine.contains("oberon-prod")) {
                    writer5.write(sCurrentLine.substring(110, 134));
                    writer5.write("\n");
                } else if (sCurrentLine.contains("elapsedTime")) {
                    writer5.write(sCurrentLine);
                    writer5.write("\n");
                    writer5.write("\n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void count() {
        System.out.println(365 * 4 * 15);
    }
}
