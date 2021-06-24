package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Car{

    private String[] location = {"A", "AA", "AB", "ABG", "ABI", "AC", "AE", "AH", "AIB", "AIC", "AK", "ALF",
                                 "ALZ", "AM", "AN", "ANA", "ANG", "ANK", "AÖ", "AP", "APD", "ARN", "ART", "AS",
                                 "ASL", "ASZ", "AT", "AU", "AUR", "AW", "AZ", "AZE", "B", "BA", "BAD", "BAR", "BB",
                                 "BBG", "BBL", "BC", "BCH", "BD", "BE", "BED", "BER", "BF", "BGD", "BGL", "BH", "BI",
                                 "BID", "BIN", "BIR", "BIT", "BIW", "BK", "BKS", "BL", "BLB", "BLK", "BM", "BN",
                                 "BNA", "BO", "BÖ", "BOG", "BOH", "BOR", "BOT", "BP", "BRA", "BRB", "BRG", "BRK",
                                 "BRL", "BRV", "BS", "BSB", "BSK", "BT", "BTF", "BÜD", "BUL", "BÜR", "BÜS", "BÜZ",
                                 "BW", "BWL", "BYL", "BZ", "C", "CA", "CAS", "CB", "CE", "CHA", "CLP", "CLZ", "CO",
                                 "COC", "COE", "CR", "CUX", "CW", "D", "DA", "DAH", "DAN", "DAU", "DBR", "DD", "DE",
                                 "DEG", "DEL", "DGF", "DH", "DIL", "DIN", "DIZ", "DKB", "DL", "DLG", "DM", "DN", "DO",
                                 "DON", "DU", "DUD", "DÜW", "DW", "DZ", "E", "EA", "EB", "EBE", "EBN", "EBS", "ECK",
                                 "ED", "EE", "EF", "EG", "EH", "EI", "EIC", "EIL", "EIN", "EIS", "EL", "EM", "EMD",
                                 "EMS", "EN", "ER", "ERB", "ERH", "ERK", "ERZ", "ES", "ESB", "ESW", "EU", "EW", "F",
                                 "FB", "FD", "FDB", "FDS", "FEU", "FF", "FFB", "FG", "FI", "FKB", "FL", "FLÖ", "FN",
                                 "FO", "FOR", "FR", "FRG", "FRI", "FRW", "FS", "FT", "FTL", "FÜ", "FÜS", "FW", "FZ",
                                 "G", "GA", "GAN", "GAP", "GC", "GD", "GDB", "GE", "GEL", "GEO", "GER", "GF", "GG",
                                 "GHA", "GHC", "GI", "GK", "GL", "GLA", "GM", "GMN", "GN", "GNT", "GÖ", "GOA", "GOH",
                                 "GP", "GR", "GRA", "GRH", "GRI", "GT", "GV", "H", "HB", "HBS", "HBN", "HC", "HCH",
                                 "HD", "HDL", "HEB", "HF", "HG", "HGW", "HHM", "HN", "HR", "HU", "HX", "HY", "IGB",
                                 "IK", "IL", "ILL", "IN", "IZ", "J", "JE", "JL", "JÜL", "K", "KA", "KB", "KC",
                                 "KEH", "KEL", "KEM", "KI", "KÖN", "KÜN", "KUS", "KW", "KYF", "L", "LAN", "LAU",
                                 "LB", "LBS", "LBZ", "LC", "LD", "LDK", "LDS", "LEV", "LIF", "LU", "M", "MAB", "N",
                                 "NE", "NEB", "NI", "NL", "NM", "NÖ", "NR", "OH", "OP", "OPR", "PB", "R", "RA", "RE",
                                 "RH", "RN", "ROF", "S", "SAL", "SB", "SAN", "SBG", "SC", "SEB", "SFT", "SHA", "SI",
                                 "SHK", "SL", "SLE", "SN", "STA", "SZ", "T", "TR", "UE", "V", "VG", "VK", "WÜ",
                                 "WW", "WZ", "ZI", "ZP", "ZR", "ZW", "ZZ"};
    private String[] neighrestLocations = {"K", "SU", "BN", "D"};
    private String registrationNumber;
    private Timestamp enterTime;
    private Timestamp leaveTime;
    private String carColor;
    private double price;

    public String getRegistrationNumber(){
        return this.registrationNumber;
    }

    public Timestamp getEnterTime(){
        return this.enterTime;
    }

    public Timestamp getLeaveTime(){
        return this.leaveTime;
    }

    public String getCarColor(){
        return this.carColor;
    }

    public double getPrice(){
        return this.price;
    }

    public void setEnterTime(Timestamp enterTime){
        this.enterTime = enterTime;
    }

    public void setLeaveTime(Timestamp leaveTime){
        this.leaveTime = leaveTime;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public Car(){
        Random randomNumber = new Random();
        setCarColor(randomNumber);
        setRegistrationNumber(randomNumber);
    }

    public String formatDate(Timestamp timeStamp){
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM.yy, HH:mm");
        return sdf3.format(timeStamp);
    }

    public String setCarColor(Random randomNumber){
        this.carColor = String.format("#%06x", randomNumber.nextInt(0xffffff + 1));
        return this.carColor;
    }

    public String setRegistrationNumber(Random randomNumber){
        int firstLoop = randomNumber.nextInt(100);
        String carLocation;

        if(firstLoop <= 90){
            carLocation = neighrestLocations[randomNumber.nextInt(neighrestLocations.length)];
        }else{
            carLocation = location[randomNumber.nextInt(location.length)];
        }

        char firstLetter = (char)(randomNumber.nextInt(26) + 'A');
        char secondLetter = (char)(randomNumber.nextInt(26) + 'A');

        int numbers = randomNumber.nextInt(9999);

        this.registrationNumber = carLocation + "  " + firstLetter + "" + secondLetter + "  " + numbers;
        return this.registrationNumber;
    }
}