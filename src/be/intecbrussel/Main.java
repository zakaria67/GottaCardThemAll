package be.intecbrussel;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        PostCard belgium = new PostCard("Belgium", "Europe");
        PostCard france = new PostCard("France", "Europe");
        PostCard japan = new PostCard("Japan", "Asia");
        PostCard rdc = new PostCard("Democratic Republic of Congo", "Africa");
        PostCard southKorea = new PostCard("South Korea", "Asia");
        PostCard belgium2 = new PostCard("Belgium", "Europe");
        PostCard southAfrica = new PostCard("South Africa", "Africa");
        PostCard france2 = new PostCard("France", "Europe");
        PostCard belgium3 = new PostCard("Belgium", "Europe");
        PostCard usa = new PostCard("United States of America", "North America");
        PostCard canada = new PostCard("Canada", "North America");
        PostCard peru = new PostCard("Peru", "South America");
        PostCard samoa = new PostCard("Samoa", "Oceania");
        PostCard belgium4 = new PostCard("Belgium", "Europe");
        PostCard france3 = new PostCard("France", "Europe");

        List<PostCard> yourPostCardList = new ArrayList();
        yourPostCardList.add(belgium);
        yourPostCardList.add(france);
        yourPostCardList.add(japan);
        yourPostCardList.add(rdc);
        yourPostCardList.add(southKorea);
        yourPostCardList.add(belgium2);
        yourPostCardList.add(southAfrica);
        yourPostCardList.add(france2);
        yourPostCardList.add(belgium3);
        yourPostCardList.add(usa);
        yourPostCardList.add(canada);
        yourPostCardList.add(peru);
        yourPostCardList.add(samoa);
        yourPostCardList.add(belgium4);
        yourPostCardList.add(france3);


        PostCard northKorea = new PostCard("North Korea", "Asia");
        PostCard usa2 = new PostCard("United States of America", "North America");
        PostCard botswana = new PostCard("Botswana", "Africa");
        PostCard northKorea2 = new PostCard("North Korea", "Asia");

        List<PostCard> yourFriendsPostCardList = new ArrayList();
        yourFriendsPostCardList.add(northKorea);
        yourFriendsPostCardList.add(usa2);
        yourFriendsPostCardList.add(botswana);
        yourFriendsPostCardList.add(northKorea2);
//your friends
        Friend bobby = new Friend("Bobby",false, 3, 5);
        Friend melissa = new Friend("Melissa",false, 1, 6);
        Friend darla = new Friend("Darla",true, 14, 2);
        Friend bert = new Friend("Bert",false, 10, 4);
        Friend grandma = new Friend("Nana",true, 12, 7);
        Friend fester = new Friend("Fester",false, 1, 2);
        Friend anna = new Friend("Anna",false, 8, 4);

        System.out.println("Before trading");
        System.out.println(yourPostCardList);
        System.out.println("MY LIST | FRIENDS LIST");
        sortListByCountry(yourPostCardList);
        exercise(yourPostCardList,yourFriendsPostCardList);
        sortListByCountry(yourPostCardList);

        List<PostCard> duplicates = new ArrayList<>();
        for (PostCard postCard: yourPostCardList){
            int amount = Collections.frequency(yourPostCardList,postCard);
            System.out.println(postCard.getCountry()+ ": "+ amount);
            if (amount>1){
                duplicates.add(postCard);
                yourPostCardList.remove(postCard);
            }
        }
        System.out.println(yourPostCardList);
        System.out.println(duplicates);

        //Opdracht3
        List<PostCard> dublicates = new ArrayList<>();
        for (int i = 0; i<yourFriendsPostCardList.size(); i++) {
            PostCard postCard = yourFriendsPostCardList.get(i);
            int amount = Collections.frequency(yourPostCardList, postCard);
            System.out.println(postCard.getCountry() + ": " +amount);
            if (amount > 1) {
                dublicates.add(postCard);
                yourPostCardList.remove(postCard);
                i--;
            }
        }
        System.out.println(yourPostCardList);
        System.out.println(dublicates);

