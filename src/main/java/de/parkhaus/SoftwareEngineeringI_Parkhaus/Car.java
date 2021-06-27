package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Car implements CarInterface {

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
    private double price = 0.0;
    private Random random = new Random();

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public Timestamp getEnterTime() {
        return this.enterTime;
    }

    public Timestamp getLeaveTime() {
        return this.leaveTime;
    }

    public String getCarColor() {
        return this.carColor;
    }

    public double getPrice() {
        return this.price;
    }

    public void setEnterTime(Timestamp enterTime) {
        this.enterTime = enterTime;
    }

    public void setLeaveTime(Timestamp leaveTime) {
        this.leaveTime = leaveTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Car() {
        this.carColor = generateCarColor();
        this.registrationNumber = generateRegistrationNumber();
    }

    private String generateCarColor() {
        return String.format("#%06x", this.random.nextInt(0xffffff + 1));
    }

    private String generateRegistrationNumber() {
        int firstLoop = this.random.nextInt(100);
        String carLocation;

        if (firstLoop <= 90) {
            carLocation = neighrestLocations[this.random.nextInt(neighrestLocations.length)];
        } else {
            carLocation = location[this.random.nextInt(location.length)];
        }

        char firstLetter = (char) (this.random.nextInt(26) + 'A');
        char secondLetter = (char) (this.random.nextInt(26) + 'A');

        int numbers = this.random.nextInt(9999);

        return  String.format("%s %c%c %d", carLocation, firstLetter, secondLetter, numbers);
    }
}