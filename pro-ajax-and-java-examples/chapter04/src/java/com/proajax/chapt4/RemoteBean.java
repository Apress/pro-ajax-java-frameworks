package com.proajax.chapt4;

import java.util.Date;
import java.util.Random;

public class RemoteBean {

    public String getServerDate() {
        return new Date().toString();
    }
    
    public int calculateCharacterSum(String yourSign) {
        yourSign = yourSign.trim();
        char c = ' ';
        int sum = 0;
        for(int i = 0; i < yourSign.length(); i++) {
            c = yourSign.charAt(i);
            sum = sum + c;
        }
        return sum;
    }
    
    public int getLuckyNumber(String name, String password) {
        int nameHash = name.hashCode();
        int passwordHash = password.hashCode();
        
        return new Random(nameHash + passwordHash).nextInt();
    }
    
    public Person getPerson() {
        Person person = new Person();
        person.setAge(32);
        person.setFirstName("Erik");
        person.setLastName("Tennent");
        
        Address address = new Address();
        address.setId(12);
        address.setAddressLine1("4288 N. James St.");
        address.setCity("Apple Valley");
        address.setState("MN");
        address.setZip("55341-2160");
        person.addAddress(address);
        
        address = new Address();
        address.setId(25);
        address.setAddressLine1("3074 E Bush Lake Road");
        address.setCity("Minneapolis");
        address.setState("MN");
        address.setZip("55041");
        person.addAddress(address);
        
        return person;
    }
    
    public String saveAddress(Address addr) {
        StringBuffer buf = new StringBuffer();
        buf.append("**** Saving Address ****");
        buf.append("\nID: " + addr.getId());
        buf.append("\nAddress Line 1: ");
        buf.append(addr.getAddressLine1());
        buf.append("\nAddress Line 2: ");
        buf.append(addr.getAddressLine2());
        buf.append("\nCity: ");
        buf.append(addr.getCity());
        buf.append("\nState: ");
        buf.append(addr.getState());
        buf.append("\nZip: ");
        buf.append(addr.getZip());
        
        System.out.println(buf.toString());
        
        return "Successful Save of Address.";
        
    }

    public BankAccount getBankAccount() {
        return new BankAccount();
    }
}
