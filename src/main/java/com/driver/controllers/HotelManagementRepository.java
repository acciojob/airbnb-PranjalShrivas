//package com.driver.controllers;
//
//import com.driver.model.Booking;
//import com.driver.model.Facility;
//import com.driver.model.Hotel;
//import com.driver.model.User;
//import org.springframework.stereotype.Repository;
//
//import java.awt.print.Book;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.UUID;
//
//
//public class HotelManagementRepository {
//    HashMap<String, Hotel> hotelMap= new HashMap<>();
//    HashMap<Integer, User> userMap=new HashMap<>();
//    HashMap<String, Booking> bookingMap=new HashMap<>();
//
//    HashMap<Integer, List<Booking>> userBookingList= new HashMap<>();
//
//    private String hotelMaxFacility="";
//    private int maxFacilityCount=0;
//
//    public String addHotel(Hotel hotel){
//        if(hotel==null){
//            return "FAILURE";
//        }
//        String key= hotel.getHotelName();
//        if(key==null){
//            return "FAILURE";
//        }
//        if(hotelMap.containsKey(key)){
//            return "FAILURE";
//        }
//        hotelMap.put(key,hotel);
//
//        int countFacilities= hotel.getFacilities().size();
//        if(countFacilities>=maxFacilityCount){
//            if(countFacilities==maxFacilityCount){
//                if(hotel.getHotelName().compareTo(hotelMaxFacility)<0){
//                    hotelMaxFacility=hotel.getHotelName();
//                }else{
//                    maxFacilityCount=countFacilities;
//                    hotelMaxFacility=hotel.getHotelName();
//                }
//            }
//
//        }
//        return "SUCCESS";
//    }
////        public Integer addUser(User user){
////            userMap.put(user.getaadharCardNo(),user);
////            return user.getaadharCardNo();
////        }
////
////        public String getHotelWithMostFacilities(){
////            return hotelMaxFacility;
////        }
//
////        public int bookARoom(Booking booking){
////            Hotel hotelToBeBooked = hotelMap.get(booking.getHotelName());
////            if(booking.getNoOfRooms()>hotelToBeBooked.getAvailableRooms()){
////                return -1;
////            }
////            else{
////                hotelToBeBooked.setAvailableRooms(hotelToBeBooked.getAvailableRooms()-booking.getNoOfRooms());
////                booking.setBookingId(String.valueOf(UUID.randomUUID()));
////                booking.setAmountToBePaid(booking.getNoOfRooms() * hotelToBeBooked.getPricePerNight());
////                bookingMap.put(booking.getBookingId(), booking);
////                if(!userBookingList.containsKey(booking.getBookingAadharCard())){
////                    userBookingList.put(booking.getBookingAadharCard(), new ArrayList<>());
////                }
////                userBookingList.get(booking.getBookingAadharCard()).add(booking);
////                return booking.getAmountToBePaid();
////            }
////        }
//
////        public int getBookings(Integer aadharCard){
////            return userBookingList.get(aadharCard).size();
////        }
//
//        public Hotel updateFacilities(List<Facility> newFacilities, String hotelName) {
//            if(!hotelMap.containsKey(hotelName)){
//                return new Hotel();
//            }
//
//            Hotel currHotel = hotelMap.get(hotelName);
//
//            for(Facility facility: newFacilities){
//                if(!currHotel.getFacilities().contains(facility)){
//                    currHotel.getFacilities().add(facility);
//                }
//            }
//
//            int countOfFacilities = currHotel.getFacilities().size();
//            if(countOfFacilities>=maxFacilityCount){
//                if(countOfFacilities==maxFacilityCount){
//                    if(currHotel.getHotelName().compareTo(hotelMaxFacility)<0){
//                        hotelMaxFacility = currHotel.getHotelName();
//                    }
//                }else{
//                    maxFacilityCount = countOfFacilities;
//                    hotelMaxFacility = currHotel.getHotelName();
//                }
//            }
//            return currHotel;
//        }
//
//
//    public Integer addUser(User user) {
//        userMap.put(user.getaadharCardNo(),user);
//        return user.getaadharCardNo();
//    }
//
//    public String getHotelWithMostFacilities() {
//        return hotelMaxFacility;
//    }
//
//    public int bookARoom(Booking booking) {
//        Hotel hotelToBeBooked = hotelMap.get(booking.getHotelName());
//        if(booking.getNoOfRooms()>hotelToBeBooked.getAvailableRooms()){
//            return -1;
//        }
//        else{
//            hotelToBeBooked.setAvailableRooms(hotelToBeBooked.getAvailableRooms()-booking.getNoOfRooms());
//            booking.setBookingId(String.valueOf(UUID.randomUUID()));
//            booking.setAmountToBePaid(booking.getNoOfRooms() * hotelToBeBooked.getPricePerNight());
//            bookingMap.put(booking.getBookingId(), booking);
//            if(!userBookingList.containsKey(booking.getBookingAadharCard())){
//                userBookingList.put(booking.getBookingAadharCard(), new ArrayList<>());
//            }
//            userBookingList.get(booking.getBookingAadharCard()).add(booking);
//            return booking.getAmountToBePaid();
//        }
//    }
//
//    public int getBookings(Integer aadharCard) {
//        return userBookingList.get(aadharCard).size();
//    }
//
//
//}

