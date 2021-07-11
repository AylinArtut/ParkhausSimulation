package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.sql.Timestamp;
import java.util.Random;

public class Car implements ICar {
    private String carColor;
    private String registrationNumber;

    // "enterTime" & "leaveTime" are ticket information:
    private Timestamp enterTime;
    private Timestamp leaveTime;

    private double price = 0.0;

    // I just wanted only one instance of "Random" in this class, which I can use everywhere:
    private Random random = new Random();

    // Some german locations for registration number:
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

    // These are locations for cars, which visit more often the car park (to make it more realistic):
    private String[] nearestNeighbours = {"K", "SU", "BN", "D"};

    // Whenever a car is spawned, it gets a random generated color & a registration number:
    public Car() {
        this.carColor = generateCarColor();
        this.registrationNumber = generateRegistrationNumber();
    }

    // "Getter- & Setter" are a bit over the top for a little simulation like this, but I thought it would be okay to use:
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

    // This generates random color for cars:
    private String generateCarColor() {
        return String.format("#%06x", this.random.nextInt(0xffffff + 1));
    }

    // This generates random registration number for cars & same registration numbers are okay, 'cause any car can park any time it wants again:
    private String generateRegistrationNumber() {
        String carLocation;

        // The chance to get one in "nearestNeighbours" is higher than other locations:
        if (this.random.nextInt(100) <= 90) {
            carLocation = nearestNeighbours[this.random.nextInt(nearestNeighbours.length)];
        } else {
            carLocation = location[this.random.nextInt(location.length)];
        }

        // Generating both capital letters, which you can always see on registration numbers:
        char firstLetter = (char) (this.random.nextInt(26) + 'A');
        char secondLetter = (char) (this.random.nextInt(26) + 'A');

        // And those numbers, which are always behind letters:
        int numbers = this.random.nextInt(9999);

        // By any mistake: I'm female & I don't understand car stuff ! (^_^)
        return  String.format("%s %c%c %d", carLocation, firstLetter, secondLetter, numbers);
    }
}