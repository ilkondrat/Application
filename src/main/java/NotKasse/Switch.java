package NotKasse;

public class Switch {
    public static void main(String[] args) {
        int day = 3;
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Working";
            case 6, 7 -> "Relax";
            default -> "Incorrect";
        };
        System.out.println("Day type: " + dayType);


        int dayZ = 7;
        String dayType2;
        switch (dayZ) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                dayType2 = "Workday";

            case 6:
            case 7:
                dayType2 = "Relax";
                break;
            default:
                dayType2 = "Wrong day type";

        }
        System.out.println("Day type: " + dayType2);
    }
}