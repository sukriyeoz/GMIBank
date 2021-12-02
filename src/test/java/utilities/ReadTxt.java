package utilities;


import pojos.CustomerPojo;
import pojos.RegistrantPojo;
import pojos.StatesPojo;
import pojos.UserPojo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class ReadTxt {

    public static List<CustomerPojo> returnCustomer(String filePath){
        List<CustomerPojo>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                CustomerPojo customer = new CustomerPojo();
                sb.append(line);
//                sb.append(System.lineSeparator());
                line = br.readLine();
                String [] each = line.split(",");
                if(each[0] != null)
                    customer.setFirstName(each[0]);
                if(each[1] != null)
                    customer.setLastName(each[1]);
                if(each[2] != null)
                    customer.setSsn(each[2]);
                all.add(customer);
            }
            String everything = sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }



    public static List<CustomerPojo> returnCustomerSNN(String filePath){
        List<CustomerPojo>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            int i = 0;
            while (line != null) {
                CustomerPojo customer = new CustomerPojo();
                customer.setSsn(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static List<CustomerPojo> readTxtData(String filePath)throws  Exception{
        List<CustomerPojo> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            CustomerPojo customer = new CustomerPojo();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
//                customer.setSsn(line);

            }
            String everything = sb.toString();

            customer.setSsn(everything);
            list.add(customer);
        } finally {
            br.close();
        }
        return list;

    }

    //    public static List<States> returnAllStates(String filePath){
//        List<States>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                States state = new States();
//                String [] allLine = line.split(",");
//
//                int id = Integer.parseInt(allLine[1].trim());
//                state.setId(id);
//                state.setName(allLine[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//
//                System.out.println(i++);
//
//                all.add(state);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }

    public static List<String> returnCustomerSNNList(String filePath){
        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                CustomerPojo customer = new CustomerPojo();
                customer.setSsn(line.split(",")[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

//                System.out.println(i++);

                all.add(customer.getSsn());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }


    //    public static List<States> returnAllStates2(String filePath){
//        List<States>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                States states = new States();
//                states.setName(line.split(",")[0].trim());
//                states.setId(Integer.parseInt(line.split(",")[1].trim()));
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//
//                System.out.println(i++);
//
//                all.add(states);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }

    public static List<String> returnAllStates3(String filePath){
        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                String temp = "";
                temp =line.split(",")[0].trim();

                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }



//-----------------------------------------------------------------------------------------

    public static void main(String[] args) {
        String fileName = "C:\\Users\\BelomeX\\IdeaProjects\\_xGMI\\src\\test\\resources\\_testData\\RegistrantInfo.txt";
//        System.out.println(returnAWholeUser(fileName).get(8).getSsn());

        List<UserPojo> expectedUser = returnAWholeUser(fileName);

//        System.out.println(expectedUser.get(expectedUser.size()-1).getUsername());

        for(int i=0; i<expectedUser.size(); i++ ){
            System.out.println(expectedUser.get(i).getUsername());
            System.out.println(expectedUser.get(i).getEmail());
            System.out.println(expectedUser.get(i).getSsn());
        }
    }

    public static List<UserPojo> returnAWholeUser(String filePath){
        List<UserPojo>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            int i = 0;
            while (line != null) {
                UserPojo customer = new UserPojo();

                customer.setPassword(line.split(",")[0].trim());
                customer.setUsername(line.split(",")[1].trim());
                customer.setFirstName(line.split(",")[2].trim());
                customer.setLastName(line.split(",")[3].trim());
                customer.setSsn(line.split(",")[4].trim());
                customer.setAddress(line.split(",")[5].trim());
                customer.setEmail(line.split(",")[6].trim());
                customer.setPhoneNumber(line.split(",")[7].trim());
                line = br.readLine();



                all.add(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }





    public static List<String> returnAllCustomerCredentials(String filePath){
        List<String >list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
//            System.out.println(line);
            int i = 0;
            while (line != null) {

                String username =line.split(",")[1].trim();
                String password = line.split(",")[0].trim();
                list.add(password);
                list.add(username);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> returnAllAccounts(String filePath){
        List<String >list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
//            System.out.println(line);

            while (line != null) {


                String accountDescription = line.split(",")[0].trim();
                list.add(accountDescription);
                sb.append(System.lineSeparator());
                line = br.readLine();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<StatesPojo> returnAllStates(String filePath){
        List<StatesPojo>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                StatesPojo state = new StatesPojo();
                String [] allLine = line.split(",");

                int id = Integer.parseInt(allLine[1].trim());
                state.setId(id);
                state.setName(allLine[0]);
                sb.append(System.lineSeparator());
                line = br.readLine();

                System.out.println(i++);

                all.add(state);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

//--------------------------------------------------------------------
//-------------------------------------------------------------------

    public static List<RegistrantPojo> returnAWholeRegistrant(String filePath){

        List<RegistrantPojo>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            int i = 0;
            while (line != null) {
                RegistrantPojo registrant = new RegistrantPojo();

                registrant.setPassword(line.split(",")[0].trim());
                registrant.setUsername(line.split(",")[1].trim());
                registrant.setFirstname(line.split(",")[2].trim());
                registrant.setLastname(line.split(",")[3].trim());
                registrant.setSsn(line.split(",")[4].trim());
                registrant.setPhonenumber(line.split(",")[5].trim());
                registrant.setAddress(line.split(",")[6].trim());
                registrant.setEmail(line.split(",")[7].trim());

                line = br.readLine();

                all.add(registrant);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }



}