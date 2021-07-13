package com.line;

import java.util.Scanner;

public class ExtractObject {
    public static void main(String[] args) {
        // write your code here
        final String BEGIN_OBJECT = "[[";
        final String BEGIN_COLLAPSE = "[[[";
        final String END_OBJECT = "]]";
        final String END_COLLAPSE = "]]]";
        final String START = "start";
        final String END = "end";

        Scanner scanner = new Scanner(System.in);

        String collapse = "collapse_0";
        String currentText = "";
        boolean isOpenCurrentCollapseKey = false;

        while (scanner.hasNextLine()) {
            String inputString = scanner.nextLine();
            if (inputString.isEmpty()) {
                break;
            }
            int indexBeginCollapse = inputString.indexOf(BEGIN_COLLAPSE);
            int indexBeginObject = inputString.indexOf(BEGIN_OBJECT);
            int indexEndCollapse = inputString.indexOf(END_COLLAPSE);
            int indexEndObject = inputString.indexOf(END_OBJECT);

            //print text
            if (indexBeginObject >= 0) {
                //exist text before
                String text = inputString.substring(0, indexBeginObject);
                currentText += text;
                processText(collapse, currentText, isOpenCurrentCollapseKey);
                currentText = "";
            } else if (indexEndObject >= 0) {
                String text = inputString.substring(0, indexEndObject);
                currentText += text;
                processText(collapse, currentText, isOpenCurrentCollapseKey);
                currentText = "";
            }
//            process collapse
            if (indexBeginCollapse != -1) {
                //begin collapse
                if (isOpenCurrentCollapseKey) {
                    //previous open collapse and now open continue => increase collap
                    collapse = increaseCollapse(collapse);
                    printOutCollapse(collapse, START);
                } else {
                    //previous close collapse and now open collapse => increase index
                    collapse = increaseIndexOfCollapse(collapse);
                    printOutCollapse(collapse, START);
                }
                isOpenCurrentCollapseKey = true;
            }
            if (indexEndCollapse != -1) {
                if (!isOpenCurrentCollapseKey) {
                    collapse = decreaseCollapse(collapse);
                }
                printOutCollapse(collapse, END);

                isOpenCurrentCollapseKey = false;
            }

            //process object
            if (indexBeginObject > indexBeginCollapse) {
                if (indexEndObject > indexBeginObject) {
                    String object = inputString.substring(indexBeginObject + 2, indexEndObject);
                    processObject(collapse, object, isOpenCurrentCollapseKey);
                }
            }

            //process text
            if (indexBeginObject == -1 && indexEndObject == -1) {
                //input just only text
                currentText += inputString;
            }
        }
        scanner.close();
    }

    public static void printOutText(String collapse, String type, String content) {
        if (collapse.equals("collapse")) {
            System.out.println(type + ": " + content);
        } else
            System.out.println(collapse + ":" + type + ": " + content);
    }

    public static void printOutCollapse(String collapse, String type) {
        System.out.println(collapse + ": " + type);
    }

    public static String increaseCollapse(String collapse) {
        collapse += "_1";
        return collapse;
    }

    public static String decreaseCollapse(String collapse) {
        int lastIndex = collapse.length();
        collapse = collapse.substring(0, lastIndex - 2);
        return collapse;
    }

    public static String increaseIndexOfCollapse(String collapse) {
        int lastIndex = collapse.length() - 1;
        char cIndexCollapse = collapse.charAt(lastIndex);
        int indexCollapse = Integer.parseInt(String.valueOf(cIndexCollapse));
        indexCollapse++;
        collapse = collapse.substring(0, lastIndex) + String.valueOf(indexCollapse);

//        if(indexCollapse == 1) {
//            printOutCollapse(collapse, "start");
//        }
        return collapse;
    }

    public static void processObject(String collapse, String object, boolean isOpenCurrentCollapseKey) {
        int lastIndex = object.length();
        String type = object.substring(0, 5);
        if (!isOpenCurrentCollapseKey) {
            collapse = collapse.substring(0, collapse.length() - 2);
        }
        if (type.equals("media")) {
            String content = object.substring(6, lastIndex);
            printOutText(collapse, "media", content);
        } else if (type.equals("image")) {
            String content = object.substring(6, lastIndex);
            printOutText(collapse, "image", content);
        } else {
            String content = object.substring(5, lastIndex);
            printOutText(collapse, "link", content);
        }
    }

    public static void processText(String collapse, String currentText, boolean isOpenCurrentCollapseKey) {
        currentText = currentText.trim();
        if (!currentText.isEmpty()) {
//            currentText = currentText.trim();
            if (!isOpenCurrentCollapseKey) {
                collapse = collapse.substring(0, collapse.length() - 2);
            }
            printOutText(collapse, "text", currentText);
        }
    }
}
