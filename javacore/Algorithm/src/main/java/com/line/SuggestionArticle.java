package com.line;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SuggestionArticle {
    public static HashMap<Integer, String> hFriends = new HashMap<>();
    public static HashMap<Integer, String> hFollowUser = new HashMap<>();
    public static HashMap<Integer, String> hFollowFanpage = new HashMap<>();
    public static HashMap<Integer, String> hUserArticle = new HashMap<>();
    public static HashMap<Integer, String> hFanpageArticle = new HashMap<>();

    public static void main(String[] args) {
        final String FRIEND = "friends";
        final String FOLLOW_USER = "follow-user";
        final String FOLLOW_FANPAGE = "follow-fanpage";
        final String FANPAGE_ARTICLE = "fanpage-article";
        final String USER_ARTICLE = "user-article";



        Scanner scanner = new Scanner(System.in);
        String numberStr = scanner.nextLine();
        int n = Integer.parseInt(numberStr);

        for(int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if(line.contains(FRIEND)) {
                processInputFriend(hFriends, line);
            }
            else if(line.contains(FOLLOW_USER)) {
                    processInputObject(hFollowUser, line);
            }
            else if(line.contains(FOLLOW_FANPAGE)) {
                processInputObject(hFollowFanpage, line);
            }
            else if(line.contains(FANPAGE_ARTICLE)) {
                processArticle(hFanpageArticle, line);
            }
            else if(line.contains(USER_ARTICLE)) {
                processArticle(hUserArticle, line);
            }


        }
        String userInfo = scanner.nextLine();

        //process user info level 1
        processLevel1(userInfo);


        scanner.close();
    }

    //vObject id num#num#
    public static void processInputFriend(HashMap<Integer, String> hObject, String value) {
        String[] arrValue = value.split(" ");
        if(arrValue.length == 3) {
            String userIdText = arrValue[1];
            String friendIdText = arrValue[2];
            Integer userId = Integer.parseInt(userIdText);
            Integer friendId = Integer.parseInt(friendIdText);

            if(hObject.containsKey(userId)) {
                String info = hObject.get(userId);
                info += friendIdText + "#";
                hObject.replace(userId, info);
            }
            else{
                String info = "#" + friendId + "#";
                hObject.put(userId, info);
            }

            if(hObject.containsKey(friendId)) {
                String info = hObject.get(friendId);
                info += userIdText + "#";
                hObject.replace(friendId, info);
            }
            else {
                String info = "#" + userIdText + "#";
                hObject.put(friendId, info);
            }
        }
    }

    //vObject id num#num#
    public static void processInputObject(HashMap<Integer, String> hObject, String value) {
        String[] arrValue = value.split(" ");
        if(arrValue.length == 3) {
            String userIdText = arrValue[1];
            String friendIdText = arrValue[2];
            Integer userId = Integer.parseInt(userIdText);
            Integer friendId = Integer.parseInt(friendIdText);

            if(hObject.containsKey(userId)) {
                String info = hObject.get(userId);
                info += friendIdText + "#";
                hObject.replace(userId, info);
            }
            else{
                String info = friendId + "#";
                hObject.put(userId, info);
            }
        }
    }

    public static void processArticle(HashMap<Integer, String> hArticle, String line) {
        String[] arrInfo = line.split(" ");
        if(arrInfo.length == 6) {
            String idText = arrInfo[2];
            Integer id = Integer.parseInt(idText);
            String newValue = arrInfo[1] + " " + arrInfo[3] + " " + arrInfo[4] + " " + arrInfo[5];

            if(hArticle.containsKey(id)) {
                String info = hArticle.get(id);
                info += newValue + "#";
                hArticle.replace(id, info);
            }
            else {
                String info = newValue + "#";
                hArticle.put(id, info);
            }
        }
        else if(arrInfo.length == 5) {
            String idText = arrInfo[2];
            Integer id = Integer.parseInt(idText);
            String newValue = arrInfo[1] + " " + arrInfo[3] + " " + arrInfo[4];

            if(hArticle.containsKey(id)) {
                String info = hArticle.get(id);
                info += newValue + "#";
                hArticle.replace(id, info);
            }
            else {
                String info = newValue + "#";
                hArticle.put(id, info);
            }
        }
    }

    //user info : 1 2020-12-08@06:30:30
    public static void processLevel1(String userInfo){
        int[][] fanpageArticleSelectedSort = new int[3][100000];
        int[][] userArticleSelectedSort = new int[3][100000];
        String[] arrUserInfo = userInfo.split(" ");
        if(arrUserInfo.length == 2) {
            String idUserText = arrUserInfo[0];
            String timeText = arrUserInfo[1];
            Integer idUser = Integer.parseInt(idUserText);
            //step1
            //get follow fanpage by user in hFollowFanpage.
            if(hFollowFanpage.containsKey(idUser)) {
                String infoText = hFollowFanpage.get(idUser);
                String[] arrIdFanPageText = infoText.split("#");
                int total = arrIdFanPageText.length;
                Vector<Integer> vecIdFanPage = new Vector<Integer>(total);

                for(int i = 0; i < total; i++) {
                    String idFanPageText = arrIdFanPageText[i];
                    if(!idFanPageText.isEmpty()) {
                        int id = Integer.parseInt(idFanPageText);
                        vecIdFanPage.add(id);
                    }
                }
                selectFanpageArticle(vecIdFanPage, timeText, fanpageArticleSelectedSort);
            }

            //step 2
            //get follow user by user in hFollowUser.
            //friend and follow
            if(hFollowUser.containsKey(idUser)) {
                String infoText = hFollowUser.get(idUser);
                String[] arrIdUserFollowText = infoText.split("#");
                int total = arrIdUserFollowText.length;
                Vector<Integer> vUserFriendFollow = new Vector<>();

                if(hFriends.containsKey(idUser)) {
                    String infoFriend = hFriends.get(idUser);
                    String[] arrFriend = infoFriend.split("#");
                    List<String> listFriend = Arrays.asList(arrFriend);
                    for (int i = 0; i < arrIdUserFollowText.length; i++) {
                        String idUserFollowText = arrIdUserFollowText[i];
                        if(listFriend.contains(idUserFollowText)) {
                            Integer idFriendFollow = Integer.parseInt(idUserFollowText);
                            vUserFriendFollow.add(idFriendFollow);
                        }
                    }
                }
                selectUserArticle(vUserFriendFollow, timeText, userArticleSelectedSort);
            }

            //show result
            for(int i = 0; i < 100000; i++) {
                int idFPArticle = fanpageArticleSelectedSort[2][i];
                int idUserArticle = userArticleSelectedSort[2][i];
                if(idFPArticle != 0) {
                    System.out.print(idFPArticle + " ");
                }
                if(idUserArticle != 0) {
                    System.out.print(idUserArticle + " ");
                }
                if(idFPArticle ==0 && idUserArticle == 0) {
                    System.out.println();
                    break;
                }
            }
        }
    }

    public static void selectFanpageArticle(Vector<Integer> vIdFanPage, String time, int[][] articleSelectedSort){
        //query fanpage article
        int index = 0;
        for(int i = 0; i < vIdFanPage.size(); i++) {
            int idFP = vIdFanPage.get(i);
            long currentTimeEporch = getEporchTime(time);
            if(hFanpageArticle.containsKey(idFP)) {
                String allFBArticle = hFanpageArticle.get(idFP);
                String[] arrFBArticle = allFBArticle.split("#");
                int maxSize = arrFBArticle.length;
;
                for(int j = 0; j < maxSize; j++) {
                    String article = arrFBArticle[j];
                    if(!article.isEmpty()) {
                        String[] arrArticle = article.split(" ");
                        if(arrArticle.length == 3) {
                            //fanpage article
                            String articleDate = arrArticle[1];

                            long articleTime = getEporchTime(articleDate);
                            if(isNearTime(currentTimeEporch, articleTime)) {
                                int distanceTime = (int) (currentTimeEporch - articleTime);
                                int viewNumber = Integer.parseInt(arrArticle[2]);
                                int idArticle = Integer.parseInt(arrArticle[0]);
                                articleSelectedSort[0][index] = viewNumber;
                                articleSelectedSort[1][index] = distanceTime;
                                articleSelectedSort[2][index] = idArticle;
                                index++;
                            }
                        }
                    }
                }
            }
        }
        if(index > 0)
            sort(articleSelectedSort, index-1);
    }

    public static void selectUserArticle(Vector<Integer> vUserIdFollow, String time, int[][] articleSelectedSort){
        //query fanpage article
        int index = 0;
        for(int i = 0; i < vUserIdFollow.size(); i++) {
            int userIdFollow = vUserIdFollow.get(i);
            long currentTimeEporch = getEporchTime(time);
            if(hUserArticle.containsKey(userIdFollow)) {
                String allUserFollowArticle = hUserArticle.get(userIdFollow);
                String[] arrUserFollowticle = allUserFollowArticle.split("#");
                int maxSize = arrUserFollowticle.length;
                ;
                for(int j = 0; j < maxSize; j++) {
                    String article = arrUserFollowticle[j];
                    if(!article.isEmpty()) {
                        String[] arrArticle = article.split(" ");
                        if(arrArticle.length == 4) {
                            //user article
                            String articleDate = arrArticle[1];

                            long articleTime = getEporchTime(articleDate);
                            if(isNearTime(currentTimeEporch, articleTime)) {
                                int distanceTime = (int) (currentTimeEporch - articleTime);
                                int viewNumber = Integer.parseInt(arrArticle[2]);
                                int idArticle = Integer.parseInt(arrArticle[0]);
                                boolean isPublic = false;
                                if(arrArticle[3].equals("public")) {
                                    isPublic = true;
                                }
                                articleSelectedSort[0][index] = viewNumber;
                                articleSelectedSort[1][index] = distanceTime;
                                articleSelectedSort[2][index] = idArticle;
                                index++;
                            }
                        }
                    }
                }
            }
        }
        if(index > 0)
            sort(articleSelectedSort, index-1);
    }

    public static void sort(int[][] arrObject, int index) {
        //first sort by views
        quickSort(arrObject, 0, false, 0, index);

        //second sort by time
        for(int i = 0; i < index; i++) {
            int indexEqual = findIndexEqualValue(arrObject, 0, i, index);
//            System.out.println("index: " + index);
            if(index > i) {
                quickSort(arrObject, 1,false, i, indexEqual);
                i = index + 1;
            }
        }
    }

    public static long getEporchTime(String dateString) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd@HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
        }
        long epoch = date.getTime();
        return epoch;
    }

    public static boolean isNearTime(long currentTime, long objectTime) {
        if(currentTime - objectTime > 7*24*60*60*1000)
            return false;
        return true;
    }

    public static int findIndexEqualValue(int[][] arr, int level, int index, int N) {
        int value = arr[level][index];
        for(int i = index; i < N; i++){
            if(arr[level][i] != value )
                return i-1;
        }
        return N-1;
    }

    public static void swap(int[][] arr, int left, int right)
    {
        int first = arr[0][left];
        int second = arr[1][left];
        int third = arr[2][left];

        arr[0][left] = arr[0][right];
        arr[1][left] = arr[1][right];
        arr[2][left] = arr[2][right];

        arr[0][right] = first;
        arr[1][right] = second;
        arr[2][right] = third;
    }


    public static int partition (int[][] arr, int level, boolean isIncrease, int low, int high)
    {
        int pivot = arr[level][high];    // pivot
        int left = low;
        int right = high - 1;
        if(isIncrease) {
            while(true){
                while(left <= right && arr[level][left] < pivot) left++;
                while(right >= left && arr[level][right] > pivot) right--;
                if (left >= right) break;
                swap(arr, left, right);
                left++;
                right--;
            }
            swap(arr, left, high);
            return left;
        }
        else {
            while(true){
                while(left <= right && arr[level][left] > pivot) left++;
                while(right >= left && arr[level][right] < pivot) right--;
                if (left >= right) break;
                swap(arr, left, right);
                left++;
                right--;
            }
            swap(arr, left, high);
            return left;
        }

    }

    public static void quickSort(int[][] arr, int level, boolean isIncrease, int low, int high)
    {
        if (low < high)
        {

            int pi = partition(arr,level, isIncrease, low, high);

            // recusive
            quickSort(arr, level, isIncrease, low, pi - 1);
            quickSort(arr, level, isIncrease, pi + 1, high);
        }
    }
}