package com.driver.controllers;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository

public class HotelManagementRepository {


    HashMap<String,Hotel>hotelDb=new HashMap<>();
    HashMap<Integer,User>userDb=new HashMap<>();
    HashMap<String,Booking>bookingDb=new HashMap<>();





    public String addHotel(Hotel hotel) {
        String hotelname=hotel.getHotelName();
        if(hotelname==null){
            return "FAILURE";
        }
        if(hotelDb.containsKey(hotelname)){
            return "FAILURE";
        }
        else{
            hotelDb.put(hotelname,hotel);
            return "SUCCESS";
        }
    }

    public Integer addUser(User user) {
        //String username=user.getName();
        int aadhar=user.getaadharCardNo();

        userDb.put(aadhar,user);
        return aadhar;
    }

    public String getHotelWithMostFacilities() {
        int maxfacility=0;
        String str="";

        for(String key:hotelDb.keySet()){
            List<Facility> ans=hotelDb.get(key).getFacilities();
            int size=ans.size();
            if(size>maxfacility  ){
                maxfacility=size;
                str=key;
            }
            else if(size==maxfacility){
                if(key.compareTo(str)<0){
                    str=key;
                }
            }
        }
        if(maxfacility==0){
            return "";
        }
        else{
            return str;
        }
    }

    public int bookARoom(Booking booking) {

        UUID uuid=UUID.randomUUID();
        String ans=uuid.toString();
        booking.setBookingId(ans);

        String name=booking.getHotelName();
        Hotel hotel=hotelDb.get(name);

        int noofrooms=hotel.getAvailableRooms();
        int bookingrooms=booking.getNoOfRooms();
        int priceperday=hotel.getPricePerNight();

        if(noofrooms<bookingrooms){
            return -1;
        }
        int totalamount=priceperday*bookingrooms;
        booking.setAmountToBePaid(totalamount);

        hotel.setAvailableRooms(noofrooms-bookingrooms);
        bookingDb.put(ans,booking);
        hotelDb.put(name,hotel);

        return totalamount;

    }

    public int getBookings(Integer aadharCard) {

        int count=0;

        for(String ans:bookingDb.keySet()){
            if(bookingDb.get(ans).getBookingAadharCard()==aadharCard){
                count++;
            }
        }

        return count;
    }

    public Hotel updateFacilities(List<Facility> newFacilities, String hotelName) {
        Hotel hotel=hotelDb.get(hotelName);
        List<Facility>oldfacilities=hotel.getFacilities();

        for(Facility facility:newFacilities){
            if(oldfacilities.contains(facility)){
                continue;
            }
            else{
                oldfacilities.add(facility);
            }
        }
        hotel.setFacilities(oldfacilities);
        hotelDb.put(hotelName,hotel);

        return hotel;


    }
}
