package utilities;

import pojos.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteToTxt {
    public static void saveDataInFile(String fileName, CustomerPojo[] customers)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0;i<customers.length;i++)
                writer.append(customers[i].getSsn()+",\n");
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveDataInFileWithSSN(String fileName, CustomerPojo customer)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(customer.getSsn());
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveDataInFileWithSSN(String fileName, CustomerPojo[] customers)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < customers.length ; i++) {
                writer.append(customers[i].getSsn()+",\n");
            }
            writer.close();
        } catch(Exception e){
        }
    }
    //    public static void saveDataInFileWithSSN(String fileName, Customer[] customer)  {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i < customer.length ; i++) {
//                writer.append(customer[i].getSsn()+",\n");
//            }
//            writer.close();
//        } catch(Exception e){
//        }
//    }
    public static void saveDataInFileWithUserInfo(String fileName, CustomerPojo customer)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(customer.getUser().getFirstName());
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveDataInFileWithAllCustomerInfo(String fileName, CustomerPojo[] customers)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i =0; i<customers.length;i++){
                writer.append(customers[i].getFirstName()+" , "+customers[i].getLastName()+"\n");
                if(customers[i].getUser() != null)
                    writer.append(customers[i].getUser().getFirstName());
                if(customers[i].getCountry() != null)
                    writer.append(customers[i].getCountry().getName());
            }
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAllStates(String fileName, StatesPojo[] states)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0; i<states.length; i++)
                writer.append(states[i].getName()+" , "+states[i].getId()+"\n");
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAllStates2(String fileName, StatesPojo[] states)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0; i<states.length; i++)
                writer.append(states[i].getName()+" , "+states[i].getId()+"\n");
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAllCustomers(String fileName, CustomerPojo[]customers)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0; i<customers.length; i++) {
                writer.append(customers[i].getSsn() + "," + customers[i].getFirstName() + ",");
                if(customers[i].getCountry() != null)
                    writer.append(customers[i].getCountry().getName() + "," + customers[i].getCountry().getId() + ",\n");
            }
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAllCustomer(String fileName, CustomerPojo customer, String password, String username)  {
        try {
//            String name ="C:\\Users\\sam\\IdeaProjects\\GMIBank\\src\\test\\resources\\test_data\\CustomerInfo.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(password + "," +username+","+ customer.getFirstName() + ",");
            writer.append(customer.getLastName() + "," + customer.getSsn() + ",");
            writer.append(customer.getAddress() + "," + customer.getEmail() + ","+customer.getMobilePhoneNumber()+"\n");
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAllCustomersComingFromDB(String fileName, List<Object> allCustomer)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0; i<allCustomer.size(); i++) {
                writer.append(allCustomer.get(i) + ",\n" );
            }
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveDifferentInfoFromDB(String fileName, List<Object> data)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i=0; i<data.size(); i++) {
                writer.append(data.get(i) + ",\n" );
            }
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveAccountInfo(String fileName, String description)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(description + ",\n" );
            writer.close();
        } catch(Exception e){
        }
    }
    public static void saveCustomerInfo ( List <String> items){
        String fileLocation = "location";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true));
            for (int i = 0; i < items.size(); i++) {
                writer.append(items.get(i)+"\n");
            }
        }catch (Exception e){
        }
    }
    public static void saveRegistrantData(String fileNameOfRegistrant, RegistrantPojo registrant)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOfRegistrant, true));

            writer.append(registrant.getPassword()+ " , "+ registrant.getUsername()+" , ");
            writer.append(registrant.getFirstname()+" , "+ registrant.getLastname()+" , ");
            writer.append(registrant.getSsn()+      " , "+ registrant.getPhonenumber()+" , ");
            writer.append(registrant.getAddress()+  " , "+ registrant.getEmail()+",\n");
            writer.close();
        } catch(Exception e){
        }
    }

    public static void main(String[] args) {
        String filex="src/test/resources/_testData/xProject9.txt";
        RegistrantPojo registrant = new RegistrantPojo();

        registrant.setPassword("2314234werwE@#$");
        registrant.setUsername("emrahov");
        registrant.setFirstname("emrah");
        registrant.setLastname("emrahs");
        registrant.setSsn("321-21-3211");
        registrant.setPhonenumber("321-321-3214");
        registrant.setAddress("21 Alex st");
        registrant.setEmail("sasda2@gmail.com");

        saveRegistrantData(filex,registrant);

    }


    public static void saveDataInFileWithSSNx(String fileName, CustomerPojo[] customer)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (int i = 0; i < customer.length ; i++) {
                writer.append(customer[i].getSsn()+",\n");
            }
            writer.close();
        } catch(Exception e){
        }
    }
//    public static void saveRegistrantData(String fileName, Registrant2 registrant2)  {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            writer.append(registrant2.getPassword()+","+ registrant2.getUsername()+",");
//            writer.append(registrant2.getFirstname()+","+ registrant2.getLastname()+",");
//            writer.append(registrant2.getSnn()+","+ registrant2.getPhonenumber()+",");
//            writer.append(registrant2.getAddress()+","+ registrant2.getEmail()+",\n");
//            writer.close();
//        } catch(Exception e){
//        }
//    }

}