//Opdracht4

        Comparator<Friend> compareFamily = (friend1, friend2) -> Boolean.compare(friend1.isFamily(),friend2.isFamily());
        Comparator<Friend> compareFriendship = (friend1, friend2) -> Integer.compare(friend2.getFriendShipLevel(),friend1.getFriendShipLevel());
        Comparator<Friend> compareYearsFriendship = (friend1, friend2) -> Integer.compare(friend2.getYearsKnown(), friend1.getYearsKnown());

        PriorityQueue<Friend> sortedFriends = new PriorityQueue<>(
                compareFamily.thenComparing(compareFriendship.thenComparing(compareYearsFriendship))
        );
        sortedFriends.offer(bobby);
        sortedFriends.offer(melissa);
        sortedFriends.offer(darla);
        sortedFriends.offer(bert);
        sortedFriends.offer(grandma);
        sortedFriends.offer(fester);
        sortedFriends.offer(anna);

        while (sortedFriends.size() > 0) {
            System.out.println(sortedFriends.poll());
        }
        System.out.println(sortedFriends);


    }

//        //Opdracht1
//
//        yourPostCardList.remove(5);
//        yourPostCardList.add(5, northKorea);
//        yourPostCardList.remove(7);
//        yourPostCardList.add(7,botswana);
//        yourPostCardList.remove(8);
//        yourPostCardList.add(8,northKorea2);
//        yourPostCardList.remove(13);
//        yourPostCardList.add(13,usa2);
//
//        System.out.println(yourPostCardList.get(5));
//        System.out.println(yourPostCardList.get(7));
//        System.out.println(yourPostCardList.get(8));
//        System.out.println(yourPostCardList.get(13));
//
//        //Opdracht2
//        System.out.println("----Opdracht2-----");
//
//        List<PostCard> sortedCountries = yourPostCardList
//                .stream()
//                .sorted(Comparator.comparing(PostCard::getCountry))
//                .collect(Collectors.toList());
//                sortedCountries.forEach(System.out::println);



//    private static void exercice (List<PostCard> myList, List<PostCard> friendsList){
//        PostCard myPostCardToTrade= null;
//        PostCard myFriendsPostCardToTrade=null;
//
//        int myIndex =0;
//
//        for (int i=0; i<myList.size();i++){
//            PostCard postCard = myList.get(i);
//            for (int j = i+1; j< myList.size();j++){
//                if (myList.get(j).getCountry().equals(postCard.getCountry())){
//                    myPostCardToTrade = postCard;
//                    myIndex=i;
//                    break;
//
//                }
//            }
//            if (myPostCardToTrade != null){
//                break;
//            }
//        }
//
//        for (int i=0; i<friendsList.size();i++) {
//            PostCard postCard = friendsList.get(i);
//            for (int j = i + 1; j < friendsList.size(); j++) {
//                if (friendsList.get(j).getCountry().equals(postCard.getCountry())) {
//                    myFriendsPostCardToTrade = postCard;
//                    break;
//                }
//            }
//            if (myPostCardToTrade != null){
//                break;
//            }
//        }
//        if (myPostCardToTrade != null && myFriendsPostCardToTrade = null ) {
//            myList.set(myIndex, myFriendsPostCardToTrade);
//            friendsList.remove(myFriendsPostCardToTrade);
//            friendsList.add((myPostCardToTrade));
//
//
//        }
//
//    }
private static void exercise(List<PostCard> myList, List<PostCard> friendList) {
    PostCard myPostCardToTrade = null;
    PostCard myFriendPostCardToTrade = null;
    int myIndex = 0;
    for (int i = 0; i < myList.size(); i++) {
        PostCard postCard = myList.get(i);
        for (int j = i+1; j < myList.size(); j++) {
            if (myList.get(j).getCountry().equals(postCard.getCountry())) {
                myPostCardToTrade = postCard;
                myIndex = i;
                break;
            }
        }

        if (myPostCardToTrade != null) {
            break;
        }
    }

    for (int i = 0; i < friendList.size(); i++) {
        PostCard postCard = friendList.get(i);
        for (int j = i+1; j < friendList.size(); j++) {
            if (friendList.get(j).getCountry().equals(postCard.getCountry())) {
                myFriendPostCardToTrade = postCard;
                break;
            }
        }

        if (myPostCardToTrade != null) {
            break;
        }

    }
    if(myPostCardToTrade != null && myFriendPostCardToTrade != null) {
        myList.set(myIndex, myFriendPostCardToTrade);
        friendList.remove(myFriendPostCardToTrade);
        friendList.add(myPostCardToTrade);
    }
}
//opdracht2

    private static void sortListByCountry(List<PostCard> myList){
        Collections.sort(myList,Comparator.comparing(postCard -> postCard.getCountry()));
    }

    //Opdracht3


}
