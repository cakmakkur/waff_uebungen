package at.technikum.IpCalculator;

import java.util.Scanner;

public class SubnetFinder {

    private String[] ipToBinaryStringArray (String s) {
        String[] binaryIpArr = new String[4];
        String[] arrIp = s.split("\\.");
        for (int i = 0; i < 4; i++) {
            String binaryString = Integer.toBinaryString(Integer.parseInt(arrIp[i]));
            while (binaryString.length() < 8) {
                binaryString = "0" + binaryString;
            }
            binaryIpArr[i] = binaryString;
        }
        return binaryIpArr;
    }

    private String subnetworkId (String[] ip, String[] mask) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int segIp = Integer.parseInt(ip[i], 2);
            int segMask = Integer.parseInt(mask[i], 2);
            int res = segIp & segMask;
            sb.append(res).append(".");
        }
        return sb.substring(0, sb.length()-1);
    }

    private String broadcastIP (String[] ip, String[] mask) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int segIp = Integer.parseInt(ip[i], 2);
            int segMask = Integer.parseInt(mask[i], 2);
            // ~ operator flips every bit - reverses it
            int segWild = ~segMask & 0xff;
            int res = segIp | segWild;
            sb.append(res).append(".");
        }
        return sb.substring(0, sb.length()-1);
    }

    public void showSubnetDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter IP address");
        String ipAddress = sc.nextLine();
        System.out.println("Enter subnet mask");
        String subnetMask = sc.nextLine();

        String[] ipBinaryStrArr = ipToBinaryStringArray(ipAddress);
        String[] maskBinaryStrArr = ipToBinaryStringArray(subnetMask);

        System.out.println("Sub-Network ID: " + subnetworkId(ipBinaryStrArr, maskBinaryStrArr));
        System.out.println("Broadcast IP: " + broadcastIP(ipBinaryStrArr, maskBinaryStrArr));

        sc.close();
    }
}
